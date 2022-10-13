package dsa.strings;

import java.util.Stack;

public class Program71 {

	public static void main(String[] args) {
		System.out.println(ispar(")"));
	}

	
	static boolean ispar(String x) {
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < x.length(); i++) {
			if (x.charAt(i) == ']') {
				if (!st.isEmpty() && st.pop() == '[')
					continue;
				else
					return false;
			} else if (x.charAt(i) == ')') {
				if (!st.isEmpty() && st.pop() == '(')
					continue;
				return false;
			} else if (x.charAt(i) == '}') {
				if (!st.isEmpty() && st.pop() == '{')
					continue;
				return false;
			} else if (x.charAt(i) == '[' || x.charAt(i) == '(' || x.charAt(i) == '{')
				st.push(x.charAt(i));
			else
				return false;
		}
		if (!st.isEmpty())
			return false;
		return true;
	}
}
