package Lets_do_Recursion;

import java.util.Scanner;

//import java.security.DomainCombiner;

public class fibonacci_using_recursion {

	public static int factorial(int num) {
		
		if (num == 0 || num == 1) {
			return 1;
		}
		int smallout = factorial(num - 1);
		
		return num * smallout;
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int n = sc.nextInt();
		System.out.println("Factorial of number is: " + factorial(n));
	}
}
