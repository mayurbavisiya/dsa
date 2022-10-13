package dsa.strings;

public class Program57 {
	static int isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i <= j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else {
				return 0;
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		String s = "rhar";
		System.out.println(isPalindrome(s));
	}
}
