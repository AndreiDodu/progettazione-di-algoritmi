package it.com.cyberx.algoritmi;

public class Esercizi {
	/**
	 * Stampa una matrice nxn tale che il numero nelle colonne e nelle righe devono
	 * essere crescenti
	 * 
	 * @param n
	 * @param k
	 * @param r
	 * @param c
	 * @param s
	 */
	public void matriceOrdinata(int n /* dimensione matrice */, int k/* max num */, int r, int c, int s[][]) {
		if (r >= n) {
			Printer.print(s);
			return;
		}
		for (int i = 1; i <= k; i++) {
			s[r][c] = i;
			if (c + 1 >= n) {
				if (r > 0 && s[r][c] >= s[r - 1][c])
					this.matriceOrdinata(n, k, r + 1, 0, s);
				else if (r == 0 && s[r][c] >= s[r][c - 1])
					this.matriceOrdinata(n, k, r + 1, 0, s);
			} else {
				if (r > 0 && s[r][c] >= s[r - 1][c])
					this.matriceOrdinata(n, k, r, c + 1, s);
				else if (r == 0 && c > 0 && s[r][c] >= s[r][c - 1])
					this.matriceOrdinata(n, k, r, c + 1, s);
				else if (r == 0 && c == 0)
					this.matriceOrdinata(n, k, r, c + 1, s);
			}
		}
	}

	/**
	 * Ricerca binaria che utilizza il divide et impera
	 * 
	 * @param s
	 * @param k
	 * @param i
	 * @param j
	 */
	public void ricercaBinariaDivideEtImpera(int s[], int k, int i, int j) {
		if (i > j) {
			Printer.print("FALSE");
			return;
		}
		int m = (i + j) / 2;
		if (s[m] == k) {
			Printer.print("TRUE: pos: " + m);
			return;
		} else {
			if (k < s[m]) {
				this.ricercaBinariaDivideEtImpera(s, k, i, m - 1);
			} else {
				this.ricercaBinariaDivideEtImpera(s, k, m + 1, j);
			}
		}
	}

	/**
	 * Stampa tutte le combinazioni
	 * 
	 * @param s
	 * @param n
	 * @param j
	 */
	public void subset(int s[], int n, int j) {
		if (j == n) {
			Printer.print(s);
			return;
		}
		for (int i = 0; i < 4; i++) {
			s[j] = i;
			this.subset(s, n, j + 1);
		}
	}

	/**
	 * In posizione pari stampa numero pari e viceversa
	 * 
	 * @param s
	 * @param n
	 * @param j
	 */
	public void subsetPosPariPosispari(int s[], int n, int j) {
		if (j == n) {
			Printer.print(s);
			return;
		}
		for (int i = 0; i < 6; i++) {
			if (i % 2 == j % 2) {
				s[j] = i;
				this.subsetPosPariPosispari(s, n, j + 1);
			}
		}
	}

	/**
	 * In posizione pri stampa numero dispari e viceversa
	 * 
	 * @param s
	 * @param n
	 * @param h
	 */
	public void subsetPosPariNumDispPosDisNumDispari(int s[], int n, int h) {
		if (h == n) {
			Printer.print(s);
			return;
		}
		for (int i = 0; i < 6; i++) {
			if ((h % 2 == 0 && i % 2 == 1) || (h % 2 == 1 && i % 2 == 0)) {
				s[h] = i;
				this.subsetPosPariNumDispPosDisNumDispari(s, n, h + 1);
			}
		}
	}

	public void matriceNumeroAMaggioreUgualeNumeroB(char s[][], int r, int c, int n, int nar, int nbr, int nac,
			int nbc) {
		if (r == n) {
			Printer.print(s);
			return;
		}
		char tmp[] = { 'a', 'b' };
		for (int i = 0; i < tmp.length; i++) {
			if (nac < nbc) {
				s[r][c] = 'a';
				nac++;
			} else if (nar < nbr) {
				s[r][c] = 'a';
				nar++;
			} else {
				s[r][c] = tmp[i];
				if (tmp[i] == 'a')
					nac++;
				else
					nbc++;
			}
			if (c + 1 == n) {
				this.matriceNumeroAMaggioreUgualeNumeroB(s, r + 1, 0, n, nar, nbr, nac, nbc);
			} else {
				this.matriceNumeroAMaggioreUgualeNumeroB(s, r, c + 1, n, nar, nbr, nac, nbc);
			}
		}
	}

