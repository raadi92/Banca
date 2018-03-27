package banca;

import java.util.ArrayList;

import contocorrente.ContoCorrente;

public class Banca {
	private String nome;
	/**
	 * gestire una lista di conto correnti
	 */
	
	private ArrayList<ContoCorrente> listaContiCorrenti = new ArrayList<ContoCorrente>();
	
	public Banca (String nome) {
		this.nome = nome;
	}

	public String getNome () {
		return nome;
	}
	
	public void add(ContoCorrente cc) {
		this.listaContiCorrenti.add(cc);
	}

	public String toString() {
		return "Banca [nome=" + nome + "\nlisteContiCorrenti: \n" + stampaContiCorrenti() + "]";
	}


	public String stampaContiCorrenti(){
		String result = null;
		
		listaContiCorrenti.toString();
		return result;
	}
}
