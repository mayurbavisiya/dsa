package dsa.strings;

public class Program65 {
	public static void main(String[] args) throws Exception {
		printSS("abc");
	}

	public static void printSS(String str) {
		print("", str, 0, str.length());
	}

	private static void print(String res, String s, int i, int l) {
		if (i == l) {
			System.out.println(res);
			return;
		}
		print(res, s, i + 1, l);
		res += s.charAt(i);
		print(res, s, i + 1, l);
	}

}