	/**
	 * Scrivere lo pseudocodice di un algoritmo che, data in input una sequenza
	 * binaria X lunga n, stampa tutti i modi di ottenere sottosequenze di X non
	 * decrescenti che contengono sia zeri che uni. Esempio: per X = 1100 non
	 * bisogna stampare nulla. per X=0101 l'algoritmo stampa 01__ 01_1 0_01 0__1
	 * __01
	 * 
	 * 
	 * OK
	 */
	public void sequenzeBinarieCrescenti(int n, int h, char s[], int x[]) {
		if (h == n) {

			/*
			 * devo avere almeno uno zero e uno 1 quindi conto i zero e gli uno
			 */
			int counta = 0, countb = 0;
			for (int i = 0; i < s.length; i++) {
				if (s[i] == '1')
					counta++;
				else if (s[i] == '0')
					countb++;
			}
			/*
			 * Ignoro i _ e verifico esattezza con gli altri numeri. In questo modo riesco a
			 * eliminare tutte le sottosequenze che non rispettano il pattern in X
			 */
			boolean rispettaIlPattern = true;
			for (int i = 0; i < x.length; i++) {
				if (s[i] == '_')
					continue;
				if (Integer.parseInt("" + s[i]) != x[i]) {
					rispettaIlPattern = false;
					break;
				}
			}
			/* Vado a verificare se la sequenza � crescente */
			boolean crescente = true;
			boolean trovato1 = false;
			for (int i = 0; i < s.length; i++) {
				if (s[i] == '_')
					continue;
				else if (s[i] == '1')
					trovato1 = true;
				else if (s[i] == '0' && trovato1)
					crescente = false;
			}
			/**
			 * verifico se tutte le condizioni vengono rispettate. In caso affermativo
			 * stampo la stringa.
			 */
			if (counta >= 1 && countb >= 1 && rispettaIlPattern && crescente)
				Printer.print(s);
			return;
		}
		char tmp[] = { '1', '0', '_' };
		for (int i = 0; i < tmp.length; i++) {
			s[h] = tmp[i];
			this.sequenzeBinarieCrescenti(n, h + 1, s, x);
		}
	}

	/**
	 * Scrivere lo pseudocodice di un algoritmo che, data in input una sequenza
	 * binaria X lunga n, stampa tutti i modi di ottenere sottosequenze di X non
	 * decrescenti che contengono sia zeri che uni. Esempio: per X = 1100 non
	 * bisogna stampare nulla. per X=0101 l'algoritmo stampa 01__ 01_1 0_01 0__1
	 * __01
	 * 
	 * 
	 * 
	 * KO
	 */
	public void sequenzeBinarieCrescentiRicor(int n, int h, char s[], int[] x) {
		if (h == n) {
			Printer.print(s);
			return;
		}
		char tmp[] = { '0', '1', '_' };
		for (int i = 0; i < tmp.length; i++) {
			s[h] = tmp[i];
			this.sequenzeBinarieCrescentiRicor(n, h + 1, s, x);
		}
	}

	/**
	 * Dare lo pseudocodie di un algoritmo che dato l'intero n, stama tutte le
	 * stringhe lunghe n con simboli in {a,b}dove i blocchi di simboli a di
	 * lunghezza massima che appaiono nella stinga hanno lunghezza pari. Ad esempio
	 * per n=1 viene stampata la sola stringa b mentre per n=5 le stringhe da
	 * stampare sono: bbbbb aabbb baabb bbaab bbbaa baaaa aabaa aaaab
	 * 
	 * 
	 * OK
	 */
	public void stringhe(int n, int h, char s[]) {
		if (h == n) {
			int a = 0;
			for (int i = 0; i < s.length; i++) {
				if (s[i] == 'a') {
					a++;
					if (i == s.length - 1) {
						if (a % 2 != 0)
							return;
					}
				} else if (s[i] == 'b' || i == s.length - 1) {
					if (a % 2 != 0)
						return;
					a = 0;
				}
			}

			Printer.print(s);
			return;
		}
		char tmp[] = { 'a', 'b' };
		for (int i = 0; i < tmp.length; i++) {
			s[h] = tmp[i];
			this.stringhe(n, h + 1, s);
		}
	}

