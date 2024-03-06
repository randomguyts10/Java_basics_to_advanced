package Lets_do_Recursion;

public class Assignment_3 {
	
	public static float gp_sum(int k)
	{
		if (k == 0) {
			return 1f; 
		}
		
		float smallout = 0.5f * gp_sum(k - 1);
		
		return 1f + smallout;
				
	}

	public static double gp_sum_2(int k)
	{
		if (k == 0) {
			return 1; 
		}
		
		double smallout = gp_sum_2(k - 1);
		
		return smallout + (1 / Math.pow(2, k));
				
	}
	
	public static int sumd(int num) {
		
		if (num < 10) {
			return num;			
		}
		
		int smallout = sumd(num / 10);
		
		return (num % 10) + smallout;
		
	}

	public static boolean palindrome(String s, int startidx, int endidx)
	{
		if (startidx > endidx) {
			return true;
		}
		
		if (s.charAt(startidx) != s.charAt(endidx)) {
			return false;
		}else {
			return palindrome(s, startidx + 1, endidx - 1);
		}
	}

	public static boolean palindrome(String s)
	{
		int si = 0;
		int ei = s.length() - 1;
		return palindrome(s, si, ei);
	}
	
	public static String removeX(String str) {
		
		if (str.length() == 0) {
			
			return str;
			
		}
		
		String ans = "";
		if (str.charAt(0) != 'x') {
			ans += str.charAt(0);
		}
		
		String smallout = removeX(str.substring(1));
		
		return ans + smallout;
	}

	public static void main(String[] args) {
		
//		int k = 3;
//		System.out.println(gp_sum(k));
//		System.out.println(gp_sum_2(k));
		
//		int num = 12345;
//		System.out.println(sumd(9));
		
//		String s = "NamaN";
//		System.out.println(palindrome(s));
		
		String s = "xxabxcdsxe";
		System.out.println(removeX(s));
	}

}
