package Undercover_Underground;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Answer {
	static Map<List<Integer>, String> table = new HashMap<List<Integer>, String>();

	public static String answer(int N, int K) {
		long a = 0;
		BigInteger b;
		int Kmax = N * (N - 1) / 2;
		List<Integer> table_list = Arrays.asList(N, K);

		if (table.containsKey(table_list)) {
			return table.get(table_list);
		}
		 if (K < N - 1) {
		 System.out.println("K < N-1 ");
		 b = BigInteger.valueOf(0);
		// System.out.println("b " + BigInteger.ZERO.toString());
		 return BigInteger.ZERO.toString();
		 }
		 if (K > Kmax) {
		 System.out.println("K > Kmax ");
		 b =BigInteger.valueOf(1);
		 // System.out.println("b " + BigInteger.ONE.toString());
		 return BigInteger.ONE.toString();
		 }
		 if (K == Kmax) {
		 System.out.println("K==Kmax");
		 b = BigInteger.valueOf(1);
		 return BigInteger.ONE.toString();
		 }

		 List<Integer> list = Arrays.asList(N, K);
		 if (table.containsKey(list))
		 return table.get(list);
		 else {
		 System.out.println("else");
		// b = aa.intValue();
		 }
		 int p = N * (N - 1);
		 BigInteger ptotal = new BigInteger("0");
		
		 if (K == p) {
		 ptotal = BigInteger.ONE;
		
		 } else {
		 ptotal = Choose(p, K);
		 if (K < p - N + 2) {
		 for (int j = 1; j < N; j++) {
		 BigInteger x = Choose(N - 1, j - 1);
		 int y = Math.min(p, K);
		 for (int k = j - 1; k < y + 1; k++) {
		 ptotal = ptotal.subtract(x.multiply(
		 (totalPossibleGraph(N - j, K - k))).multiply(
		 new BigInteger(answer(j, k))));
		 }
		 }
		 table.put(Collections.unmodifiableList(Arrays.asList(N, K)),
		 ptotal.toString());
		 }
		
		 }
		 System.out.println("ptotal " + ptotal);
		 return String.valueOf(ptotal);
	}


//		} else if (K == (N - 1)) {
//			System.out.println("K==N-1");
//			a = (long) Math.pow(N, N - 2);
//			b = BigInteger.valueOf(a);
//			// return String.valueOf(b);
//		} else if (K < N - 1) {
//			System.out.println("K < N-1 ");
//			b = BigInteger.valueOf(0);
//			// return BigInteger.ZERO.toString();
//		} else {
//			int Kmax2 = N * (N - 1);
//			if (K >= Kmax) {
//				System.out.println("K==Kmax2");
//				b = BigInteger.valueOf(1);
//				// return BigInteger.ONE.toString();
//			} else {
//				b = Choose(Kmax, K);
//				BigInteger repeats = BigInteger.ZERO;
//				for (int n = 0; n <= N - 2; n++) {
//					BigInteger choose_n_from_rem_nodes = Choose(N - 1, n);
//					int chooseN = (N - 1 - n) * (N - 2 - n) / 2;
//					BigInteger repeatedEdges = BigInteger.ZERO;
//					for (int k = 0; k <= K; k++) {
//						BigInteger combinations = Choose(chooseN, k);
//						BigInteger recurse = new BigInteger(
//								answer(n + 1, K - k));
//						///repeatedEdges = repeatedEdges.add(combinations
//							//	.multiply(recurse));
//					}
//					repeats = repeats.add(choose_n_from_rem_nodes
//							.multiply(repeatedEdges));
//				}
//
//				b = repeats.subtract(b);
//			}
//		}
//		table.put(Collections.unmodifiableList(Arrays.asList(N, K)),
//				b.toString());
//		return String.valueOf(b);
//
//	}

	// if (K < Kmax - N + 2) {
	// for (int i = 0; i < N; i++) {
	// BigInteger xBig = Choose(N - 1, i - 1);
	// int y = Math.min(i * (i - 1), K);
	//
	// for (int j = i - 1; j < y + 1; j++) {
	// b = b.subtract(xBig.multiply((totalPossibleGraph(
	// N - 1, K - j).multiply(new BigInteger(
	// answer(i, j))))));
	// }
	// }
	// }

	// }
	//
	// }
	// table.put(Collections.unmodifiableList(Arrays.asList(N, K)),
	// b.toString());
	// System.out.println("btotal " + b);
	// return String.valueOf(b);
	// }

	// if (K < N - 1) {
	// System.out.println("K < N-1 ");
	// b = BigInteger.valueOf(0);
	// // System.out.println("b " + BigInteger.ZERO.toString());
	// return BigInteger.ZERO.toString();
	// }
	// if (K > Kmax) {
	// System.out.println("K > Kmax ");
	// b =BigInteger.valueOf(1);
	// // System.out.println("b " + BigInteger.ONE.toString());
	// return BigInteger.ONE.toString();
	// }
	// if (K == Kmax) {
	// System.out.println("K==Kmax");
	// b = BigInteger.valueOf(1);
	// return BigInteger.ONE.toString();
	// }

	// List<Integer> list = Arrays.asList(N, K);
	// if (table.containsKey(list))
	// return table.get(list);
	// else {
	// System.out.println("else");
	// b = aa.intValue();
	// }
	// int p = N * (N - 1);
	// BigInteger ptotal = new BigInteger("0");
	//
	// if (K == p) {
	// ptotal = BigInteger.ONE;
	//
	// } else {
	// ptotal = Choose(p, K);
	// if (K < p - N + 2) {
	// for (int j = 1; j < N; j++) {
	// BigInteger x = Choose(N - 1, j - 1);
	// int y = Math.min(p, K);
	// for (int k = j - 1; k < y + 1; k++) {
	// ptotal = ptotal.subtract(x.multiply(
	// (totalPossibleGraph(N - j, K - k))).multiply(
	// new BigInteger(answer(j, k))));
	// }
	// }
	// table.put(Collections.unmodifiableList(Arrays.asList(N, K)),
	// ptotal.toString());
	// }
	//
	// }
	// System.out.println("ptotal " + ptotal);
	// return String.valueOf(ptotal);

	// List<Integer> allPossible_list = Arrays.asList(N, K);
	// if (table.containsKey(allPossible_list))
	// return table.get(allPossible_list);
	// else {
	// BigInteger total = new BigInteger("0");
	// for (int j = 1; j <= N - 1; j++) {
	// BigInteger choose_n1 = Choose(N - 1, j);
	// choose_n1 = choose_n1.multiply(new BigInteger(answer(N - 1, K
	// - j)));
	// total = total.add(choose_n1);
	//
	// }
	// table.put(Collections.unmodifiableList(Arrays.asList(N, K)),
	// total.toString());
	//
	// // System.out.println("b " + b);
	// System.out.println("total " + total);
	// return String.valueOf(total);

	// Your code goes here.

	private static Map<Integer, BigInteger> factorials = new HashMap<Integer, BigInteger>();

	// this method gets the factorial of a number
	public static BigInteger Factorial(int number) {
		if (factorials.containsKey(number))
			return factorials.get(number);
		BigInteger fact = new BigInteger("1");
		for (int i = 2; i <= number; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		factorials.put(number, fact);
		return fact;
	}

	private static Map<List<Integer>, BigInteger> choose = new HashMap<List<Integer>, BigInteger>();

	public static BigInteger Choose(int n, int k) {
		List<Integer> choose_list = Arrays.asList(n, k);
		if (choose.containsKey(choose_list)) {
			return choose.get(choose_list);
		} else {
			BigInteger factN = Factorial(n);
			BigInteger factR = Factorial(k);
			BigInteger factN_R = Factorial(n - k);
			BigInteger multi = factR.multiply(factN_R);
			BigInteger div = factN.divide(multi);

			// System.out.println("div " + div);
			choose.put(Collections.unmodifiableList(Arrays.asList(n, k)), div);
			return choose.get(choose_list);
		}
	}

	private static Map<List<Integer>, BigInteger> totalPossMap = new HashMap<List<Integer>, BigInteger>();

	public static BigInteger totalPossibleGraph(int n, int k) {
		List<Integer> totalPossMap_list = Arrays.asList(n, k);
		if (totalPossMap.containsKey(totalPossMap_list)) {
			return totalPossMap.get(totalPossMap_list);
		} else {
			BigInteger totalgraph = Choose(n * (n - 1), k);
			totalPossMap.put(Collections.unmodifiableList(Arrays.asList(n, k)),
					totalgraph);
			return totalPossMap.get(totalPossMap_list);
		}
	}

	public static void main(String args[]) {
		String a = Answer.answer(14, 15);
		System.out.println("ans " + a);
	}

}

/**
 * package Undercover_Underground;
 * 
 * import java.math.BigInteger; import java.util.HashMap; import java.util.Map;
 * 
 * public class Answer { public static String answer(int N, int K) { double a =
 * 0; int b = 0;
 * 
 * BigInteger aaa = Choose(N, 2); BigInteger aa = Choose(aaa.intValue(), K); if
 * (K == (N - 1)) { a = Math.pow(N, N - 2); b = (int) a; } else { b =
 * aa.intValue(); } System.out.println(aa); return String.valueOf(b);
 * 
 * // Your code goes here.
 * 
 * }
 * 
 * private static Map<Integer, BigInteger> factorials = new HashMap<Integer,
 * BigInteger>();
 * 
 * // this method gets the factorial of a number public static BigInteger
 * Factorial(int number) { if (factorials.containsKey(number)) return
 * factorials.get(number); BigInteger fact = new BigInteger("1"); for (int i =
 * 2; i <= number; i++) { fact = fact.multiply(BigInteger.valueOf(i)); }
 * factorials.put(number, fact); return fact; }
 * 
 * public static BigInteger Choose(int n, int r) { // BigInteger n2 =
 * Choose(n,2); BigInteger factN = Factorial(n); BigInteger factR =
 * Factorial(r); BigInteger factN_R = Factorial(n - r); BigInteger multi =
 * factR.multiply(factN_R); BigInteger div = factN.divide(multi);
 * 
 * if (r > n) { return Choose(r, n); } else return div; }
 * 
 * public static String preans(int n, int r) {
 * 
 * return null;
 * 
 * }
 * 
 * public static void main(String args[]) { Answer.answer(20, 3);
 * 
 * }
 * 
 * }
 */