	public void sequenzeBinarieCrescentiBis(int n, int h, char s[], int x[]) {
		if (n == h) {

			// deve contenere almeno uno 0 e uno 1
			int zero = 0;
			int uno = 0;
			for (int i = 0; i < s.length; i++) {
				if (s[i] == '1')
					uno++;
				else if (s[i] == '0')
					zero++;
			}
			if (zero < 1 || uno < 1) {
				return;
			}
			// filtriamo le sequenze generate in base al pattern vettore x
			for (int i = 0; i < x.length; i++) {
				if (s[i] == '_') {
					continue;
				} else if (Integer.parseInt("" + s[i]) != x[i]) {
					return;
				}
			}

			// stampiamo solo le sequenze crescenti
			int num = -1;
			for (int i = 0; i < s.length; i++) {
				if (s[i] == '_')
					continue;
				if (num <= Integer.parseInt("" + s[i]))
					num = Integer.parseInt("" + s[i]);
				else
					return;
			}
			Printer.print(s);
			return;
		}

		char tmp[] = { '1', '0', '_' };
		for (int i = 0; i < tmp.length; i++) {
			s[h] = tmp[i];
			this.sequenzeBinarieCrescentiBis(n, h + 1, s, x);
		}
	}

	public void stringheBis(int n, int h, char s[]) {
		if (n == h) {
			// la sequenza deve contenere un numero di a pari
			int a = 0;
			for (int i = 0; i < s.length; i++) {
				if (s[i] == 'a')
					a++;
			}
			if (a % 2 == 1)
				return;
			// la sequenza deve contenere gruppi di a con numero pari
			a = 0;
			for (int i = 0; i < s.length; i++) {
				if (s[i] == 'a')
					a++;
				else if (s[i] == 'b' && a % 2 == 1) {
					return;
				}
				if (s[i] == 'a' && i == s.length - 1 && a % 2 == 1)
					return;
			}
			Printer.print(s);
			return;
		}
		char tmp[] = { 'a', 'b' };
		for (int i = 0; i < tmp.length; i++) {
			s[h] = tmp[i];
			this.stringheBis(n, h + 1, s);
		}
	}

	public void sottosequenzeTernarieCrescenti(int n, int h, char s[], int x[]) {
		if (h == n) {

			// contiene sia 1 he 2 che 3
			int uno = 0;
			int due = 0;
			int tre = 0;
			for (int i = 0; i < s.length; i++) {
				if (s[i] == '1')
					uno++;
				else if (s[i] == '2')
					due++;
				else if (s[i] == '3')
					tre++;
			}
			if (uno < 1 || due < 1 || tre < 1)
				return;

			// prendo solo le sequenze che rispettano il pattern di x
			for (int i = 0; i < s.length; i++) {
				if (s[i] == '_')
					continue;
				if (Integer.parseInt("" + s[i]) != x[i])
					return;
			}
			// verifico che siano crescenti
			int num = -1;
			for (int i = 0; i < s.length; i++) {
				if (s[i] == '_')
					continue;
				if (num <= Integer.parseInt("" + s[i]))
					num = Integer.parseInt("" + s[i]);
				else
					return;
			}

			Printer.print(s);
			return;
		}
		char tmp[] = { '1', '2', '3', '_' };
		for (int i = 0; i < tmp.length; i++) {
			s[h] = tmp[i];
			this.sottosequenzeTernarieCrescenti(n, h + 1, s, x);
		}
	}

	public void diagonaleNumeroAUgualeNumeroB(int n, int r, int c, char s[][]) {
		if (r == n) {
			int a = 0;
			int b = 0;
			for (int i = 0; i < n; i++) {
				if (s[i][i] == 'a')
					a++;
				else
					b++;
			}
			if (a != b)
				return;

			Printer.print(s);
			return;
		}
		char tmp[] = { 'a', 'b' };
		for (int i = 0; i < tmp.length; i++) {
			s[r][c] = tmp[i];
			if (c + 1 == n) {
				this.diagonaleNumeroAUgualeNumeroB(n, r + 1, 0, s);
			} else
				this.diagonaleNumeroAUgualeNumeroB(n, r, c + 1, s);
		}
	}

