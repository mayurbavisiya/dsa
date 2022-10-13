package dsa.searching;

public class Program104 {

	public static void main(String[] args) {
		int n = 9;
		System.out.println(countSquares(n));
	}

	static int countSquares(int x) { // Base cases
		if (x == 0 || x == 1)
			return x;

		// Staring from 1, try all numbers until
		// i*i is greater than or equal to x.
		int i = 1, result = 1;

		while (i * i < x) {
			i++;
		}
		return i - 1;
	}
}
