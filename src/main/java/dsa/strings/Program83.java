package dsa.strings;

public class Program83 {

	public static void main(String[] args) {
		System.out.println(minFlips("1111110000000000000"));
	}

	public static int minFlips(String s) {
		int count = 0;
		StringBuilder sb = new StringBuilder(s);
		for (int i = 1; i < sb.length() - 1; i++) {
			if (sb.charAt(i) == sb.charAt(i - 1) || sb.charAt(i) == sb.charAt(i + 1)) {
				count++;
				if (sb.charAt(i - 1) == sb.charAt(i + 1)) {
					if (sb.charAt(i - 1) == '0') {
						sb.setCharAt(i - 1, '1');
					} else {
						sb.setCharAt(i - 1, '0');
					}
				} else if (sb.charAt(i - 1) == sb.charAt(i)) {
					sb.setCharAt(i - 1, sb.charAt(i + 1));
				} else if (sb.charAt(i) == sb.charAt(i + 1)) {
					sb.setCharAt(i + 1, sb.charAt(i - 1));
				}
			}
		}
		if (sb.charAt(sb.length() - 1) == sb.charAt(sb.length() - 2)) {
			count++;
			if (sb.charAt(sb.length() - 1) == '0') {
				sb.setCharAt(sb.length() - 1, '1');
			} else {
				sb.setCharAt(sb.length() - 1, '0');
			}
		}
		return count;
	}
}
