package utente;

public class Azienda implements Utente{
	
	private String ragSoc;
	private String pIva; 
	private PersonaFisica delegato;
	

	public Azienda(String ragSoc, String pIva, PersonaFisica delegato) {
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
	public String getpIva() {
		return pIva;
	}
	public void setpIva(String pIva) {
		this.pIva = pIva;
	}
	public PersonaFisica getDelegato() {
		return delegato;
	}
	public void setDelegato(PersonaFisica delegato) {
		this.delegato = delegato;
	}
	
	
	

}
