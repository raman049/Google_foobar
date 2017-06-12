package Zombit_pandemic;

import java.util.List;

public class Answer {
	public static String answer(int n) {

		// total possible tree
		int totalPossible = (int) Math.pow(n - 1, n);

		for (int i = 2; i <= n; i++) {

		}

		System.out.print(totalPossible);
		return String.valueOf(totalPossible);

	}

	public static int Partition(int nP) {
		return 4 * nP;
	}

	public static void main(String[] args) {
		Answer.partition(4);
	}

	/**
	 * Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. Last updated:
	 * Tue Aug 30 09:58:33 EDT 2016.
	 * http://introcs.cs.princeton.edu/java/23recursion/Partition.java.html
	 */

	private static List<Integer> partitionList = new List<Integer>();

	public static void partition(int n) {
		partition(n, n, "");
	}

	public static void partition(int n, int max, String prefix) {
		if (n == 0) {
			System.out.println(prefix);
			return;
		}

		for (int i = Math.min(max, n); i >= 1; i--) {
			partition(n - i, i, prefix + " " + i);
		}
	}

}
