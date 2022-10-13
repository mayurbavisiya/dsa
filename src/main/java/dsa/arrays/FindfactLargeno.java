package dsa.arrays;

import java.util.ArrayList;

public class FindfactLargeno {

	public static void main(String[] args) {
		int a = 24;
		System.out.println(a / 10);
		System.out.println(a % 10);
		System.out.println(factorial(10));
	}

	// public static long factorial(int n) {
	// long[] dp = new long[n + 1];
	// return fact(dp, n);
	// }
	//
	// private static long fact(long[] dp, int n) {
	// if (n == 0 || n == 1) {
	// return 1;
	// }
	// if (dp[n] == 0)
	// dp[n] = n * fact(dp, n - 1);
	//
	// return dp[n];
	// }
	//
	static ArrayList<Integer> factorial(int n) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		if (n == 0)
			return al;

		al.add(1);
		int carry = 0;
		for (int i = 2; i <= n; i++) {
			for (int j = al.size() - 1; j >= 0; j--) {
				int temp = al.get(j) * i + carry;
				al.set(j, temp % 10);
				carry = temp / 10;
			}
			while (carry != 0) {
				al.add(0, carry % 10);
				carry = carry / 10;
			}
		}

		return al;
	}
}
