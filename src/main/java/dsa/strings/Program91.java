package dsa.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program91 {

	public static List<List<String>> Anagrams(String[] string_list) {

		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

		for (int i = 0; i < string_list.length; i++) {

			String val = string_list[i];

			char[] c = val.toCharArray(); // convert to array of chars

			java.util.Arrays.sort(c); // sort

			String newString = new String(c);

			if (!map.containsKey(newString))

				map.computeIfAbsent(newString, k -> new ArrayList<>()).add(val);

			else {

				ArrayList<String> list = map.get(newString);

				list.add(val);

				map.put(newString, list);

			}

		}

		List<List<String>> res = new ArrayList<List<String>>();

		for (Map.Entry<String, ArrayList<String>> en : map.entrySet()) {

			res.add(en.getValue());

		}

//		System.out.println(map);

		return res;

		// Code here
	}

	private static int getHashcode(String string) {
		int Q = 1001;
		int b = 13;
		int m = string.length();
		int hash = 0;
		for (int i = 0; i < m; i++) {
			int charCode = string.charAt(i);
			hash = (hash + charCode * (b * (m - i - 1))) % Q;
		}

		return hash % Q;
	}

	public static void main(String[] args) {
		String[] s = { "act", "god", "cat", "dog", "tac" };
		System.out.println(Anagrams(s));
	}
}
