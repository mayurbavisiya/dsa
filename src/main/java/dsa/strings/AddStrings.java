package dsa.strings;

public class AddStrings {
	public static String addStrings(String num1, String num2) {
		String longStr, shortStr;
		if (num1.length() >= num2.length()) {
			longStr = num1;
			shortStr = num2;
		} else {
			longStr = num2;
			shortStr = num1;
		}
		StringBuilder res = new StringBuilder();
		int i = shortStr.length() - 1, j = longStr.length() - 1;
		int carry = 0;
		while (j >= 0 && i >= 0) {
			int temp = carry + (longStr.charAt(j) - '0') + (shortStr.charAt(i) - '0');
			if (temp > 9) {
				carry = 1;
				res.insert(0, temp % 10);
			} else {
				res.insert(0, temp);
				carry = 0;
			}
			j--;
			i--;
		}
		while (j >= 0) {
			int temp = carry + (longStr.charAt(j) - '0');
			if (temp > 9) {
				carry = 1;
				res.insert(0, temp % 10);
			} else {
				res.insert(0, temp);
				carry = 0;
			}
			j--;

		}
		if (carry > 0)
			res.insert(0, carry);
		return res.toString();
	}

	public static void main(String[] args) {

		String num1 = "6994", num2 = "36";
		System.out.println(addStrings(num1, num2));
	}
}
