package dsa.strings;

public class Program56 {
	public static void reverseString(char[] s) {
		int i = 0, j = s.length - 1;
		while (i <= j) {
			char c = s[i];
			s[i] = s[j];
			s[j] = c;
			i++;
			j--;
		}
		System.out.println(s);
	}

	public static void main(String[] args) {
		char[] s = "mayur".toCharArray();
		reverseString(s);
	}
}
