package dsa.strings;

public class Program60 {

	public static boolean isRotationString(String a, String b) {
		int index = 0;
		for (int i = 0; i < a.length(); i++) {
			if (b.charAt(0) == a.charAt(i)) {
				index = i;
				break;
			}
		}

		int k = 0;
		for (int i = index; i < a.length(); i++) {
			if (b.charAt(k++) == a.charAt(i)) {
				continue;
			} else {
				return false;
			}
		}

		for (int i = 0; i < index; i++) {
			if (b.charAt(k++) == a.charAt(i)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isRotationString("ABCD", "CDAB"));
	}
}
