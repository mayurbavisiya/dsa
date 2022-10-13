package dsa.strings;

import java.util.Date;

public class test {

	public static void main(String[] args) {
		Date date = java.util.Calendar.getInstance().getTime();
		if (date.getHours() > 6 && date.getMinutes() > 8)
			System.out.println(date.getHours());
	}
}
