package dsa.strings;

public class ValidPalindromeII {

	public static boolean validPalindrome(String s) {
		if (s.length() <= 2)
			return true;
		return right(s) || left(s);
	}

	private static boolean left(String s) {
		int i = 0, j = s.length() - 1, count = 0;
		while (i < j) {
			if (count > 1)
				return false;
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else {
				count++;
				i++;
			}
		}

		return count <= 1 ? true : false;
	}

	private static boolean right(String s) {
		int i = 0, j = s.length() - 1, count = 0;
		while (i < j) {
			if (count > 1)
				return false;
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else {
				count++;
				j--;
			}
		}

		return count <= 1 ? true : false;
	}

	public static void main(String[] args) {
		System.out.println(validPalindrome("deeee"));
	}
}
