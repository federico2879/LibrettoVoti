package it.polito.tdp.libretto.model;

import java.time.*;
//import java.sql.*;

public class Voto implements Comparable<Voto>{
	
	private String corso;
	private int punti;
	private LocalDate dataEsame;
	
	public Voto(String corso, int punti, LocalDate dataEsame) {
		super();
		this.corso = corso;
		this.punti = punti;
		this.dataEsame = dataEsame;
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

	public int getPunti() {
		return punti;
	}

	public void setPunti(int punti) {
		this.punti = punti;
	}

	public LocalDate getDataEsame() {
		return dataEsame;
	}

	public void setDataEsame(LocalDate dataEsame) {
		this.dataEsame = dataEsame;
	}

	@Override
	public String toString() {
		return this.corso+", "+this.punti+", "+this.dataEsame;
	}
	
	public Voto clone(Voto this) {
		return new Voto(this.corso, this.punti, this.dataEsame);
	}
	
	@Override
	public int compareTo(Voto v) {
		return this.corso.compareTo(v.corso);
	}
}
