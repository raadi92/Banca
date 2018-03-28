package contocorrente;

public class Prestito {
	private double importo;
	private int durataAnni;
	private int annoPrestito;
	private enum PeriodoRata {SEMESTRALE, QUADRIMESTRALE, TRIMESTRALE, BIMESTRALE, MENSILE, ERRORE};
	private PeriodoRata frequenza;
	
	/**
	 * Costruttori
	 */
	
	public Prestito(double importo, int durataAnni, int annoPrestito, int freqmensile) {
		super();
		this.importo = importo;
		this.durataAnni = durataAnni;
		this.annoPrestito = annoPrestito;
		switch (freqmensile) {
		case 6: this.frequenza = PeriodoRata.SEMESTRALE; break;
		case 4: this.frequenza = PeriodoRata.QUADRIMESTRALE; break;
		case 3: this.frequenza = PeriodoRata.TRIMESTRALE; break;
		case 2: this.frequenza = PeriodoRata.BIMESTRALE; break;
		case 1: this.frequenza = PeriodoRata.MENSILE; break;
		default:this.frequenza = PeriodoRata.ERRORE; break;	//errore frequenza errata
		}
	}

	public Prestito(double importo, int durataAnni, int annoPrestito, double periodo) {
		super();
		this.importo = importo;
		this.durataAnni = durataAnni;
		this.annoPrestito = annoPrestito;
		this.frequenza = (periodo == (1/2)) ? PeriodoRata.SEMESTRALE :
			(periodo == (1/3) || (periodo >= 0.30 && periodo <= 0.35)) ? PeriodoRata.QUADRIMESTRALE :
			(periodo == (1/4)) ? PeriodoRata.TRIMESTRALE :
			(periodo == (1/6) || (periodo >= 0.15 && periodo <= 0.20)) ? PeriodoRata.BIMESTRALE :
			(periodo == (1/12)|| (periodo >= 0.07 && periodo <= 0.10)) ? PeriodoRata.MENSILE : 
				// errore di interpretazione
				PeriodoRata.ERRORE;
	}
	
	/**
	 * Getter e Setter
	 */
	
	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

	public int getDurataAnni() {
		return durataAnni;
	}

	public void setDurataAnni(int durataAnni) {
		this.durataAnni = durataAnni;
	}

	public int getAnnoPrestito() {
		return annoPrestito;
	}

	public void setAnnoPrestito(int annoPrestito) {
		this.annoPrestito = annoPrestito;
	}

	public PeriodoRata getFrequenza() {
		return frequenza;
	}

	public void setFrequenza(PeriodoRata frequenza) {
		this.frequenza = frequenza;
	}

	/**
	 * metodi
	 */

	public double calcolaRata(double interesse) {
		// percentuale interesse (ipotizzo tasso variabile)
		if (interesse < 0 || interesse >1) 	// possibile impostare un controllo per interessi massimi legali
			//errore di interpretazione
			return 0;
		double rata = importo/durataAnni;
		switch (this.frequenza){
			case SEMESTRALE:
				rata /= 2;
				break;
			case QUADRIMESTRALE:
				rata /= 3;
				break;
			case TRIMESTRALE:
				rata /= 4;
				break;
			case BIMESTRALE:
				rata /= 6;
				break;
			case MENSILE:
				rata /= 12;
				break;
		}
		return rata*(1+interesse);
		
	}
	
	public double calcolaSaldoPrestito (double interesse, int meseProssimaRata, int annoRata) {
		if (interesse < 0 || interesse >1) 	// possibile impostare un controllo per interessi massimi legali
			//errore di interpretazione
			return 0;
		if (annoRata > (this.annoPrestito + this.durataAnni))
			//prestito già estito.....
			return 0;
		double rata = importo/durataAnni;
		int rateAnno = 1, aggiuntaMesi = 1;
		switch (this.frequenza) {
		case SEMESTRALE:
			rateAnno = 2;
			aggiuntaMesi = 2 - (meseProssimaRata+5)/6 + 1;
			break;
		case QUADRIMESTRALE:
			rateAnno = 3;
			aggiuntaMesi = 3 - (meseProssimaRata+3)/4 + 1;
			break;
		case TRIMESTRALE:
			rateAnno = 4;
			aggiuntaMesi = 4 - (meseProssimaRata+2)/3 + 1;
			break;
		case BIMESTRALE:
			rateAnno = 6;
			aggiuntaMesi = 6 - (meseProssimaRata+1)/2 + 1;
			break;
		case MENSILE:
			rateAnno = 12;
			aggiuntaMesi = 12 - meseProssimaRata + 1;
			break;
		default:
			return 0;
		}
		return ((((annoRata-(this.annoPrestito+this.durataAnni))*rateAnno)+aggiuntaMesi)*rata)*(1+(interesse/2));
	}
	
	/**
	 * impostare la possibilità di ottenere un prestito
	 * metodi:
	 * getter setter date e importi
	 * 		- double calcolaSaldoPrestito()
	 * 		- void estinguiPrestito()
	 * 		attributi: rata, periodo rata, data fine prestito, etc....
	 * 
	 */
}
