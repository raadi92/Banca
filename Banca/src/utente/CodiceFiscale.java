package utente;

public class CodiceFiscale {

	public String calcolaCF(String cognome, String nome, String data, String comuneNascita) {
		int count = 0;
		String cf="";
		String [] tmp = cognome.split("");
		for (int i=0;i<tmp.length;i++) {
			if (count==3) break;
			if (!isVocale(tmp[i])) {
				count++;
				cf += tmp[i].toUpperCase();
			}
		}
		return (count==16) ? cf : "errore";	
	}
	
	private boolean isVocale(String c) {
		return (c=="a" || c=="e" || c=="i" || c=="o" || c=="u");
	}
}
