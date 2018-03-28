package banca;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import contocorrente.*;
import utente.*;


public class TestMain {

	public static void main(String[] args) throws IOException {
		
		Banca [] banche = {new Banca("IntesaSanPaolo"), new Banca("Unicredit")};
		BufferedReader br = null;
		
		for (int i=0; i<banche.length; i++)
			leggiDBContiCorrenti(banche[i]);
		
		for (int i=0; i<banche.length; i++) {
			String file  = "operazioni_"+ banche[i].getNome()+".txt";
			try {
				br = new BufferedReader (new FileReader (file));
							
				for (String linea = br.readLine(); linea != null; linea = br.readLine())
					effettuaOperazione (banche[i], linea);
				
			} catch(FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("file: "+ file + " mancante!");
			} finally {
				br.close();
			}
		}
		
	}

	public static void leggiDBContiCorrenti(Banca b) throws IOException {
		/**
		 * FORMATO File <NomeBanca>_db.txt
		 *	Linea 1: Proprietario
		 *	Linea 2: IBAN
		 *	Linea 3: Saldo
		 *	Linea vuota
		 */
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(b.getNome()+"_db.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("DataBase "+ b.getNome() + " mancante!");
		}
		
		for (String p = br.readLine();p != null; p = br.readLine()) {
			String iban = br.readLine();
			String salstr = br.readLine();
			String separator = br.readLine();
			String [] dati = p.split(" ");
			if (iban == null || salstr == null) break;
			double saldo = Double.parseDouble(salstr);
			PersonaFisica per = new PersonaFisica (dati[0], dati[1], dati[2], dati[3], dati[4], dati[5]);
			Utente proprietario = (dati.length == 6) ? per :
						new Azienda(dati[6], dati[7], per);					
			ContoCorrente cc = new ContoCorrente(proprietario, new Iban(iban), saldo);
			
			b.add(cc);
			
			if (separator == null) break;
			
		}
		
		br.close();
		
	}
	
	private static void effettuaOperazione(Banca b, String linea) {
		/**
		 * File operazioni_<NomeBanca> formato:
		 * <Operazione> <IBAN> <dati> {spaziati da un " "}
		 * 		<Operazione> =	{
		 * 			S = Saldo, <dati> = null
		 * 			V = Versamento, <dati> = (cifra)
		 * 			R = Ritiro/Prelievo, <dati> = (cifra)
		 * 			D = Disponibilità, <dati> = (cifra)
		 * 			F = Fido, <dati> = (cifra)
		 * 			P = Prestito, <dati> = (cifra, durataAnni, annoPrestito, frequenzaMensile)
		 * 			ITP = Importo Totale Prestiti, <dati> = null
		 *		}
		 *		<IBAN>: NB. è l'identificatore del conto corrente e pertanto deve essere sempre presente.
		 */
		String  [] dati = linea.split(" ");
		switch (dati[0].toUpperCase()) {
		case "S":		//Saldo
			b.getContoCorrente(dati[1]).saldo();
			break;
		case "ITP":		//Importo Totale Prestiti
			b.getContoCorrente(dati[1]).importoTotalePrestiti();
			break;
		case "V":		//Versamento
			if (dati[2] == null) {
				System.out.println("Versamento IBAN: " + dati[1] + " fallito!");
				break;
			}
			b.getContoCorrente(dati[1]).versamento(Double.parseDouble(dati[2]));
			break;
		case "R":		//Ritiro, Prelievo
			if (dati[2] == null) {
				System.out.println("Prelievo IBAN: " + dati[1] + " fallito!");
				break;
			}
			b.getContoCorrente(dati[1]).prelievo(Double.parseDouble(dati[2]));
			break;
		case "D":		//Disponibilità
			if (dati[2] == null) {
				System.out.println("Controllo disponibilità IBAN: " + dati[1] + " fallito!");
				break;
			}
			System.out.println("Disponibilità IBAN: " + dati[1] + " cifra: " + dati[2] + " : "
					+ b.getContoCorrente(dati[1]).disponibilita(Double.parseDouble(dati[2])));
			break;
		case "F":		//Fido
			if (dati[2] == null) {
				System.out.println("Fido IBAN: " + dati[1] + " fallito!");
				break;
			}
			double c = Double.parseDouble(dati[2]);
			if (b.getContoCorrente(dati[1]).saldo() >= 20 * c)
				b.getContoCorrente(dati[1]).fido(c);
			else
				System.out.println("Fido IBAN: " + dati[1] + " cifra: " + dati[2] + " non concesso");
			break;
		case "P":		//Prestito
			if (dati[2] == null || dati[3] == null || dati[4] == null || dati[5] == null) {
				System.out.println("Richiesta Prestito IBAN: " + dati[1] + " fallita: mancano dati!");
				break;
			}
			ContoCorrente cc = b.getContoCorrente(dati[1]);
			Prestito p = (Integer.parseInt(dati[5])<1) ?
					new Prestito(Double.parseDouble(dati[2]), Integer.parseInt(dati[3]),
							Integer.parseInt(dati[4]), Double.parseDouble(dati[5])) :
					new Prestito(Double.parseDouble(dati[2]), Integer.parseInt(dati[3]),
							Integer.parseInt(dati[4]), Integer.parseInt(dati[5]));
			if (p.getImporto() + cc.importoTotalePrestiti() > p.getDurataAnni()*cc.saldo())
				System.out.println("Prestito IBAN: " + dati[1] + " cifra: " + dati[2] + " non concesso");
			else
				cc.prestito(p);
			break;
		}
	}
	
}
