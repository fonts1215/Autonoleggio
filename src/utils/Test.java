package utils;

import database.DaoFactory;

public class Test {
	public static void main(String[] args) {
		/*List<Veicolo> veicoli = new ArrayList<Veicolo>();
		Categoria categoria = new Categoria("asd", "asd", 0, 0, 0);
		veicoli.add(new Veicolo(0.0, "Grigio", "Fiat", "500", 4, "A", categoria));
		veicoli.add(new Veicolo(0.0, "Grigio", "Fiat", "500", 4, "B", categoria));
		veicoli.add(new Veicolo(0.0, "Grigio", "Fiat", "500", 4, "C", categoria));
		veicoli.add(new Veicolo(0.0, "Grigio", "Fiat", "500", 4, "D", categoria));
		veicoli.add(new Veicolo(0.0, "Grigio", "Fiat", "Panda", 4, "z", categoria));
		veicoli.add(new Veicolo(0.0, "Grigio", "Fiat", "Panda", 4, "q", categoria));
		veicoli.add(new Veicolo(0.0, "Grigio", "asd", "asd", 4, "qwe", categoria));
		
		Set<Veicolo> veicoliSet = new TreeSet<>((Veicolo o1, Veicolo o2) -> {
			int risultato = o1.getMarca().compareTo(o2.getMarca());
			if (risultato == 0) {
				risultato = o1.getModello().compareTo(o2.getModello());
			}
			return risultato;
		});
		
		veicoliSet.addAll(veicoli);
		
		Map<String, List<Veicolo>> veicoliDivisi = veicoliSet.stream()
				.collect(Collectors.groupingBy(Veicolo::getMarcaModello, Collectors.toList()));
		for(Veicolo v : veicoliSet) {
			System.out.println(v.getModello());
		}*/
		
		Utils.bestCategoria();
	}
}
