package dsa.strings;

public class Program67 {

	public static void main(String[] args) {
		System.out.println(count("00110011"));
	}

	public static int count(String s) {
		int count = 0, noOf0 = 0, noOf1 = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				noOf0++;
			} else if (s.charAt(i) == '1') {
				noOf1++;
			}
			if (noOf0 >= 0 && noOf0 == noOf1) {
				count++;
//				noOf0 = 0;
//				noOf1 = 0;
			}
		}
		return count == 0 ? -1 : count;
	}

}
