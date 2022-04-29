package com.examen.mercadolibre.examen.utils;

public class AdnUtils {

	protected static boolean isEqual(char a, char b, char c, char d) {
		return a == b && b == c && c == d;
	}

	public static boolean isValidAdn(String[] adn) {

		for (int i = 0; i < adn.length; i++) {

			if (adn[i].length() < 4 || adn.length < 4 || adn[i].length() != adn.length)
				return false;

			if (adn[i].matches(".*[^ATCG].*"))
				return false;

		}

		return true;
	}

	public static int validateLandscapeControl(int totalAdn, String[] adn, int i, int j) {
		if (isEqual(adn[i].charAt(j), adn[i].charAt(j + 1), adn[i].charAt(j + 2), adn[i].charAt(j + 3)))
			totalAdn++;
		return totalAdn;
	}

	public static int validateVerticalControl(int totalAdn, String[] adn, int i, int j) {
		if (isEqual(adn[i].charAt(j), adn[i + 1].charAt(j), adn[i + 2].charAt(j), adn[i + 3].charAt(j)))
			totalAdn++;
		return totalAdn;
	}

	public static int validateDiagonalControl(int totalAdn, String[] adn, int i, int j) {
		if (isEqual(adn[i].charAt(j), adn[i + 1].charAt(j + 1), adn[i + 2].charAt(j + 2), adn[i + 3].charAt(j + 3)))
			totalAdn++;
		return totalAdn;
	}

	public static int validateReverseDiagonalControl(int totalAdn, String[] adn, int i, int j) {
		if (isEqual(adn[i].charAt(j), adn[i - 1].charAt(j + 1), adn[i - 2].charAt(j + 2), adn[i - 3].charAt(j + 3)))
			totalAdn++;
		return totalAdn;
	}

}