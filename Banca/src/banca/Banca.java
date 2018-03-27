package banca;

import java.util.ArrayList;

import contocorrente.ContoCorrente;

public class Banca {
	private String nome;
	/**
	 * gestire una lista di conto correnti
	 */

	private ArrayList<ContoCorrente> listaContiCorrenti = new ArrayList<ContoCorrente>();

	public String getNome () {
		return nome;
	}
	public Banca (String nomeBanca) {
		this.nome = nomeBanca;
	}

	public Banca () {

	}

	public ArrayList<ContoCorrente> getListaContiCorrenti() {
		return listaContiCorrenti;
	}

	public void setListeContiCorrenti(ArrayList<ContoCorrente> listeContiCorrenti) {
		this.listaContiCorrenti = listeContiCorrenti;
	}

	public String toString() {
		return "Banca [nome=" + nome + ", listeContiCorrenti=" + listaContiCorrenti.toString() + "]";
	}


	public String stampaContiCorrenti(){
		String result = null;
		
		listaContiCorrenti.toString();
		return result;
	}
}