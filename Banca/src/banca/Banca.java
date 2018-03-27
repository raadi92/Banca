package banca;


import java.util.ArrayList;

import contocorrente.ContoCorrente;

public class Banca {
	/**
	 * gestire una lista di conto correnti
	 */
	ContoCorrente contoCorrente = new ContoCorrente(null, null, 0);
	private ArrayList<ContoCorrente> listeContiCorrenti = new ArrayList<ContoCorrente>();
	
	public Banca () {
		
	}

	public ContoCorrente getContoCorrente() {
		return contoCorrente;
	}

	public void setContoCorrente(ContoCorrente contoCorrente) {
		this.contoCorrente = contoCorrente;
	}

	public ArrayList<ContoCorrente> getListeContiCorrenti() {
		return listeContiCorrenti;
	}

	public void setListeContiCorrenti(ArrayList<ContoCorrente> listeContiCorrenti) {
		this.listeContiCorrenti = listeContiCorrenti;
	}

	public String toString() {
		return "Banca [contoCorrente=" + contoCorrente + ", listeContiCorrenti=" + listeContiCorrenti + "]";
	}
	
	
	

	/*public ArrayList<ContoCorrente> getBanca() {
		ArrayList<ContoCorrente> stampaUtenti= null;
		for(int x = 0 ;x <stampaUtenti.size();x++) {
			x = stampaUtenti.get();
			System.out.println();
		}
		
	}

	public void setBanca(List<ContoCorrente> banca) {
		this.banca = banca;
	}
	*/
	
	
}
