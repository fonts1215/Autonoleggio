package utils;

import java.time.LocalDate;

public class Test {
	public static void main(String[] args) {
		//Utils.calcolaAmount( , LocalDate.of(2020, 3, 1));
		LocalDate aasd = LocalDate.of(2020, 3, 1);
		
		LocalDate basd = LocalDate.of(2020, 3, 1);
		
		System.out.println(aasd.compareTo(basd));;
	}
}
