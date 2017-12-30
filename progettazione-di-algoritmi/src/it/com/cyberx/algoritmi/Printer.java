package it.com.cyberx.algoritmi;

public class Printer {
	/**
	 * Stampa un array di interi
	 * 
	 * @param s
	 */
	public static void print(int s[]) {
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]);
		}
		System.out.println();
	}

	public static void print(char s[][]) {
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				System.out.print(s[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void print(int s[][]) {
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s.length; j++) {
				System.out.print(s[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Stampa un array di caratteri
	 * 
	 * @param s
	 */
	public static void print(char s[]) {
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i]);
		}
		System.out.println();
	}

	public static void print(String s) {
		System.out.println(s);
	}
}
