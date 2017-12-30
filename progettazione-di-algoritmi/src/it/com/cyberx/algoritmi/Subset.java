package it.com.cyberx.algoritmi;

public class Subset {
	/**
	 * Crea tutte le combinazioni di 0 e 1
	 * 
	 * @param n
	 * @param h
	 * @param s
	 */
	public void subset(int n, int h, int s[]) {
		if (h == n) {
			Printer.print(s);
			return;
		}
		for (int i = 0; i < 2; i++) {
			s[h] = i;
			subset(n, h + 1, s);
		}
	}

	public void diagonalePrincipaleAUgualeB(int n, int h, char s[]) {
		if (h == n) {
			int a = 0, b = 0;
			for (int i = 0; i < n; i++) {
				if (s[i] == 'a') {
					a++;
				} else if (s[i] == 'b') {
					b++;
				}
			}
			if (a == b) {
				Printer.print(s);
			} else {
				// Printer.print("Don't print!");
			}
			return;
		}
		char tmp[] = { 'a', 'b' };
		for (int i = 0; i < tmp.length; i++) {
			s[h] = tmp[i];
			this.diagonalePrincipaleAUgualeB(n, h + 1, s);
		}
	}

	/**
	 * Algoritmo che dato un intero n pari stampa tutte le matrici nxn con
	 * valori in (a, b) tale che sulla diagonale principale l numero delle a �
	 * uguale al numero delle b. La diagonale principale � la diagonale che va da
	 * sinistra verso destra.
	 * 
	 * @param n
	 *            dimension della matrice
	 * @param c
	 *            colonna
	 * @param r
	 *            riga
	 * @param s
	 *            matrice da stampare
	 */
	public void diagonalePrincipaleAUgualeB(int n, int c, int r, char s[][]) {
		if (r == n) {
			int a = 0;
			int b = 0;
			for (int i = 0; i < n; i++) {
				if (s[i][i] == 'a') {

					a++;
				} else {
					b++;
				}
			}
			if (a == b)
				Printer.print(s);
			return;
		}
		char tmp[] = { 'a', 'b' };
		for (int i = 0; i < tmp.length; i++) {
			s[r][c] = tmp[i];
			if (c + 1 == n && r < n) {
				this.diagonalePrincipaleAUgualeB(n, 0, r + 1, s);
			} else {
				if (r < n) {
					this.diagonalePrincipaleAUgualeB(n, c + 1, r, s);
				}
			}
		}

	}

	/**
	 * Crea tutte le combinazioni di 0 e 1 la cui somma è pari
	 * 
	 * @param n
	 * @param h
	 * @param s
	 */
	public void subsetSommaPari(int n, int h, int s[]) {
		if (h == n) {
			int sum = 0;
			for (int i = 0; i < s.length; i++) {
				sum += s[i];
			}
			if (sum % 2 == 0) {
				Printer.print(s);
			}
			return;
		}
		for (int i = 0; i < 2; i++) {
			s[h] = i;
			subsetSommaPari(n, h + 1, s);
		}
	}

	/**
	 * Crea tutte le combinazioni di 0 e 1 la cui somma è dispari
	 * 
	 * @param n
	 * @param h
	 * @param s
	 */
	public void subsetSommaDispari(int n, int h, int[] s) {
		if (h == n) {
			int sum = 0;
			for (int i = 0; i < s.length; i++) {
				sum += s[i];
			}
			if (sum % 2 == 1) {
				Printer.print(s);
			}
			return;
		}
		for (int i = 0; i < 2; i++) {
			s[h] = i;
			subsetSommaDispari(n, h + 1, s);
		}
	}

	public void subsetPosPariPariPosDispariDispari(int n, int h, int[] s) {
		if (h == n) {
			boolean stampa = true;
			for (int i = 0; i < s.length; i++) {
				if (i % 2 == 0 && s[i] != 0) {
					stampa = false;
				} else if (i % 2 == 1 && s[i] != 1) {
					stampa = false;
				}
			}
			if (stampa) {
				Printer.print(s);
			}
			return;
		}
		for (int i = 0; i < 2; i++) {
			s[h] = i;
			this.subsetPosPariPariPosDispariDispari(n, h + 1, s);
		}
	}

	/**
	 * Crea tutti i sottoinsiemi di rgb
	 * 
	 * @param n
	 * @param h
	 * @param s
	 */
	public void rgb(int n, int h, char s[]) {
		char rgb[] = { 'r', 'g', 'b' };
		if (h == 3) {
			Printer.print(s);
			return;
		}
		for (int i = 0; i < rgb.length; i++) {
			s[h] = rgb[i];
			rgb(n, h + 1, s);
		}

	}

}
