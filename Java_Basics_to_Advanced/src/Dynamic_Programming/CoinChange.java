package Dynamic_Programming;

public class CoinChange {
	
	public static int coin(int[] arr, int W, int si)
	{
		if (W <= 0) {
			return ((W == 0) ? 1 : 0);
		}
		if (si == arr.length) {
			return 0;
		}
		
		int case1 = coin(arr, W - arr[si], si);
		int case2 = coin(arr, W, si + 1);

		int ans = case1 + case2;

		return ans;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		int W = 250;
		System.out.println(coin(arr, W, 0));
//		System.out.println(coin(arr, -1, 0));
	}

}
