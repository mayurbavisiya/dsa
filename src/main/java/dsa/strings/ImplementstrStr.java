package dsa.strings;

public class ImplementstrStr {

	public static void main(String[] args) {
		System.out.println(strStr("aaa", "aaaa"));
	}

	public static int strStr(String haystack, String needle) {
		if (needle == null || needle.isEmpty())
			return 0;
		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				if (getIndex(haystack, needle, i))
					return i;
				else
					continue;
			}
		}
		return -1;
	}

		private static boolean getIndex(String haystack, String needle, int i) {
			if(needle.length() > haystack.length() - i)
				return false;
			int t = 0;
			while (t < needle.length() && i < haystack.length()) {
				if (needle.charAt(t) == haystack.charAt(i)) {
					t++;
					i++;
				} else {
					return false;
				}
			}
			return true;
		}
}
