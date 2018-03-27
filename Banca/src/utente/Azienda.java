package utente;

public class Azienda{
	
	private String ragSoc;
	private long pIva; 
	private PersonaFisica delegato;
	

	public Azienda(String ragSoc, long pIva, PersonaFisica delegato) {
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
	public PersonaFisica getDelegato() {
		return delegato;
	}
	public void setDelegato(PersonaFisica delegato) {
		this.delegato = delegato;
	}
	
	
	

}
