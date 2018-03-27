package utente;



public class PersonaFisica implements Utente{

	private String nome;
	private String cognome;
	private enum Sesso{M,F,ERR};
	private Sesso genere;
	private String cf;
	private String luogo_nascita;
	private String data_nascita;
	
	public PersonaFisica(String nome, String cognome, String genere, String cf, String luogo_nascita, String data_nascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
		this.luogo_nascita = luogo_nascita;
		this.data_nascita = data_nascita;
		this.genere = (genere.toUpperCase() == "M") ? Sesso.M :
			(genere.toUpperCase() == "F") ? Sesso.F : 
				//errore sesso non corretto.
				Sesso.ERR;
	}

	public PersonaFisica() {
		super();
	}
	
	public Sesso getGenere() {
		return genere;
	}

	public void setGenere(Sesso genere) {
		this.genere = genere;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getLuogo_nascita() {
		return luogo_nascita;
	}

	public void setLuogo_nascita(String luogo_nascita) {
		this.luogo_nascita = luogo_nascita;
	}

	public String getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(String data_nascita) {
		this.data_nascita = data_nascita;
	}
	
	
	
	
	
}
