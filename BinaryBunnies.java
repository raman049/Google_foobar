package binary_bunnies.src.binary_bunnies;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Answer {

	static int[] seq1 = { 90, 80, 70, 60, 50, 40, 30, 20, 10, 95, 85, 75, 65, 55, 45, 35, 25, 15, 5, 100, 200, 300, 400,
			500, 600, 700, 800, 900, 102, 202, 303, 404, 505, 606, 707, 808 };
	static int i = 0;

	public static String answer(int[] seq) {
		Node root2 = new Node(seq);
		return preAnswer(root2);

	}

	// creat Node
	public static class Node {
		Integer key;
		Node leftChild;
		Node rightChild;

		public Node(int keys) {
			this.key = keys;
		}

		public Node(int[] values) {
			this.key = null;
			this.leftChild = null;
			this.rightChild = null;
			for (int value : values) {
				insert(value);
			}

		}

		public Integer getValue() {
			return this.key;
		}

		private void insert(int value) {
			if (this.getValue() == null)
				this.key = value;

			else if (this.getValue() > value) {
				if (this.rightChild == null)
					this.rightChild = new Node(value);
				else
					this.rightChild.insert(value);
			}

			else if (this.getValue() < value) {
				if (this.leftChild == null)
					this.leftChild = new Node(value);
				else
					this.leftChild.insert(value);
			}
		}

	}

	// sum of numbers of nodes
	public static int numNodes(Node root) {
		if (root == null)
			return 0;
		return 1 + numNodes(root.leftChild) + numNodes(root.rightChild);
	}

	private static Map<Integer, BigInteger> factorials = new HashMap<Integer, BigInteger>();

	// Factorail value of an integer
	public static BigInteger permutaion(int node_count) {
		if (factorials.containsKey(node_count))
			return factorials.get(node_count);
		BigInteger fact = new BigInteger("1");
		for (int i = 2; i <= node_count; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		factorials.put(node_count, fact);
		return fact;
	}
	public static BigInteger Choose(int n, int r) {
		if (r > n) {
			return Choose(r, n);
		} else
			return (permutaion(n).divide((permutaion(r).multiply(permutaion(n - r)))));
	}
	
	public static String preAnswer(Node root) {
		if (root == null || root.getValue() == null)
			return "1";

		int ls = numNodes(root.leftChild);// leftCount(seq1);
		//System.out.println("ls " + ls);
		int rs = numNodes(root.rightChild);// rightCount(seq1);
		//System.out.println("rs " + rs);
		// int numOfnodes = 1+ls+rs;
		// System.out.println("no of nodes "+numOfnodes);
		BigInteger lp = new BigInteger(preAnswer(root.leftChild));
		//System.out.println("lp " + lp);
		BigInteger rp = new BigInteger(preAnswer(root.rightChild));
		//System.out.println("rp " + rp);
		BigInteger choose = Choose((ls + rs), (Math.min(rs, ls)));
		//System.out.println("choose " + choose);
		BigInteger aaa = lp.multiply(rp);
		BigInteger answer = (choose.multiply(aaa));// .multiply(rp);
		// BigInteger an = lp.multiply(rp) ;
		//System.out.println("preAnswer " + (answer.toString()));
		return (answer.toString());

	}
	public static void main(String args[]) {
		String aa = answer(seq1);
		System.out.println(aa);
	}

}


/**
 * Binary bunnies ==============
 * 
 * As more and more rabbits were rescued from Professor Booleans horrid
 * laboratory, you had to develop a system to track them, since some habitually
 * continue to gnaw on the heads of their brethren and need extra supervision.
 * For obvious reasons, you based your rabbit survivor tracking system on a
 * binary search tree, but all of a sudden that decision has come back to haunt
 * you.
 * 
 * To make your binary tree, the rabbits were sorted by their ages (in days) and
 * each, luckily enough, had a distinct age. For a given group, the first rabbit
 * became the root, and then the next one (taken in order of rescue) was added,
 * older ages to the left and younger to the right. The order that the rabbits
 * returned to you determined the end pattern of the tree, and herein lies the
 * problem.
 * 
 * Some rabbits were rescued from multiple cages in a single rescue operation,
 * and you need to make sure that all of the modifications or pathogens
 * introduced by Professor Boolean are contained properly. Since the tree did
 * not preserve the order of rescue, it falls to you to figure out how many
 * different sequences of rabbits could have produced an identical tree to your
 * sample sequence, so you can keep all the rescued rabbits safe.
 * 
 * For example, if the rabbits were processed in order from [5, 9, 8, 2, 1], it
 * would result in a binary tree identical to one created from [5, 2, 9, 1, 8].
 * 
 * You must write a function answer(seq) that takes an array of up to 50
 * integers and returns a string representing the number (in base-10) of
 * sequences that would result in the same tree as the given sequence.
 * 
 * Languages =========
 * 
 * To provide a Python solution, edit solution.py To provide a Java solution,
 * edit solution.java
 * 
 * Test cases ==========
 * 
 * Inputs: (int list) seq = [5, 9, 8, 2, 1] Output: (string) "6"
 * 
 * Inputs: (int list) seq = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] Output: (string) "1"
 * 
 * Use verify [file] to test your solution and see how it does. When you are
 * finished editing your code, use submit [file] to submit your answer. If your
 * solution passes the test cases, it will be removed from your home folder.
 */

