package BITMANUPULATION;

public class Basics {
	
	public static boolean check_ith_set(int N, int i)
	{
		int out = 1 & (N >> (i - 1));
		if (out == 1) {
			return true;
		}
		return false;
	}
	
	
	public static int set_ith(int N, int i)
	{
		int out = N | (1 << (i - 1));
		return out;
	}
	
	public static int unset_ith(int N, int i)
	{
		int out = N & ~(1 << i);
		return out;
	}	
	
	public static int flip_ith(int N, int i)
	{
		int out = N ^ (1 << i);
		return out;
	}	
	
	public static boolean odd_or_not(int N)
	{
		int out = N & 1;
		if (out == 1) {
			return true;
		}
		return false;
	}

	public static boolean isPowerTwo(int N)
	{
		int out = N & (N - 1);
		if (out == 0) {
			return true;
		}
		return false;
	}
	
	public static int clearFirstSetBit(int N)
	{
		int M = N & ~(N - 1);
		int out = N ^ M;
		return out;
	}
	public static void main(String[] args) {
//		System.out.println(check_ith_set(10, 1));
//		System.out.println(set_ith(4, 4));
//		System.out.println(unset_ith(12, 1));
//		System.out.println(flip_ith(4, 2));
		System.out.println(odd_or_not(10));
		System.out.println(isPowerTwo(32));
		System.out.println(clearFirstSetBit(12));

	}

}
