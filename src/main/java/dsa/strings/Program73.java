package dsa.strings;

public class Program73 {

	public static void main(String[] args) {
		rabinKarp("AABAACAADAABAABA", "AABA");
	}

	private static void rabinKarp(String s, String p) {
		int temp = 0, plen = p.length(), j = 0, ind = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == p.charAt(j)) {
				temp++;
				j++;
			} else {
				j = 0;
				temp = 0;
			}
			if (temp == plen) {
				System.out.println("index : " + (i - plen + 1));
				j = 0;
				temp = 0;
				i--;
			}
			if (j == plen) {
				j = 0;
				temp = 0;
			}
		}
	}
}
