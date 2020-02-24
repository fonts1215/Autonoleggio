package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.SimpleFormatter;
import java.util.regex.Pattern;

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
	
	public static boolean isLowerThanToday(LocalDate date) {  //if the date is equals or lower than today return true else false
		LocalDate now = LocalDate.now();
		System.out.println(now.compareTo(date));
		if(now.compareTo(date) <= 0)
			return true;
		else 
			return false;
	}
	
	public static boolean isLowerThanToday(Date date) {  //if the date is equals or greater than today return true else false
		LocalDate now = LocalDate.now();
		LocalDate date2 = LocalDate.parse(Utils.dateFormatter(date));
		System.out.println(now.compareTo(date2));
		if(now.compareTo(date2) <= 0)
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
	
	public static boolean validateTarga(String targa) {
		targa = targa.toUpperCase();
		String regex = "[A-Z a-z]{2}[0-9]{3}[A-Z a-z]{2}";
		return Pattern.matches(regex, targa);
	}
	
	public static boolean validateDataNoleggio(Date dataInizio, Date dataFine) {
		LocalDate now = LocalDate.now();
		if(dataInizio != null && dataFine != null) {
			LocalDate inizio = LocalDate.parse(Utils.dateFormatter(dataInizio));
			LocalDate fine = LocalDate.parse(Utils.dateFormatter(dataFine));
			if(now.compareTo(inizio) <= 0) {
				if(inizio.compareTo(fine) <= 0)
					return true;
				else {
					return false;
				}
			}else {
				return false;

			}
		}
		else {
			return false;
		}
	}
}
