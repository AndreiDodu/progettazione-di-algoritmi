package it.com.cyberx.main;

import it.com.cyberx.algoritmi.Esercizi;
import it.com.cyberx.algoritmi.Printer;

public class Main {

	public static void main(String[] args) {

		// Permutazioni permutazioni = new Permutazioni();
		// int n = 4;
		// int s[] = new int[n];
		// for (int i = 0; i < n; i++) {
		// s[i] = i;
		// }
		// permutazioni.permutazione(n, 0, s);

		// permutazioni.perm_alterni_pos_pari_ordinati(n, 0, s);
		// permutazioni.perm(n, 0, s);

		// char lista[] = {'A', 'B', 'C'};
		// permutazioni.permutazioni(lista, 0, lista.length-1);

		// int n = 2;
		// int s[] = new int[n];
		// Subset subset = new Subset();
		// subset.subsetSommaDispari(s.length, 0, s);
		// char ch[][] = new char[n][n];
		// subset.diagonalePrincipaleAUgualeB(n, 0, 0, ch);
		// subset.rgb(s.length, 0, ch);
		// subset.subsetPosPariPariPosDispariDispari(n, 0, s);

		// int preso[] = new int[5];
		// int s[] = new int[4];
		// permutazioni.permutazioneEsame(0, 4, s, preso);

		// Leciti leciti = new Leciti();
		// leciti.leciti(0, s.length, 4, s);

		// Esercizi exe = new Esercizi();
		// int n = 2;
		// int s[][] = new int[n][n];
		// exe.matriceOrdinata(n,3,0,0,s);

		Esercizi exe = new Esercizi();
		// int s[] = { 10, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27,
		// 28,
		// 29, 30, 31, 32, 66, 78, 120, 150 };
		// Printer.print("Array length: " + s.length);
		// exe.ricercaBinariaDivideEtImpera(s, 32, 0, s.length);
		// int n = 2;
		// char s[][] = new char[n][n];
		// exe.matriceNumeroAMaggioreUgualeNumeroB(s, 0, 0, n, 0, 0, 0, 0);
		// int n = 4;
		// char s[] = new char[4];
		// int x[] = { 0, 1, 0, 1 };
		// exe.sequenzeBinarieCrescenti(n, 0, s, x);
		// int n = 4;
		// char s[] = new char[n];
		// int x[] = { 0, 1, 0, 1 };
		// exe.sequenzeBinarieCrescentiBis(n, 0, s, x);

		// int n = 5;
		// char s[] = new char[n];
		// exe.stringheBis(n, 0, s);

		// int n = 6;
		// int x[] = {1,2,3,1,2,3};
		// int x[] = {3,2,2,3,1,2};
		// char s[] = new char [n];
		// exe.sottosequenzeTernarieCrescenti(n, 0, s, x);

		// int n = 2;
		// char s[][] = new char[n][n];
		// exe.diagonaleNumeroAUgualeNumeroBRic(n, 0, 0, s, 0, 0);

		// int n = 4;
		// char s[] = new char[n];
		// exe.stringheDispariBis(n, 0, s, 0, 0);
		// int n = 4;
		// exe.printStringsWith_odd_A_and_B(n, 0, 0, "");
		// int n = 4;
		// char s[] = new char[n];
		// exe.printStringABdispariBis(n, 0, s, 0, 0);
		// int n = 3;
		// char s[] = new char[n];
		// exe.printStringABCdispari(n, 0, s, 0, 0, 0);
		// exe.printH(5, 0);
		// int n = 4;
		// char s[] = new char[n];
		// exe.numeroADispariNumeroBDispariRic(n, 0, s, 0, 0);

		// int n = 5;
		// char s[] = new char[n];
		// exe.gruppiALunghezzaPari(n, 0, s, 0);
		// int n = 4;
		// int s[] = new int[n];
		// exe.permutazioniNoPariConsecutiviNoispariConsecutivi(n, 0, s);

		// int n = 4;
		// char s[] = new char[n];
		// exe.stringhePalindromeRic(n, 0, s);
		// int n = 3;
		// int s[] = new int[n];
		// exe.numeriAdiacentiDistanoAlmenoDueRic(n, 0, s);
		int n = 4;
		char x[] = { '0', '1', '0', '1' };
		char s[] = new char[4];
		exe.sottCrescenti(n, 0, s, x);
		
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();

	}

}