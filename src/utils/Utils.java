package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Utils {
	public static String dateFormatter(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	
	public static boolean isGreaterThanToday(Date date) {  //if the date is equals or greater than today return true else false
		LocalDate now = LocalDate.now();
		LocalDate date2 = LocalDate.parse(Utils.dateFormatter(date));
		if(now.compareTo(date2) >= 0)
			return true;
		else 
			return false;
	}
	
	public static Date dateFromString(String toParse) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(toParse);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
