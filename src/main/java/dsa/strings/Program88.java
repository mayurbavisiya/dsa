package dsa.strings;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Program88 {

	public static void main(String[] args) {
		System.out.println(findSubString("AABBBCBBAC"));
	}

	public static String findSubString(String str) {
		HashSet<Character> hs = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			hs.add(str.charAt(i));
		}
		StringBuilder sb = new StringBuilder();
		for (Character c : hs) {
			sb.append(c);
		}

		int windoSize = sb.length(), minLength = Integer.MAX_VALUE;
		String windowString = sb.toString(), res = "", finalString = "";
		Queue<Character> q = new LinkedList<>();
		for (int i = 0; i < str.length(); i++) {
			q.add(str.charAt(i));
			if (q.size() >= windoSize) {
				if (contains(q, windowString)) {
					char ch = 0;
					while (!q.isEmpty() && contains(q, windowString)) {
						ch = q.poll();
					}
					res = (ch != 0 ? ch : "") + "" + getString(q);
					if (res.length() < minLength) {
						minLength = res.length();
						finalString = res;
					}
				}
			}
		}

		return finalString;
	}

	private static String getString(Queue<Character> q) {
//		Queue<Character> tq = new LinkedList<Character>(q);
		String res = "";
//		while (!tq.isEmpty()) {
//			res += tq.poll();
//		}
		
		for (Character c: q) {
			res += c;
        }		
		return res;
	}

	private static boolean contains(Queue<Character> q, String windowString) {
		int[] arr = new int[256];
		for (Character c: q) {
			arr[c]++;
        }
		for (int i = 0; i < windowString.length(); i++) {
			if (arr[windowString.charAt(i)] == 0) {
				return false;
			}
		}
		return true;
	}
}
