package leetcode;

public class CoinChange {
	/*
		You are given coins of different denominations and a total amount of money amount. 
		Write a function to compute the fewest number of coins that you need to make up that amount. 
		If that amount of money cannot be made up by any combination of the coins, return -1.
		
		Example 1:
		coins = [1, 2, 5], amount = 11
		return 3 (11 = 5 + 5 + 1)
		
		Example 2:
		coins = [2], amount = 3
		return -1.
		
		Note:
		You may assume that you have an infinite number of each kind of coin.
	*/
	
	public static void main(String[] args) {
		CoinChange cc = new CoinChange();
		//[186,419,83,408] 6249
		//new int[]{3,7,405,436}, 8839
		int ans = cc.coinChange(new int[]{186,419,83,408}, 6249);
		System.out.println(ans);
	}
	
	public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0)
            return -1;
        if(amount==0)
            return 0;
        int[] dp = new int[amount+1];
        return coinChange(coins, amount,dp);
    }
    
    public int coinChange(int[] coins, int amount, int[] dp) {
        
    	if(dp[amount] != 0)
    		return dp[amount];
    	int min = Integer.MAX_VALUE;
    	for(int coin: coins) {
    		if(amount < coin)
    			continue;
    		else if(amount == coin) {
    			dp[amount] = 1;
    			return 1;
    		} else {
    			int num = coinChange(coins, amount-coin, dp);
    			if(num>0 && num+1 < min)
    				min = num+1;
    		}
    	}
    	dp[amount] = (min>0 && min<Integer.MAX_VALUE) ? min : -1;
        return min!=Integer.MAX_VALUE ? min: -1;
    }
}
