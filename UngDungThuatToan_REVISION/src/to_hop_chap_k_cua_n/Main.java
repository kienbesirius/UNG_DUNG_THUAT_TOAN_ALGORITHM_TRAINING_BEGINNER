package to_hop_chap_k_cua_n;

public class Main {

	public static void main(String[] to_hop_chap_k_cua_n) {
		// TODO Auto-generated method stub
		int n = 24;
		int k = 10;
		// The right result is 1961256 with n = 24 and k = 10 (checked)

		// SOLVE BY DYNAMIC
		final long startTime = System.currentTimeMillis();
		int[][] twoDimArray = new int[n + 1][k + 1];
		SolveByDynamic(twoDimArray, n, k);
		System.out.println("Ket Qua To Hop: " + twoDimArray[n][k]);
		final long endTime = System.currentTimeMillis();
		System.out.println("Dynamic: " + (endTime - startTime) + " TimeMilliseconds");

		// SOVLE BY RECURSIVE
		final long startTime2 = System.currentTimeMillis();
		System.out.println("Ket Qua To Hop: " + Synthesis(k, n));
		final long endTime2 = System.currentTimeMillis();
		System.out.println("Recursive: " + (endTime2 - startTime2) + " TimeMilliseconds");
	}
	

	static void PrintArray(int array[][], int n, int k) {
		// Print Result
		for (int row = 0; row <= n; row++) {
			for (int col = 0; col <= k; col++) {
				System.out.print(array[row][col] + "\t");
			}
			System.out.println();
		}
	}

	static void SolveByDynamic(int array[][], int n, int k) {
		// Set Base Data Result
		for (int row = 0; row <= n; row++) {
			for (int col = 0; col <= k; col++) {
				if (col == 0 || row == col)
					array[row][col] = 1;
				else {
					if (row > 1) {
						array[row][col] = array[row - 1][col - 1] + array[row - 1][col];
					}
				}
			}
		}
	}

	static int Synthesis(int k, int n) {
		if (k > n)
			return -9999; // error
		if (n == 0 || k == n)
			return 1;
		if (k == 1)
			return n;
		return Synthesis(k - 1, n - 1) + Synthesis(k, n - 1);
	}

}
