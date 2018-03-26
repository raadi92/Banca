package contocorrente;

public class Iban {
	
	private String Stato="";
	private String cinEu="";
	private String cinNaz="";
	private String abi="";
	private String cab="";
	private String numcc="";
	
	/*
	 * IT 01 A 01234 01234 012345678901
	 */
	
	public Iban(String iban) {
		super();
		if (iban.length() != 27 )
			//errore
			return;
		String [] s = iban.split("");
		Stato = s[0]+s[1];
		cinEu = s[2]+s[3];
		cinNaz = s[4];
		for (int i=0;i<5;i++)	abi+=s[5+i];
		for (int i=0;i<5;i++)	cab+=s[10+i];
		for (int i=0;i<12;i++)	numcc+=s[15+i];
	}

	@Override
	public String toString() {
		
		return this.Stato+this.cinEu+this.cinNaz+this.abi+this.cab+this.numcc;
		
	}
	
	
}
