package dsa.searching;

public class Program109 {

	public static void main(String[] args) {
		int[] a = { 20, 40, 50, 70, 70, 60 };
		int x = 60, k = 20;
		System.out.println(findIndex(a, x, k));
	}

	public static int findIndex(int[] a, int x, int k) {
		int i = 0, n = a.length;
		while (i < n) {
			if (a[i] == x) {
				return i;
			}

			i = i + Math.max(1, Math.abs(a[i] - x) / k);
		}
		return -1;
	}
}
