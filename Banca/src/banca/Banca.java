package banca;

import java.util.ArrayList;

import contocorrente.ContoCorrente;

public class Banca {
	
	/**
	 * gestire una lista di conto correnti
	 */
	
	private ArrayList<ContoCorrente> listeContiCorrenti = new ArrayList<ContoCorrente>();
	
	public Banca () {
		
	}

	public ArrayList<ContoCorrente> getListeContiCorrenti() {
		return listeContiCorrenti;
	}

	public void setListeContiCorrenti(ArrayList<ContoCorrente> listeContiCorrenti) {
		this.listeContiCorrenti = listeContiCorrenti;
	}

	public String toString() {
		return "Banca [listeContiCorrenti=" + listeContiCorrenti + "]";
	}	
	
}
