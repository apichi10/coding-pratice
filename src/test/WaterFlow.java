package test;

public class WaterFlow {
	
	public static void main(String[] args) {
		int[][] island = {
				{9,4,8,2,7},
				{1,5,9,5,4},
				{2,7,3,8,6},
				{4,5,4,6,1},
				{1,2,7,9,8}};
		WaterFlow wf = new WaterFlow(island);
		System.out.println(wf.flowsToTheOcean(2,3));

	}
	
	int[][] island;
	int length, height;
	boolean[][] visited;

	public WaterFlow(int[][] island) {
		this.island = island;
		length = island.length-1;
		height = island[0].length-1;
		visited = new boolean[length+1][height+1];
	}

	final static int[] dx = {0, 1, 0, -1};
	final static int[] dy = {1, 0, -1, 0};

	boolean flowsToTheOcean(int x, int y) {
		if(x==0 || y==0 || x==length || y==height)
			return true;
		if(visited[x][y])
			return false;

		for(int i=0; i<=3; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			//newX >= 0 && newY >= 0 && newX <= length && newY <= height &&
			if(!visited[newX][newY] && island[newX][newY] <= island[x][y]) {
				if(flowsToTheOcean(newX, newY))
					return true;
			}
		}
		return false;
	}

}