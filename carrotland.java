package carrotland;

public class carrotland {
	static int[][] vertices1 = { { -2, -3 }, { -6, -9 }, { 10, 160 } };
	static int[][] vertices2 = { { 91207, 89566 }, { -88690, -83026 },
			{ 67100, 47194 } };

	public static int answer(int[][] vertices) {
		long Area = 0;
		long boundaryPoint = 0;
		long interiorPoint = 0;
		long ax = vertices[0][0];
		long ay = vertices[0][1];
		long bx = vertices[1][0];
		long by = vertices[1][1];
		long cx = vertices[2][0];
		long cy = vertices[2][1];

		// Area = Math.abs((ax*(by-1*(cy))+bx*(cy-1*(ay))+cx*(ay-1*(by)))/2);
		Area = Math
				.abs((ax * (by - cy) + bx * (cy - ay) + cx * (ay - by)) / 2);
		boundaryPoint = Math.abs(gcd(ay - by, ax - bx))
				+ Math.abs(gcd(ay - cy, ax - cx))
				+ Math.abs(gcd(by - cy, bx - cx));
		interiorPoint = Area + 1 - (boundaryPoint / 2);
	//	long aa= Area.longValue();
		System.out.println(Area);
		System.out.println(interiorPoint);
		return (int)interiorPoint;
	}

	public static long gcd(long a, long b) {
		if (b == 0 || b == 0) {
			return Math.abs(a + b);
		}
		return gcd(b, a % b);
	}

	public static void main(String[] args) {
		answer(vertices2);

	}

}

/**
 * Inputs: (int) vertices = [[2, 3], [6, 9], [10, 160]] Output: (int) 289
 **/
