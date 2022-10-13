package dsa.searching;

public class Program108 {

	public static void main(String[] args) {
		int[] a = { 1, 2 ,1};
		int size = a.length;
		System.out.println(majorityElement(a, size));
	}

	static int majorityElement(int a[], int size) {
		int major = a[0];
		int count = 1;
		for (int i = 1; i < a.length; i++) {
			if (major == a[i]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				major = a[i];
				count = 1;
			}
		}

		count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == major) {
				count++;
			}
		}
		return (count > (a.length / 2)) ? major : -1;
	}
}
