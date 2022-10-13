package dsa.strings;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
		public static int romanToInt(String s) {
			Map<String, Integer> rm = new HashMap<String, Integer>();
			rm.put("I", 1);
	
			rm.put("IV", 4);
			rm.put("V", 5);
	
			rm.put("IX", 9);
			rm.put("X", 10);
	
			rm.put("XL", 40);
			rm.put("L", 50);
	
			rm.put("XC", 90);
			rm.put("C", 100);
	
			rm.put("CD", 400);
			rm.put("D", 500);
	
			rm.put("CM", 900);
			rm.put("M", 1000);
	
			int number = 0;
			for (int i = 0; i < s.length(); i++) {
				if (rm.containsKey(s)) {
					return rm.get(s);
				}
				if (i + 1 < s.length() && rm.containsKey(s.substring(i, i + 2))) {
					number += rm.get(s.substring(i, i + 2));
					i++;
				} else if (rm.containsKey(String.valueOf(s.charAt(i)))) {
					number += rm.get(String.valueOf(s.charAt(i)));
				}
			}
			return number;
		}

	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCIV"));
	}
}