	public void diagonaleNumeroAUgualeNumeroBRic(int n, int r, int c, char s[][], int a, int b) {
		if (r == n) {
			for (int i = 0; i < n; i++) {
				if (s[i][i] == 'a')
					a++;
				else
					b++;
			}
			if (a != b)
				return;

			Printer.print(s);
			return;
		}
		char tmp[] = { 'a', 'b' };
		for (int i = 0; i < tmp.length; i++) {
			s[r][c] = tmp[i];
			if (tmp[i] == 'a')
				a++;
			else
				b++;
			if (c + 1 == n) {
				if (r + 1 == n) {
					if (a == b)
						this.diagonaleNumeroAUgualeNumeroBRic(n, r + 1, 0, s, a, b);
				} else
					this.diagonaleNumeroAUgualeNumeroBRic(n, r + 1, 0, s, a, b);
			} else
				this.diagonaleNumeroAUgualeNumeroBRic(n, r, c + 1, s, a, b);
		}
	}

	public void stringheDispari(int n, int h, char s[]) {
		if (h == n) {
			int a = 0;
			int b = 0;
			for (int i = 0; i < s.length; i++) {
				if (s[i] == 'a')
					a++;
				else
					b++;
			}
			if (a % 2 == 0 || b % 2 == 0)
				return;

			Printer.print(s);
			return;
		}
		char tmp[] = { 'a', 'b' };
		for (int i = 0; i < tmp.length; i++) {
			s[h] = tmp[i];
			this.stringheDispari(n, h + 1, s);
		}
	}

	public void stringheDispariBis(int n, int h, char s[], int a, int b) {
		if (h == n) {
			Printer.print(s);
			System.out.println("a: " + a + " b: " + b);
			return;
		} else {
			char tmp[] = { 'a', 'b' };
			for (int i = 0; i < tmp.length; i++) {
				s[h] = tmp[i];
				if (s[h] == 'a')
					a++;
				else
					b++;
				if (h + 1 == n) {
					if (a % 2 == 1 && b % 2 == 1)
						this.stringheDispariBis(n, h + 1, s, a, b);
				} else
					this.stringheDispariBis(n, h + 1, s, a, b);
			}
		}
	}

	public void printStringsWith_odd_A_and_B(int n, int numberOfA, int prefix_length, String configuration) {
		// poiché dispari + dispari è pari, la dimensione deve essere pari
		if (n % 2 != 0)
			return;
		if (n == prefix_length) {
			// se le a sono dispari, lo saranno anche le b
			if (numberOfA % 2 != 0)
				System.out.println(configuration);
		} else {
			// creo entrambe le configurazioni: con a e con b
			printStringsWith_odd_A_and_B(n, numberOfA + 1, prefix_length + 1, configuration + "a");
			printStringsWith_odd_A_and_B(n, numberOfA, prefix_length + 1, configuration + "b");
		}
	}

	/**
	 * Stampa un numero dispari di a e b
	 * 
	 * @param n
	 * @param h
	 * @param s
	 * @param b
	 * 
	 *            OK
	 * 
	 */
	public void printStringABdispari(int n, int h, char s[], int b) {
		if (h == n) {
			Printer.print(s);
			return;
		}
		char tmp[] = { 'a', 'b' };
		for (int i = 0; i < tmp.length; i++) {
			s[h] = tmp[i];
			if (s[h] == 'b')
				b++;
			if (h + 1 != n) {
				this.printStringABdispari(n, h + 1, s, b);
			} else {
				if (b % 2 == 1)
					this.printStringABdispari(n, h + 1, s, b);
			}
		}
	}

	public void printStringABdispariBis(int n, int h, char s[], int a, int b) {
		if (h == n) {
			Printer.print(s);
			return;
		}
		char tmp[] = { 'a', 'b' };
		for (int i = 0; i < tmp.length; i++) {
			s[h] = tmp[i];
			if (s[h] == 'b')
				b++;
			a = n - b;
			if (h + 1 != n) {
				this.printStringABdispariBis(n, h + 1, s, a, b);
			} else {
				if (b % 2 == 1 && a % 2 == 1)
					this.printStringABdispariBis(n, h + 1, s, a, b);
			}
		}
	}

