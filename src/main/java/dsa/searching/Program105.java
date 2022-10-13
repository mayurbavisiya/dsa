package dsa.searching;

public class Program105 {

	public static void main(String[] args) {
		System.out.println(middle(978, 518, 300));
	}

	static int middle(int A, int B, int C) {
		if ((A > B && B > C) || (C > B && B > A)) {
			return B;
		} else if ((B > A && A > C) || (C > A && A > B)) {
			return A;
		} else
			return C;
	}
}
