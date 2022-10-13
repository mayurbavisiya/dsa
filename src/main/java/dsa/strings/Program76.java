package dsa.strings;

import java.util.Stack;

public class Program76 {

	public static void main(String[] args) {
		System.out.println(countRev("}{{}}{{{"));
	}

	static int countRev(String s) {
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '}') {
				if (!st.isEmpty() && st.peek() == '{') {
					st.pop();
				} else {
					st.push(s.charAt(i));
				}
			} else {
				st.push(s.charAt(i));
			}
		}
		if (st.size() % 2 != 0)
			return -1;

		StringBuilder sb = new StringBuilder();
		while (!st.isEmpty()) {
			sb.append(st.pop());
		}
		for (int i = 0; i < sb.length(); i++) {
			st.add(sb.charAt(i));
		}

		int count = 0;
		char expectedChar = '{';
		int i = 0;
		while (!st.isEmpty()) {
			i++;
			if (i % 2 == 0) {
				expectedChar = '}';
			} else {
				expectedChar = '{';
			}
			char c = st.pop();
			if (c != expectedChar) {
				count++;
			}
		}

		return count;
	}
}
