package dsa.strings;

import java.util.ArrayList;
import java.util.List;

public class Program66 {
	public static List<String> find_permutation(String s) {
		List<String> res = new ArrayList<String>();
		perm(res, s, 0, s.length() - 1);
		return res;
	}

	private static void perm(List<String> res, String s, int l, int r) {
		if (l == r) {
			res.add(s);
		}
		for (int i = l; i <= r; i++) {
			s = swap(s, l, i);
			perm(res, s, l + 1, r);
			s = swap(s, l, i);
		}
	}

	private static String swap(String s, int i, int j) {
		char temp;
		char[] charArray = s.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	public static void main(String[] args) {
		String s = "ABC";
		System.out.println(find_permutation(s));
	}
}
