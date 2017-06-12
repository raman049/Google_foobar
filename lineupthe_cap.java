package line_up_the_captives;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Answer {

	public static String answer(int x, int y, int n) {

		BigInteger combination = BigInteger.ZERO;
		BigInteger totalCombination = BigInteger.ZERO;
		for (int Xspace = x - 1; Xspace < n - y + 1; Xspace++) {
			BigInteger XspaceCombination = ToltalCombination(x - 1, Xspace); //total combination possible from x side
			BigInteger YspaceCombination = ToltalCombination(y - 1, n - Xspace- 1); // total combination possible from y side
			BigInteger rembig = Combination(n - 1, Xspace);     //combination for remaining spots
			combination = XspaceCombination.multiply(YspaceCombination
					.multiply(rembig));                              
			totalCombination = totalCombination.add(combination);
		}
		System.out.print(totalCombination);
		return totalCombination.toString();
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

	private static Map<List<Integer>, BigInteger> combination = new HashMap<List<Integer>, BigInteger>();

	public static BigInteger Combination(int n, int k) {
		List<Integer> combination_list = Arrays.asList(n, k);
		if (combination.containsKey(combination_list)) {
			return combination.get(combination_list);
		} else {
			BigInteger factN = Factorial(n);
			BigInteger factR = Factorial(k);
			BigInteger factN_R = Factorial(n - k);
			BigInteger multi = factR.multiply(factN_R);
			BigInteger div = factN.divide(multi);
			combination.put(Collections.unmodifiableList(Arrays.asList(n, k)),
					div);
		}
		return combination.get(combination_list);
	}

	private static Map<List<Integer>, BigInteger> totalCombination = new HashMap<List<Integer>, BigInteger>();

	public static BigInteger ToltalCombination(int k, int n) {
		List<Integer> totalCombination_list = Arrays.asList(k, n);
		if (k > n) // it is not possible to show more rabbits than available
					// rabbits
			return BigInteger.ZERO;

		if (k == n) // there is only one way to arrange if n ==k
			return BigInteger.ONE;

		if (totalCombination.containsKey(totalCombination_list)) {
			return totalCombination.get(totalCombination_list);
		}
		BigInteger total = BigInteger.ZERO;
		for (int i = 0; i < n; i++) {
			int requireNum = i;
			int hiddenNum = n - requireNum - 1;
			BigInteger ComHidden = Factorial(hiddenNum);
			BigInteger ComReqNum = Combination(n - 1, requireNum);
			BigInteger ComHighNum = ToltalCombination(k - 1, requireNum);
			BigInteger multi = ComHidden.multiply(ComReqNum
					.multiply(ComHighNum));
			total = total.add(multi);
			totalCombination.put(
					Collections.unmodifiableList(Arrays.asList(k, n)), total);
		}
		return total;
	}

	public static void main(String[] args) {
		Answer.answer(1, 2, 6);
		// System.out.print("slkdfj");
	}
}
