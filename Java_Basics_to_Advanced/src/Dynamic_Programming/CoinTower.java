package Dynamic_Programming;

import java.util.Arrays;

public class CoinTower {

	public static int findWinner(int n, int x, int y, int[] dp)
	{
		if (n == 0) {
			return 0;
		}
		
		int ans = 0;
		
		if (dp[n] != -1 ) {
			return dp[n];
		}
		
		if ((n - 1) >= 0 && findWinner((n - 1), x, y, dp) == 0) {
			ans = 1;
		}
		
		if ((n - x) >= 0 && findWinner((n - x), x, y, dp) == 0) {
			ans = 1;
		}
		
		if ((n - y) >= 0 && findWinner((n - y), x, y, dp) == 0) {
			ans = 1;
		}		
		
		dp[n] = ans;
		
		return ans;
	}
		
	public static void coinWinner(int n, int x, int y)
	{
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		
		int ans = findWinner(n, x, y, dp);
		if (ans == 1) {
			System.out.println("A");
		} else {
			System.out.println("B");
		}
	}
	
	public static int IterativeCoinWinner(int n, int x, int y)
	{
		if (n == 0) {
			return 0;
		}
		
		int[] dp = new int[n + 1];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for (int i = 2; i < dp.length; i++) {
			
			if ((i - 1) >= 0 && dp[i - 1] == 0) {
				dp[i] = 1;
			}
			
			if ((i - x) >= 0 && dp[i - x] == 0) {
				dp[i] = 1;
			}
			
			if ((i - y) >= 0 && dp[i - y] == 0) {
				dp[i] = 1;
			}	
			
		}
		
		return dp[n];
		
	}
	
	public static void main(String[] args) {
		coinWinner(7, 4, 3);
		System.out.println(IterativeCoinWinner(7, 4, 3));
	}
	
}
