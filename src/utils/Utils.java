package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.SimpleFormatter;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import database.DaoFactory;
import model.*;

public class Utils {
	public static String dateFormatter(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

	public static boolean isGreaterThanToday(Date date) { // if the date is equals or greater than today return true
															// else false
		LocalDate now = LocalDate.now();
		LocalDate date2 = LocalDate.parse(Utils.dateFormatter(date));
		if (now.compareTo(date2) >= 0)
			return true;
		else
			return false;
	}

	public static boolean isLowerThanToday(LocalDate date) { // if the date is equals or lower than today return true
																// else false
		LocalDate now = LocalDate.now();
		if (now.compareTo(date) <= 0)
			return true;
		else
			return false;
	}

	public static boolean isLowerThanToday(Date date) { // if the date is equals or greater than today return true else
														// false
		LocalDate now = LocalDate.now();
		LocalDate date2 = LocalDate.parse(Utils.dateFormatter(date));
		if (now.compareTo(date2) <= 0)
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
		if (dataInizio != null && dataFine != null) {
			LocalDate inizio = LocalDate.parse(Utils.dateFormatter(dataInizio));
			LocalDate fine = LocalDate.parse(Utils.dateFormatter(dataFine));
			if (now.compareTo(inizio) <= 0) {
				if (inizio.compareTo(fine) <= 0)
					return true;
				else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static double calcolaAmount(Veicolo veicolo, Date inizioD, Date fineD) {
		LocalDate inizio = LocalDate.parse(Utils.dateFormatter(inizioD));
		LocalDate fine = LocalDate.parse(Utils.dateFormatter(fineD));
		Categoria categoria = veicolo.getCategoria();
		double amount = 0.0;
		if (inizio.compareTo(fine) != 0) {
			Period period = Period.between(inizio, fine);
			period.normalized();
			amount = ((period.getDays() + 1) % 7) * categoria.getTGiornaliera()
					+ (period.getDays() / 7) * categoria.getTSettimanale()
					+ period.getMonths() * categoria.getTMensile() + period.getYears() * (categoria.getTMensile() * 12);

			return amount;
		} else {
			amount = categoria.getTGiornaliera();
			return amount;
		}
	}

	public static boolean isAdult(Date birth) {
		LocalDate nascita = LocalDate.parse(Utils.dateFormatter(birth));
		Period period = Period.between(nascita, LocalDate.now());
		period.normalized();
		if (period.getYears() >= 18)
			return true;
		else
			return false;
	}

	public static Categoria bestCategoria() {
		List<Categoria> categorias = DaoFactory.getDaoFactory().getCategoriaDAO().getCategorie();
		List<Noleggio> noleggios = DaoFactory.getDaoFactory().getNoleggioDAO().getNoleggi();
		TreeMap<String, List<Noleggio>> mappaNoleggi = new TreeMap<String, List<Noleggio>>();
		TreeMap<String, Double> mappaRicavato = new TreeMap<String, Double>();
		
		
		Map<String, List<Noleggio>> noleggioFiltered =
			    noleggios.stream().collect(Collectors.groupingBy(n -> n.getVeicolo().getCategoria().getNomeCategoria()));
		
		System.out.println(noleggioFiltered);
		
		for(Map.Entry<String, List<Noleggio>> entry : noleggioFiltered.entrySet()) {
			//TODO Calcolare amount per categoria
		}

		/*for (Categoria categoria : categorias) {
			List<Noleggio> temp = new ArrayList<Noleggio>();
			for (Noleggio noleggio : noleggios) {
				if (noleggio.getVeicolo().getCategoria().getNomeCategoria().equals(categoria.getNomeCategoria()))
					temp.add(noleggio);
			}
			mappaNoleggi.put(categoria.getNomeCategoria(), temp);
		}

		for (String s : mappaNoleggi.keySet()) {
			double count = 0.0;
			List<Noleggio> noleggi = mappaNoleggi.get(s);
			for (Noleggio n : noleggi) {
				count += n.getAmountRental();
			}
			mappaRicavato.put(s, count);
		}

		for (String s : mappaRicavato.keySet()) {
			Categoria c = DaoFactory.getDaoFactory().getCategoriaDAO().findCategoria(s);
			List<Veicolo> v = DaoFactory.getDaoFactory().getVeicoloDAO().getAutoPerCategoria(c);
			Double ricavato = mappaRicavato.get(s);
			mappaRicavato.remove(s);
			mappaRicavato.put(s, ricavato / v.size());
		}*/
		
		return null;
	}
}
