package dsa.strings;

import java.util.HashMap;
import java.util.Map;

public class Program81 {

	public static int romanToDecimal(String str) {
		Map<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("I", 1);
		hm.put("IV", 4);
		hm.put("V", 5);

		hm.put("IX", 9);
		hm.put("X", 10);

		hm.put("XL", 40);
		hm.put("L", 50);

		hm.put("XC", 90);
		hm.put("C", 100);

		hm.put("CD", 400);
		hm.put("D", 500);
		hm.put("CM", 900);
		hm.put("M", 1000);

		int res = 0;
		for (int i = 0; i < str.length(); i++) {
			if (i + 1 < str.length() && hm.containsKey(String.valueOf(str.charAt(i) + "" + str.charAt(i + 1)))) {
				res += hm.get(String.valueOf(str.charAt(i) + "" + str.charAt(i + 1)));
				i++;
			} else {
				res += hm.get(String.valueOf(str.charAt(i)));
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(romanToDecimal("CMXCIX"));
	}
}
