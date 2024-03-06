package Dynamic_Programming;

import java.time.Duration;
import java.time.Instant;
//import org.apache.commons.lang3.time.StopWatch;

public class basic {
	
	
	public static int min_steps_brute(int n)
	{
		if(n == 1)
		{
			return 0;
		}
		
		if(n % 3 == 0)
		{
			return 1 + min_steps_brute(n / 3);
		}
		else if(n % 2 == 0)
		{
			return 1 + min_steps_brute(n / 2);
		}
		else {
			return 1 + min_steps_brute(n - 1);	
		}
		 
	}
	
	public static int min_steps_better(int n)
	{
		if(n == 1)
		{
			return 0;
		}
		
		int case1 = min_steps_better(n - 1);
		int case2 = Integer.MAX_VALUE;
		if (n % 3 == 0) {
			case2 = min_steps_better(n / 3);
		}
		int case3 = Integer.MAX_VALUE;
		if (n % 2 == 0) {
			case3 = min_steps_better(n / 2);
		}
		int ans = Math.min(case1, Math.min(case2, case3)) + 1; 
		
		return ans;
	}	
	
	public static int min_steps_better_dp(int n, int[] dp)
	{
		if(n == 1)
		{
			return 0;
		}
		int case1, case2, case3;
		if (dp[n - 1] == -1) {
			case1 = min_steps_better_dp(n - 1, dp);
			dp[n - 1] = case1;		
		}else {
			case1= dp[n - 1];
		}
		
		case2 = Integer.MAX_VALUE;
		if (n % 3 == 0) {
			if (dp[n / 3] == -1) {
				case2 = min_steps_better_dp(n / 3, dp);
				dp[n / 3] = case2;		
			}else {
				case2 = dp[n / 3];
			}
		}

		case3 = Integer.MAX_VALUE;
		if (n % 2 == 0) {
			if (dp[n / 2] == -1) {
				case3 = min_steps_better_dp(n / 2, dp);
				dp[n / 2] = case3;		
			}else {
				case3 = dp[n / 2];
			}
		}
		int ans = Math.min(case1, Math.min(case2, case3)) + 1; 
		
		return ans;
	}	
	
	public static void main(String[] args) {
		
		
		int n = 106;
//		int x =

		int[] dp = new int[n + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		
//		System.out.println(min_steps_brute(n));
		
		long start1 = System.nanoTime();
		System.out.println(min_steps_better(n));
		long end1 = System.nanoTime();
		
		long start2 = System.nanoTime();
		System.out.println(min_steps_better_dp(n, dp));
		long end2 = System.nanoTime();
		
		System.out.println(end1 - start1);
		System.out.println(end2 - start2);
	}

}
