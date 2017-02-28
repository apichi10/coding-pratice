package test;

public class SurroundedRegions {

	int[] dx = {0, 1, 0,-1};
	int[] dy = {1, 0,-1, 0};	
	
    public void solve(char[][] board) {
    	for(int x=0; x< board.length; x++) {
    		dfs(board, x, 0);
    		dfs(board, x, board[0].length-1);
    	}
    	for(int y=0; y< board.length; y++) {
    		dfs(board, 0, y);
    		dfs(board, board.length-1, y);
    	}	
    	for(int x = 0; x < board.length; x++) {
    		for(int y = 0; y < board[0].length; y++) {
    			if(board[x][y]=='Y')
    				board[x][y] = 'O';
    			else if(board[x][y]=='O')
    				board[x][y] = 'X';
    		}
    	}  
    }
    
    public void dfs(char[][] board, int x, int y) {
    	if( x < 0 || y < 0 || x > board.length-1 || y > board[0].length-1 )
    		return;
    	if(board[x][y] != 'O')
    		return;
    	board[x][y] = 'Y';
        for(int i = 0; i < 4; i++) {
        	int x1 = x + dx[i];
        	int y1 = y + dy[i];
        	dfs(board, x1, y1);
        }
    }
    /*
    public void flip(char[][] board, int x, int y) {
    	if((x < 0 || y < 0 || x >= board.length || y >= board[0].length) || board[x][y] != 'O')
    		return ;
    	board[x][y] = 'X';
    	for(int i = 0; i > 4; i++) {
        	int x1 = x + dx[i];
        	int y1 = y + dy[i];
        	flip(board, x1, y1);
        }
    }
    */
	public static void main(String[] args) {

	}
 }