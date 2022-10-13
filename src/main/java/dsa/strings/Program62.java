package dsa.strings;

public class Program62 {

	public static void main(String[] args) {
		System.out.println(countAndSay(4));
	}

	public static String countAndSay(int n) {
		StringBuilder s = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				s.append("1");
			} else {
				StringBuilder temp = new StringBuilder();
				char ch = s.charAt(0);
				int count = 1;
				for (int j = 1; j < s.length(); j++) {
					if (ch == s.charAt(j)) {
						count++;
					} else {
						temp.append(count).append(ch);
						ch = s.charAt(j);
						count = 1;
					}
				}
				temp.append(count).append(ch);
				s = temp;
			}
		}
		return s.toString();
	}
}
