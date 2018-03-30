package utente;

public class CodiceFiscale {

	public String calcolaCF(String cognome, String nome, String data, String genere, String comuneNascita) {
		int count = 0;
		String cf="";
		
				/*		COGNOME		*/
		String [] c = cognome.replace(" ", "").split("");
		for (int i=0;i<c.length || count == 3;i++) {
			if (!isVocale(c[i])) {
				count++;
				cf += c[i].toUpperCase();
			}
		}
		if(count < 3) for(int i=0;i<c.length || count == 3;i++) {
			if (isVocale(c[i])) {
				count++;
				cf += c[i].toUpperCase();
			}
		}
		
				/*		NOME		*/
		String[] n = nome.replace(" ", "").split("");
		for (int i=0;i<n.length || count == 6;i++) {
			if (!isVocale(n[i])) {
				count++;
				cf += n[i].toUpperCase();
			}
		}
		if(count < 6) for(int i=0;i<n.length || count == 6;i++) {
			if (isVocale(n[i])) {
				count++;
				cf += n[i].toUpperCase();
			}
		}
		
				/*		DATA di NASCITA
				 * 		format: GG/MM/AAAA		*/
		String [] dtmp = data.split("/");
		
					//	anno
		cf += dtmp[2].substring(2);		
					
					//	mese
		int ms = Integer.parseInt(dtmp[1]);
		switch (ms) {
		case 1:		cf += "A";	break;
		case 2:		cf += "B";	break;
		case 3:		cf += "C";	break;
		case 4:		cf += "D";	break;
		case 5:		cf += "E";	break;
		case 6:		cf += "H";	break;
		case 7:		cf += "L";	break;
		case 8:		cf += "M";	break;
		case 9:		cf += "P";	break;
		case 10:	cf += "Q";	break;
		case 11:	cf += "R";	break;
		case 12:	cf += "S";	break;
		}
					// 	giorno
		int day = Integer.parseInt(dtmp[0]);
		day += (genere.toUpperCase() == "F") ? 40 : 0;
		cf +=	(day<10) ?	"0"+day : day;
		
					//	comune di nascita
		
		count += 4;
		
					//	codice di controllo
		int controllo = 0;
		for(int i=0; i<cf.length(); i++) {
			if (i % 2 == 0)	controllo += codControlloDispari (cf.charAt(i));
			if (i % 2 == 1)	controllo += codControlloPari (cf.charAt(i));			
		}
		cf += codControlloResto(controllo);
		count++;
		
		return (count==16) ? cf : "errore";	
	}
	
	private boolean isVocale(String c) {
		return (c=="a" || c=="e" || c=="i" || c=="o" || c=="u");
	}
	
	private static int codControlloDispari(char carattere) {
		switch(carattere) {
		case '0':	case 'A':	return 1;
		case '1':	case 'B':	return 0;
		case '2':	case 'C':	return 5;
		case '3':	case 'D':	return 7;
		case '4':	case 'E':	return 9;
		case '5':	case 'F':	return 13;
		case '6':	case 'G':	return 15;
		case '7':	case 'H':	return 17;
		case '8':	case 'I':	return 19;
		case '9':	case 'J':	return 21;
		case 'K':	return 2;
		case 'L':	return 4;
		case 'M':	return 18;
		case 'N':	return 20;
		case 'O':	return 11;
		case 'P':	return 3;
		case 'Q':	return 6;
		case 'R':	return 8;
		case 'S':	return 12;
		case 'T':	return 14;
		case 'U':	return 16;
		case 'V':	return 10;		
		case 'W':	return 22;
		case 'X':	return 25;
		case 'Y':	return 24;
		case 'Z':	return 23;
		}
		return -1;
	}
	
	private static int codControlloPari(char carattere) {
		switch (carattere) {
		case '0':	case 'A':	return 0;
		case '1':	case 'B':	return 1;
		case '2':	case 'C':	return 2;
		case '3':	case 'D':	return 3;
		case '4':	case 'E':	return 4;
		case '5':	case 'F':	return 5;
		case '6':	case 'G':	return 6;
		case '7':	case 'H':	return 7;
		case '8':	case 'I':	return 8;
		case '9':	case 'J':	return 9;
		case 'K':	return 10;
		case 'L':	return 11;
		case 'M':	return 12;
		case 'N':	return 13;
		case 'O':	return 14;
		case 'P':	return 15;
		case 'Q':	return 16;
		case 'R':	return 17;
		case 'S':	return 18;
		case 'T':	return 19;
		case 'U':	return 20;
		case 'V':	return 21;
		case 'W':	return 22;
		case 'X':	return 23;
		case 'Y':	return 24;
		case 'Z':	return 25;
		}
		return -1;
	}
	
	private static String codControlloResto(int resto) {
		switch (resto) {
		case 0: 	return "A";
		case 1: 	return "B";
		case 2: 	return "C";
		case 3: 	return "D";
		case 4: 	return "E";
		case 5: 	return "F";
		case 6: 	return "G";
		case 7: 	return "H";
		case 8: 	return "I";
		case 9: 	return "J";
		case 10: 	return "K";
		case 11: 	return "L";
		case 12: 	return "M";
		case 13: 	return "N";
		case 14:	return "O";
		case 15:	return "P";
		case 16:	return "Q";
		case 17:	return "R";
		case 18:	return "S";
		case 19:	return "T";
		case 20:	return "U";
		case 21:	return "V";
		case 22:	return "W";
		case 23:	return "X";
		case 24:	return "Y";
		case 25:	return "Z";
		}
		return null;
	}

}
