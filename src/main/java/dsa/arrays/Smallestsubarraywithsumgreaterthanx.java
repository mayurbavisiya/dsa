package dsa.arrays;

public class Smallestsubarraywithsumgreaterthanx {
	public static int smallestSubWithSum(int a[], int n, int x) {
		int res = Integer.MAX_VALUE, curSum = 0;
		int i = 0, j = 0;
		boolean flag = false;
		while (i < n) {
			if (a[i] == x) {
				return 1;
			}
			flag = false;
			curSum += a[i];

			if (curSum > x) {
				res = Math.min(res, i - j);

				while (curSum > x) {
					curSum -= a[j];
					j++;
					flag = true;
				}
				j--;
				curSum += a[j];

			}
			if (flag)
				res = Math.min(res, i - j);
			i++;
		}
		return res == Integer.MAX_VALUE ? 0 : res + 1;
	}

	public static void main(String[] args) {
		int[] a = { 1, 10, 5, 2, 7 };
		int n = a.length, x = 9;
		System.out.println(smallestSubWithSum(a, n, x));
	}
}
