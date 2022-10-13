package dsa.strings;

public class ValidShuffleofTwoStringorNot {

	private static boolean isValidShuffledString(String a, String b, String c) {
		int i = 0, j = 0;
		if (a.length() + b.length() != c.length())
			return false;
		for (int j2 = 0; j2 < c.length(); j2++) {
			if (i < a.length() && c.charAt(j2) == a.charAt(i)) {
				i++;
			} else if (j < b.length() && c.charAt(j2) == b.charAt(j)) {
				j++;
			}

		}
		if (i == a.length() && j == b.length())
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isValidShuffledString("abc", "adb", "adbacb"));
	}
}
