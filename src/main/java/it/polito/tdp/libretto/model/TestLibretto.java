package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		
		Libretto lib = new Libretto();
		
		lib.add(new Voto("Fisica 2", 21, LocalDate.of(2021, 1, 28)));
		lib.add(new Voto("Analisi 1", 25, LocalDate.of(2022, 1, 28)));
		lib.add(new Voto("Fisica 1", 22, LocalDate.of(2021, 7, 21)));
		lib.add(new Voto("Analisi 2", 27, LocalDate.of(2022, 2, 18)));

		System.out.println("\nStampa corsi");
		lib.stampa();
		
		System.out.println("\nStampa corsi con punti=25");
		lib.stampaCorsiConVotoX(25);
		
		System.out.println("\nStampa voti con nome corso Analisi 1");
		try {
		lib.StampaVoto(lib.cercaVoto("Analisi 1"));
		//lib.StampaVoto(lib.cercaVoto("Analisi 3"));
		}catch(RuntimeException e) {
			//e.printStackTrace();
			System.out.println("Voto non trovato");
		}
		
		//4
		System.out.println("\ncreo nuovi voti");
		Voto nuovo1= new Voto("Statistica", 22, LocalDate.of(2023, 7, 22));
		Voto nuovo2 = new Voto("Fisica 2", 21, LocalDate.of(2021, 1, 28));
		System.out.println("\nverifico esistenza nuovi voti\n");
		if(lib.esisteVoto(nuovo1))	
			System.out.println(nuovo1.toString()+" esiste");
		else
			System.out.println(nuovo1.toString()+" non esiste");

		if(lib.esisteVoto(nuovo2))	
			System.out.println(nuovo2.toString()+" esiste");
		else
			System.out.println(nuovo2.toString()+" non esiste");
		
		

		//5
		System.out.println("\nverifico esistenza conflitti\n");
		if(lib.isConflitto(nuovo1))
			System.out.println("conflitto per "+nuovo1.toString());
		else
			System.out.println("nessun conflitto per "+nuovo1.toString());

		if(lib.isConflitto(nuovo2))
			System.out.println("conflitto per "+nuovo2.toString());
		else
			System.out.println("nessun conflitto per "+nuovo2.toString());
		
		//6
		System.out.println("\nadd V2");
		//lib.stampa();
		lib.addV2(nuovo1);
		lib.addV2(nuovo2);
		System.out.println("\n");
		lib.stampa();
		
		//7
		/*
		System.out.println("\n LIBRETTO MIGLIORATO\n");
		Libretto migliorato = lib.librettoMigliorato(); 
		migliorato.stampa();
		System.out.println("\n STAMPA LIBRETTO ORIGINARIO\n");
		lib.stampa();
		*/
		
		//8
		System.out.println("\nOrdine alfabetico");
		lib.ordinaAlfabeticamente().stampa();
		
		
		System.out.println("\nOrdine decrescenti punti");
		lib.ordinaPerPunti().stampa();
		
		//9
		System.out.println("\nElimino voti sotto al 24");
		lib.depurazioneLibretto();
		lib.stampa();
		
	}

}
