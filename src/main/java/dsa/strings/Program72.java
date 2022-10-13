package dsa.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Program72 {

	public static int wordBreak(String a, List<String> b) {
		Map<String, Integer> hm = new HashMap<String, Integer>();
		int x = solve(a, b, hm);
		return x <= 0 ? 0 : 1;

	}

	private static int solve(String a, List<String> b, Map<String, Integer> hm) {
		int len = a.length();
		if (len == 0)
			return 0;
		if (hm.containsKey(a))
			return hm.get(a);

		for (int i = 1; i <= a.length(); i++) {
			int f = 0;
			String temp = a.substring(0, i);
			if (b.contains(temp)) {
				f = 1;
				hm.put(temp, 1);
			}
			if (f == 1 && solve(a.substring(i, len - i), b, hm) == 1) {
				hm.put(a, 1);
				return 1;

			}
		}

		return -1;
	}

	public static void main(String[] args) {
		String a = "abcd";
		// List<String> b = Arrays.asList(new String[] { "i", "like", "sam",
		// "sung", "samsung", "mobile", "ice", "cream",
		// "icecream", "man", "go", "mango" });
		List<String> b = Arrays.asList(new String[] { "ab", "bcd", "a", "b" });

		System.out.println(wordBreaks(a, b));
	}

	static Set<String> visited = new HashSet<String>();

	public static boolean wordBreaks(String s, List<String> wordDict) {

		if (visited.contains(s)) {
			return false;
		}

		for (String word : wordDict) {
			if (word.equals(s)) {
				return true;
			} else if (s.startsWith(word) && wordBreaks(s.substring(word.length(), s.length()), wordDict)) {
				return true;
			}
		}
		visited.add(s);
		return false;
	}

	public static int wordBreak1(String a, List<String> b) {
		Map<String, Integer> hm = new HashMap<String, Integer>();
		int x = solve1(a, b, hm);
		return x <= 0 ? 0 : 1;

	}

	private static int solve1(String a, List<String> b, Map<String, Integer> hm) {
		if (a.length() == 0) {
			return 0;
		}
		if (hm.containsKey(a))
			return hm.get(a);

		for (int j = 1; j <= a.length(); j++) {
			int f = 0;
			String temp = a.substring(0, j);
			if (b.contains(temp)) {
				f = 1;
				hm.put(temp, 1);
			}
			if (f == 1 && solve1(a.substring(j, a.length() - j), b, hm) == 1) {
				hm.put(a, 1);
				return 1;
			}
		}
		return -1;
	}
}
