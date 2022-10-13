package dsa.hash.easy;

public class VerifyingAlienDictionary {

	public static boolean isAlienSorted(String[] words, String order) {
		int[] dict = new int[26];
		for (int i = 0; i < order.length(); i++) {
			char c = order.charAt(i);
			dict[c - 'a'] = i;
		}
		if (words.length <= 1)
			return true;
		for (int i = 1; i < words.length; i++) {
			if (!order(words[i - 1], words[i], dict))
				return false;
		}
		return true;
	}

	public static boolean order(String one, String two, int[] dict) {
		boolean same = true;
		for (int i = 0; i < one.length() && i < two.length(); i++) {
			char o = one.charAt(i);
			char t = two.charAt(i);
			if (o == t) {
				continue;
			}
			if (o != t)
				same = false;

			if (!same) {
				return dict[o - 'a'] < dict[t - 'a'] ? true : false;
			}
		}
		if (one.length() > two.length()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String[] words = { "word", "world", "row" };
		System.out.println(isAlienSorted(words, "worldabcefghijkmnpqstuvxyz"));
	}
}
