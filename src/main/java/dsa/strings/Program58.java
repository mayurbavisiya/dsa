package dsa.strings;

public class Program58 {

	public static void findDuplicate(String s) {
		int[] ch = new int[26];
		for (int i = 0; i < s.length(); i++) {
			ch[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] > 1) {
				System.out.print((char) (i + 'a'));
			}
		}
	}

	public static void main(String[] args) {
		findDuplicate("aaabbbmayur");
	}
}
