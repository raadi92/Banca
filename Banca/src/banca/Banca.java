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
	
	public String getNome() {
		return this.nome;
	}
	
	public void add(ContoCorrente cc) {
		this.listaContiCorrenti.add(cc);
	}
	
}
