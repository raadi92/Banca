package banca;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import contocorrente.*;
import utente.*;


public class TestMain {

	public static void main(String[] args) throws IOException {
		Banca ISP = new Banca("Intesa_San_Paolo");
		Banca UNI = new Banca("Unicredit");
		
		leggiDBContiCorrenti(ISP);
		leggiDBContiCorrenti(UNI);
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
			double saldo = Double.parseDouble(br.readLine());
			String separator = br.readLine();
			String [] dati = p.split(" ");
			PersonaFisica per = new PersonaFisica (dati[0], dati[1], dati[2], dati[3], dati[4], dati[5]);
			Utente proprietario = (dati.length == 6) ? per :
						new Azienda(dati[6], dati[7], per);					
			ContoCorrente cc = new ContoCorrente(proprietario, new Iban(iban), saldo);
			
			b.add(cc);
			
			if (separator == null) break;
			
		}
		
	}
}
