package contocorrente;

import java.util.ArrayList;
import java.util.Iterator;
import utente.*;

public class ContoCorrente {
	
	private Utente proprietario;
	private Iban numeroConto;
	private double saldo;
	private double fido;
	private ArrayList <Prestito> listaPrestiti = new ArrayList <>(); //gestire un prestito o più prestiti?
	
	/**
	 * Costruttore base: informazioni minime richieste per la creazione di un cc:
	 * @param proprietario
	 * @param numeroConto
	 * @param saldo
	 */
	
	public ContoCorrente(Utente proprietario, Iban numeroConto, double saldo) {
		super();
		this.proprietario = proprietario;
		this.numeroConto = numeroConto;
		this.saldo = saldo;
		this.fido = 0;
	}
	
	/**
	 * Getter e Setter 
	 */
	
	public ArrayList<Prestito> getListaPrestiti() {
		return listaPrestiti;
	}
	
	public void setListaPrestiti(ArrayList<Prestito> listaPrestiti) {
		this.listaPrestiti = listaPrestiti;
	}
	
	public Utente getProprietario() {
		return proprietario;
	}

	public void setProprietario(Utente proprietario) {
		this.proprietario = proprietario;
	}
	public Iban getNumeroConto() {
		return numeroConto;
	}
	public void setNumeroConto(Iban numeroConto) {
		this.numeroConto = numeroConto;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void quantoFido(double fido) {
		this.fido = fido;
	}
	
	/**
	 * Metodi da implementare
	 */
	
	public double saldo() {
		return saldo;
	}
	
	public void prelievo(double prelievo) {
		if (prelievo > this.saldo + this.fido)
			//fondi insufficienti per il prelievo;
			return;
		this.saldo -= prelievo;
	}
	
	public void versamento (double versamento) {
		this.saldo += versamento;
	}
	
	public void fido (double fido) {
		if (this.fido < fido) this.fido = fido;
	}
	
	public boolean disponibilita (double cifra) {
		if (this.saldo+this.fido > cifra) return true; 
		return false;
	}
	
	public void prestito(Prestito p) {
		this.listaPrestiti.add(p);
	}
	
	public double importoTotalePrestiti() {
		double tot = 0;
		for (int i=0; i<this.listaPrestiti.size(); i++) {
			tot += this.listaPrestiti.get(i).getImporto();
		}
		return tot;
	}

	public String toString() {
		return "ContoCorrente [proprietario=" + proprietario + ", numeroConto=" + numeroConto + ", saldo=" + saldo
				+ ", fido=" + fido + ", listaPrestiti=" + listaPrestiti + "]";
	}
	
	/**
	 * impostare il conto corrente 
	 * metodi:
	 * 		- double saldo() x
	 * 		- void prelievo(double p) x
	 * 		- void versamento(double v) x
	 * 		- void fido(double f) che IMPOSTA una cifra di fido: è un set
	 * 		- boolean disponibilità (double d) controlla la disponibilità di una cifra senza prelevarla
	 * 		- void prestito (double p) metodo per la richiesta prestito...
	 */
}