	/**
	 * 
	 * @param n
	 * @param h
	 * @param s
	 * @param a
	 * @param b
	 * @param c
	 * 
	 *            KO
	 * 
	 */
	public void printStringABCdispari(int n, int h, char s[], int a, int b, int c) {
		if (h == n) {
			Printer.print(s);
			return;
		}
		char tmp[] = { 'a', 'b', 'c' };
		for (int i = 0; i < tmp.length; i++) {
			s[h] = tmp[i];
			if (s[h] == 'b')
				b++;
			else if (s[h] == 'c')
				c++;
			else if (s[h] == 'a')
				a++;
			if (h + 1 != n) {
				this.printStringABCdispari(n, h + 1, s, a, b, c);
			} else {
				System.out.println("a: " + a + " b: " + b + " c: " + c);
				// if (a % 2 == 1 && b % 2 == 1 && c % 2 == 1)
				this.printStringABCdispari(n, h + 1, s, a, b, c);
			}
		}
	}

	public void printH(int n, int h) {
		if (n == h) {
			Printer.print("n = h");
			return;
		}
		for (int i = 0; i < 2; i++) {
			Printer.print("h: " + h);
			this.printH(n, h + 1);
		}
	}

	public void numeroADispariNumeroBDispari(int n, int h, char s[]) {
		if (h == n) {
			int a = 0;
			int b = 0;
			for (int i = 0; i < s.length; i++) {
				if (s[i] == 'a')
					a++;
				else
					b++;
			}
			if (a % 2 == 0 || b % 2 == 0)
				return;
			Printer.print(s);
			return;
		}
		char tmp[] = { 'a', 'b' };
		for (int i = 0; i < tmp.length; i++) {
			s[h] = tmp[i];
			this.numeroADispariNumeroBDispari(n, h + 1, s);
		}
	}

	/**
	 * 
	 * @param n
	 * @param h
	 * @param s
	 * @param a
	 * @param b
	 *
	 *            OK
	 *
	 */
	public void numeroADispariNumeroBDispariRic(int n, int h, String s, int a, int b) {
		if (h == n) {
			if (a % 2 == 0 || b % 2 == 0)
				return;
			Printer.print(s);
			return;
		}
		this.numeroADispariNumeroBDispariRic(n, h + 1, s + "a", a + 1, b);
		this.numeroADispariNumeroBDispariRic(n, h + 1, s + "b", a, b + 1);
	}

	/**
	 * Esercizio 2
	 * 
	 * @param n
	 * @param h
	 * @param s
	 * @param a
	 * @param b
	 * 
	 *            OK
	 */
	public void numeroADispariNumeroBDispariRic(int n, int h, char s[], int a, int b) {
		if (h == n) {
			if (a % 2 == 0 || b % 2 == 0)
				return;
			Printer.print(s);
			return;
		}
		s[h] = 'a';
		this.numeroADispariNumeroBDispariRic(n, h + 1, s, a + 1, b);
		s[h] = 'b';
		this.numeroADispariNumeroBDispariRic(n, h + 1, s, a, b + 1);
	}

	/**
	 * 
	 * @param n
	 * @param h
	 * @param s
	 * 
	 *            OK
	 * 
	 */
	public void gruppiALunghezzaPari(int n, int h, char s[]) {
		if (h == n) {
			// numero a pari
			int a = 0;
			for (int i = 0; i < s.length; i++) {
				if (s[i] == 'a')
					a++;
			}
			a = 0;
			// gruppi di a pari
			for (int i = 0; i < s.length; i++) {
				if (s[i] == 'a')
					a++;
				else if (s[i] == 'b') {
					if (a % 2 == 1)
						return;
					a = 0;
				}
			}

			if (a % 2 == 1)
				return;

			Printer.print(s);
			return;
		}
		char tmp[] = { 'a', 'b' };
		for (int i = 0; i < tmp.length; i++) {
			s[h] = tmp[i];
			this.gruppiALunghezzaPari(n, h + 1, s);
		}
	}

	/**
	 * 
	 * @param n
	 * @param h
	 * @param s
	 * @param a
	 * 
	 *            OK
	 * 
	 */
	public void gruppiALunghezzaPari(int n, int h, char s[], int a) {
		if (h == n) {
			if (a % 2 == 1)
				return;
			Printer.print(s);
			return;
		}
		s[h] = 'a';
		this.gruppiALunghezzaPari(n, h + 1, s, a + 1);
		s[h] = 'b';
		if (a % 2 == 0) {
			a = 0;
			this.gruppiALunghezzaPari(n, h + 1, s, a);
		}
	}

