package Dynamic_Programming;

import java.util.HashMap;

public class MaxTip {
	
	public static int maxTipdelivery(int[] A, int[] B, int N, int ai,
									 int bi, int X, int Y,
									 HashMap<String, Integer> map)
	{
		
		if (ai == N && bi == N) {
			return 0;
		}
		if (X == 0 || ai == N) {
			return B[bi];
		}
		if (Y == 0 || bi == N) {
			return A[ai];
		}
		String key = Integer.toString(ai) + "_" + Integer.toString(bi) + "_" 
				 + Integer.toString(X) + "_" + Integer.toString(Y);
		
		if (map.get(key) != null) {
			return map.get(key);
		}
		
		int case1 = A[ai] + maxTipdelivery(A, B, N, ai + 1, bi + 1, X - 1, Y, map);
		int case2 = B[bi] + maxTipdelivery(A, B, N, ai + 1, bi + 1, X, Y - 1, map);
		int ans = Math.max(case1, case2);
		
		map.put(key, ans);
		return ans;
	}
	
	public static void main(String[] args) {
		
		int N = 5, X = 4, Y = 4; 
		int[] A = {1,2,3,4,5};
		int[] B = {5,4,3,2,1};
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		System.out.println(maxTipdelivery(A, B, N, 0, 0, X, Y, map));
	}

}
