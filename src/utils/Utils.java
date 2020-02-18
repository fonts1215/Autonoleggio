package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public static String dateFormatter(Date date) {
		String format = new SimpleDateFormat();
		return format.format(date);
	}
}
