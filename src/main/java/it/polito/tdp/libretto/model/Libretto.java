package it.polito.tdp.libretto.model;

import java.util.*;

import it.polito.tdp.libretto.db.VotoDAO;

public class Libretto {
	
	private List<Voto> voti ;

	public Libretto() {
		
		VotoDAO dao = new VotoDAO();
		this.voti = dao.listVoti();
	}
	
	/**
	 * cerca un voto per nome del corso
	 * @param nomeCorso riceve stringa nome corso
	 * @return voto corrispondente
	 * @throws RuntimeException
	 */
	public Voto cercaVoto(String nomeCorso) throws RuntimeException{
		for(Voto v: this.voti) {
			if(v.getCorso().compareTo(nomeCorso)==0)
				return v;
		}
		//throw new RuntimeException("Voto non trovato");
		return null;
		
	}
	
	
	
	public boolean esisteVoto(Voto nuovo) {
		for(Voto v: this.voti) {
			if(v.getCorso().compareTo(nuovo.getCorso())==0&&v.getPunti()==nuovo.getPunti())
				return true;
		}
		return false;
	}
	
	public boolean isConflitto(Voto nuovo) {
		for(Voto v: this.voti) {
			if(v.getCorso().compareTo(nuovo.getCorso())==0)
				return true;
		}
		return false;
	}
	/**
	 * aggiunge un voto se non esiste o se non è in conflitto
	 * @param nuovo
	 */
	public void addV2 (Voto nuovo) {
		if(isConflitto(nuovo)||esisteVoto(nuovo))
			return;
		this.voti.add(nuovo);
	}
	
	
	
	@Override
	public String toString() {
		String ritorno = "";
		for(Voto v:this.voti) {
			if(ritorno.compareTo("")==0)
				ritorno+=v.toString();
			else
				ritorno+="\n"+v.toString();
		}
		return ritorno;
	}

	public List<Voto> getVoti(){
		return this.voti;
	}
	
	public Libretto ordinaAlfabeticamente(){
		Libretto ordinatoAlfabeticamente = new Libretto();
		ordinatoAlfabeticamente.voti = new ArrayList <Voto>(this.voti);

		Collections.sort(ordinatoAlfabeticamente.voti);
		return ordinatoAlfabeticamente;
	}
	
	public Libretto ordinaPerPunti(){
		Libretto ordinatoPunti = new Libretto();
		ordinatoPunti.voti = new ArrayList <Voto>(this.voti);

		Collections.sort(ordinatoPunti.voti, new ComparatoreVotiPerPunti());
		return ordinatoPunti;
	}
	
	//elimina voti inferiori a 24
	public void depurazioneLibretto() {
		for(int i=0; i<this.voti.size(); i++)
			if(voti.get(i).getPunti()<24) {
				voti.remove(i);
				i = i-1;
			}
	}
	
	
	
	
	
	
	
	//metodi superflui
	
	public boolean add(Voto v) {
		return this.voti.add(v);
	}
	
	//stampa voti 
		public void stampa() {
			for(Voto v: this.voti) {
				System.out.println(v.toString());
			}
		}
		
		public void stampaCorsiConVotoX(int x) {
			for(Voto v:this.voti) {
				if(v.getPunti()==x)
					System.out.println(v.toString());
			}
		}
	
	public void StampaVoto(Voto v) {
		System.out.println(v.toString());
	}
	
	public Libretto librettoMigliorato() {
		Libretto migliorato = new Libretto();
		for(Voto v: this.getVoti()){
			Voto nuovoVoto = v.clone();
			if((nuovoVoto.getPunti()>=18&&nuovoVoto.getPunti()<24)||nuovoVoto.getPunti()==29) {
				nuovoVoto.setPunti(nuovoVoto.getPunti()+1);
				migliorato.add(nuovoVoto);
			}
			if(nuovoVoto.getPunti()>=24&&nuovoVoto.getPunti()<29) {
				nuovoVoto.setPunti(nuovoVoto.getPunti()+2);
				migliorato.add(nuovoVoto);
			}
				
		}
		return migliorato;
	}
	
}
