package dsa.arrays;

public class Fibonacci {

	public int fib(int n) {
		int[] arr = new int[n + 1];
		return fibUtil(n, arr);
	}

	private int fibUtil(int n, int[] arr) {
		if (arr[n] > 0)
			return arr[n];
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		int temp = fibUtil(n - 1, arr) + fibUtil(n - 2, arr);
		arr[n] = temp;
		return temp;
	}

	public static void main(String[] args) {
		System.out.println(new Fibonacci().fib(10));
	}
}
