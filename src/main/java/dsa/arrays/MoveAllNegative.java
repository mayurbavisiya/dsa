package dsa.arrays;

public class MoveAllNegative {

	public static void main(String[] args) {
		int[] a = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
		sort012(a, a.length);
	}

	public static void sort012(int a[], int n) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0) {
				if (i == 0)
					continue;
				int t = i;
				do {
					t--;
				} while (t >= 0 && a[t] > 0);
				t++;
				int temp = a[i];
				a[i] = a[t];
				a[t] = temp;

			}
		}
	}

}
