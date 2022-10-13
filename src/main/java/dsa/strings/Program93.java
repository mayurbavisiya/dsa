package dsa.strings;

public class Program93 {

	public static String removeConsecutiveCharacter(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));
			while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
				i++;
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(removeConsecutiveCharacter("aabb"));
	}
}