	/**
	 * 
	 * @param n
	 * @param h
	 * @param s
	 * 
	 *            KO perché permutazioni e non combinazioni
	 * 
	 */
	public void permutazioniNoPariConsecutiviNoispariConsecutivi(int n, int h, int s[]) {
		if (h == n) {
			// for (int i = 1; i < s.length; i++) {
			// if (s[i] % 2 == s[i - 1] % 2)
			// return;
			// }
			Printer.print(s);
			return;
		}
		int e[] = new int[n];
		for (int i = 0; i <= h; i++) {
			int k = 0;
			if (s[i] > 0)
				k = -1;
			e[s[i] + k] = 1;
		}
		for (int i = 1; i <= 4; i++) {
			if (e[i - 1] == 0) {
				s[h] = i;
				this.permutazioniNoPariConsecutiviNoispariConsecutivi(n, h + 1, s);
			}
		}
	}

	/**
	 * Esercizio 3
	 * 
	 * @param n
	 * @param h
	 * @param s
	 * 
	 *            OK
	 * 
	 */
	public void stringhePalindrome(int n, int h, char s[]) {
		if (h == n) {
			for (int i = 0; i < s.length / 2; i++) {
				if (s[i] != s[s.length - i - 1])
					return;
			}

			Printer.print(s);
			return;
		}

		char tmp[] = { 'a', 'b' };
		for (int i = 0; i < tmp.length; i++) {
			s[h] = tmp[i];
			this.stringhePalindrome(n, h + 1, s);
		}
	}

	/**
	 * Esercizio 3
	 * 
	 * @param n
	 * @param h
	 * @param s
	 * 
	 *            OK
	 * 
	 */
	public void stringhePalindromeRic(int n, int h, char s[]) {
		if (h == n) {
			Printer.print(s);
			return;
		}
		s[h] = 'a';
		if (h + 1 > n / 2) {
			if (s[h] == s[n - h - 1])
				this.stringhePalindromeRic(n, h + 1, s);
		} else
			this.stringhePalindromeRic(n, h + 1, s);
		s[h] = 'b';
		if (h + 1 > n / 2) {
			if (s[h] == s[n - h - 1])
				this.stringhePalindromeRic(n, h + 1, s);
		} else
			this.stringhePalindromeRic(n, h + 1, s);

	}

	/**
	 * Esercizio 4
	 * 
	 * @param n
	 * @param h
	 * @param s
	 *
	 *            OK
	 *
	 */
	public void numeriAdiacentiDistanoAlmenoDue(int n, int h, int s[]) {
		if (h == n) {
			for (int i = 1; i < s.length; i++) {
				if (Math.abs(s[i] - s[i - 1]) < 2)
					return;
			}

			Printer.print(s);
			return;
		}
		for (int i = 1; i <= 4; i++) {
			s[h] = i;
			this.numeriAdiacentiDistanoAlmenoDue(n, h + 1, s);
		}
	}

	/**
	 * Eserciio 4
	 * 
	 * @param n
	 * @param h
	 * @param s
	 * 
	 *            OK
	 */
	public void numeriAdiacentiDistanoAlmenoDueRic(int n, int h, int s[]) {
		if (h == n) {
			Printer.print(s);
			return;
		}
		for (int i = 1; i <= 4; i++) {
			s[h] = i;
			if (h > 0) {
				if (Math.abs(s[h] - s[h - 1]) < 2)
					continue;
				else
					this.numeriAdiacentiDistanoAlmenoDueRic(n, h + 1, s);
			} else
				this.numeriAdiacentiDistanoAlmenoDueRic(n, h + 1, s);
		}
	}

	/**
	 * 
	 * @param n
	 * @param h
	 * @param s
	 * @param x
	 * 
	 *            OK
	 * 
	 */
	public void sottCrescenti(int n, int h, char s[], char x[]) {
		if (h == n) {

			for (int i = 0; i < x.length; i++) {
				if (s[i] == '_')
					continue;
				else if (s[i] != x[i])
					return;
			}

			int uno = 0;
			int zero = 0;
			for (int i = 0; i < s.length; i++) {
				if (s[i] == '1')
					uno++;
				else if (s[i] == '0')
					zero++;
			}
			if (uno > zero)
				return;

			Printer.print(s);
			return;
		}

		char tmp[] = { '0', '1', '_' };
		for (int i = 0; i < tmp.length; i++) {
			s[h] = tmp[i];
			this.sottCrescenti(n, h + 1, s, x);
		}
	}

}
