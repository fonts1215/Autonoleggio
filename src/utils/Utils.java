package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public static String dateFormatter(Date date) {
		SimpleDateFormat format = new SimpleDateFormat();
		return format.format(date);
	}
}
