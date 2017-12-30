package it.com.cyberx.algoritmi;

public class Leciti {
	public void leciti(int i, int n /* lung. sequenza */, int m, int s[]/* vettore */) {
		if (i >= n) {
			Printer.print(s);
			return;
		}
		for (int j = 1; j <= m; j++) {
			if (i == 0 || s[i - 1] % j == 0) {
				s[i] = j;
				this.leciti(i + 1, n, m, s);
			}
		}
	}

	public void tutti(int i, int n, int m, int s[]) {
		if (i >= n) {
			Printer.print(s);
			return;
		}
		for (int j = 1; j <= m; j++) {
			s[i] = j;
			this.tutti(i + 1, n, m, s);
		}
	}

	public void posPariPariPosDispariDispari(int i, int n, int m, int s[]) {
		if (i >= n) {
			Printer.print(s);
			return;
		}
		for (int j = 1; j < m; j++) {
			if (i % 2 == j % 2) {
				s[i] = j;
				this.posPariPariPosDispariDispari(i + 1, n, m, s);
			}
		}
	}

}
