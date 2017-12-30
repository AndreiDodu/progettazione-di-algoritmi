package it.com.cyberx.algoritmi;

public class Permutazioni {

	public void permutazione(int n, int h, int s[]) {
		if (h == n) {
			Printer.print(s);
			return;
		}
		int e[] = new int[n];
		for (int i = 0; i < n; i++) {
			e[s[i]] = 1;
		}
		for (int i = 0; i < n; i++) {
			if (e[i] == 0) {
				s[h] = i;
				this.permutazione(n, h + 1, s);
			}
		}
	}

	public void permutazioneEsame(int i/* posizione */, int n/* max. num */, int s[]/*
																					 * vettore da stampare
																					 */, int preso[]/*
																									 * vettore di appoggio
																									 */) {
		if (i >= n) {
			Printer.print(s);
			return;
		}
		for (int x = 1; x <= n; x++) {
			if (preso[x - 1] == 0 && (x - 1) % 2 == i % 2) {
				s[i] = x;
				preso[x - 1] = 1;
				this.permutazioneEsame(i + 1, n, s, preso);
				preso[x - 1] = 0;
			}
		}
	}

	public void permutazioni(char lista[], int a, int z) {
		if (z - a >= 1) {
			for (int k = a; k <= z; k++) {
				char scambio = lista[k];
				lista[k] = lista[z];
				lista[z] = scambio;
				this.permutazioni(lista, a, z - 1);
				scambio = lista[k];
				lista[k] = lista[z];
				lista[z] = scambio;
			}
		} else {
			Printer.print(lista);
		}
	}

	/*
	 * genera una permutazione in cui i numeri pari sono situati in posizioni pari e quelli dispari in posizioni dispari. Inoltre, i numeri pari sono crescenti verso destra.
	 */
	public void perm_alterni_pos_pari_ordinati(int n, int h, int s[]) {
		int i = 0;
		// printf("%d - %d\n", n, h);
		if (n == h) {
			Printer.print(s);
		}

		int t[] = new int[n];
		for (i = 0; i < n; i++) {
			t[i] = 0;
		}
		for (i = 0; i < h; i++) {
			t[s[i]] = 1;
		}
		for (i = 0; i < n; i++) {
			// dispari - senza prendere in considerazione l'ordine
			if (t[i] == 0 && h % 2 == 1 && i % 2 == 1) {
				s[h] = i;
				perm_alterni_pos_pari_ordinati(n, h + 1, s);
			} else
			// pari - prende in considerazione l'ordine a partire dall'elemento 2 (cpmpreso)
			if (t[i] == 0 && h % 2 == 0 && i % 2 == 0 && h - 2 >= 0 && i > s[h - 2]) {
				s[h] = i;
				perm_alterni_pos_pari_ordinati(n, h + 1, s);
			} else
			// pari - non prende in considerazione l'ordine fino all'elemento 2 (non compreso)
			if (t[i] == 0 && h % 2 == 0 && i % 2 == 0 && h < 2) {
				s[h] = i;
				perm_alterni_pos_pari_ordinati(n, h + 1, s);
			}
		}
	}

	/* permutazioni decrescente */
	public void perm_dec(int n, int h, int s[]) {
		int i = 0;
		if (n == h) {
			Printer.print(s);
			return;
		}

		int t[] = new int[n];
		for (i = 0; i < n; t[i++] = 0);
		for (i = 0; i < h; t[s[i++]] = 1);

		for (i = 0; i < n; i++) {
			if (t[i] == 0) {
				s[h] = n - i - 1;
				perm_dec(n, h + 1, s);
			}
		}
	}
	
	
	/* permutazioni decrescente */
	public void perm(int n, int h, int s[]) {
		int i = 0;
		if (n == h) {
			Printer.print(s);
			return;
		}

		int t[] = new int[n];
		for (i = 0; i < n; t[i++] = 0);
		for (i = 0; i < h; t[s[i++]] = 1);

		for (i = 0; i < n; i++) {
			if (t[i] == 0) {
				s[h] = n - i - 1;
				perm_dec(n, h + 1, s);
			}
		}
	}
}
