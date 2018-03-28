package banca;

import java.util.HashMap;

import contocorrente.*;

public class Banca {
	private String nome;
	/**
	 * gestire una lista di conto correnti
	 */
	
	private HashMap<Iban, ContoCorrente> listaContiCorrenti = new HashMap<Iban, ContoCorrente>();
	
	public Banca (String nome) {
		this.nome = nome;
	}

	public String getNome () {
		return nome;
	}
	
	public void add(ContoCorrente cc) {
		this.listaContiCorrenti.put(cc.getNumeroConto(), cc);
	}
	
	public ContoCorrente getContoCorrente(String iban ) {
		Iban tmp = new Iban(iban);
		return this.listaContiCorrenti.get(tmp);
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
