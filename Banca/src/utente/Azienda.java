package utente;

public class Azienda implements Utente{
	
	private String ragSoc;
	private long pIva; 
	private Utente delegato;
	

	public Azienda(String ragSoc, long pIva, Utente delegato) {
		super();
		this.ragSoc = ragSoc;
		this.pIva = pIva;
		this.delegato = delegato;
	}
	public String getRagSoc() {
		return ragSoc;
	}
	public void setRagSoc(String ragSoc) {
		this.ragSoc = ragSoc;
	}
	public long getpIva() {
		return pIva;
	}
	public void setpIva(long pIva) {
		this.pIva = pIva;
	}
	public Utente getDelegato() {
		return delegato;
	}
	public void setDelegato(Utente delegato) {
		this.delegato = delegato;
	}
	
	
	

}
