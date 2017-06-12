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

