package dsa.strings;

public class Program61 {

	public static void main(String[] args) {
		String s1 = "onetwofour", s2 = "hellofourtwooneworld";
		int[] indices = { 4, 5, 6, 7, 0, 2, 1, 3 };
		// System.out.println(isShuffleString(s1, s2));
		System.out.println(restoreString("codeleet", indices));
	}

	public static String restoreString(String s, int[] indices) {
		char arr[] = new char[indices.length];
		for (int i = 0; i < s.length(); i++) {
			arr[indices[i]] = s.charAt(i);
		}
		String shuffle = new String(arr);
		return shuffle;
	}

	// static boolean search(String pat, String txt)
	// {
	// int M = pat.length();
	// int N = txt.length();
	//
	// // countP[]: Store count of all
	// // characters of pattern
	// // countTW[]: Store count of
	// // current window of text
	// int []countP = new int [256];
	// int []countTW = new int [256];
	// for(int i = 0; i < M; i++)
	// {
	// (countP[pat.charAt(i)-'a'])++;
	// (countTW[txt.charAt(i)-'a'])++;
	// }
	//
	// // Traverse through remaining
	// // characters of pattern
	// for(int i = M; i < N; i++)
	// {
	//
	// // Compare counts of current
	// // window of text with
	// // counts of pattern[]
	// if (compare(countP, countTW))
	// return true;
	//
	// // Add current character to
	// // current window
	// (countTW[txt.charAt(i)-'a'])++;
	//
	// // Remove the first character
	// // of previous window
	// countTW[txt.charAt(i - M)-'a']--;
	// }
	//
	// // Check for the last window in text
	// if (compare(countP, countTW))
	// return true;
	// return false;
	// }
	//
	//
	private static boolean isShuffleString(String s1, String s2) {
		if (s2.length() < s1.length()) {
			return false;
		}
		int[] patternChar = new int[26];
		int[] string2Char = new int[26];

		for (int i = 0; i < s1.length(); i++) {
			patternChar[s1.charAt(i) - 'a']++;
			string2Char[s2.charAt(i) - 'a']++;
		}

		for (int i = s1.length(); i < s2.length(); i++) {

			if (compare1(patternChar, string2Char)) {
				return true;
			}

			string2Char[s2.charAt(i) - 'a']++;
			string2Char[s2.charAt(i - s1.length()) - 'a']--;

			if (compare1(patternChar, string2Char)) {
				return true;
			}
		}

		return false;

	}

	static boolean compare(int[] arr1, int[] arr2) {
		for (int i = 0; i < 256; i++)
			if (arr1[i] != arr2[i])
				return false;

		return true;
	}

	private static boolean compare1(int[] patternChar, int[] string2Char) {
		for (int i = 0; i < string2Char.length; i++) {
			if (patternChar[i] != string2Char[i]) {
				return false;
			}
		}
		return true;
	}
}
