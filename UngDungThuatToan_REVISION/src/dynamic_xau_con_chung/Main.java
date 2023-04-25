package dynamic_xau_con_chung;

import java.util.Scanner;

/* 
 * BÀI 8:
 * VIẾT CHƯƠNG TRÌNH NHẬP VÀO 2 XÂU, IN RA ĐỘ DÀI XÂU CON CHUNG LỚN NHẤT VÀ ĐỘ DÀI XÂU CHUNG ĐÓ 
 * VÍ DỤ: HAI XÂU “BACDB” VÀ “BDCB”, XÂU CON CHUNG CÓ ĐỘ DÀI LỚN NHẤT LÀ 3 VÀ LÀ “BCB”.
 */
public class Main {

	public static void main(String[] xau_con_chung) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		/* NHẬP 2 XÂU */
		System.out.print("First String: ");
		String str1 = scanner.nextLine();
		System.out.print("Second String: ");
		String str2 = scanner.nextLine();

		/* KHỞI TẠO INDEX */
		int m = str1.length();
		int n = str2.length();
		int[][] calculatedTable = new int[m][n];
		/* LẬP BẢNG */
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++) {
				if (str1.charAt(i) == str2.charAt(j))
					calculatedTable[i][j] = calculatedTable[i - 1][j - 1] + 1;
				else {
					if (calculatedTable[i - 1][j] > calculatedTable[i][j - 1])
						calculatedTable[i][j] = calculatedTable[i - 1][j];
					else
						calculatedTable[i][j] = calculatedTable[i][j - 1];
				}
			}
		/* HIỂN THỊ BẢNG */
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(calculatedTable[i][j] + " ");
//			}
//			System.out.println();
//		}

		/* GÁN INDEX ĐỂ TÌM KIẾM */
		int i = m - 1;
		int j = n - 1;
		String result = "";

		while (calculatedTable[i][j] != 0) {

			if (str1.charAt(i) == str2.charAt(j)) {
				result += str1.charAt(i) + "";
//				System.out.println(result);
				/* GIẢM INDEX */
				i--;
				j--;
			} else {
				if (calculatedTable[i][j - 1] > calculatedTable[i - 1][j]) {
					/* GIẢM INDEX */
					j--;
				} else {
					/* GIẢM INDEX */
					i--;
				}
			}

		}
		if (str1.length() > 1 && str2.length() > 1) {
			if (str1.charAt(0) == str2.charAt(0)) {
				result += str1.charAt(0);
			}
			if (str1.charAt(0) == str2.charAt(1)) {
				result += str2.charAt(1);
			}
			if (str1.charAt(1) == str2.charAt(0)) {
				result += str1.charAt(1);
			}
		} else if (str1.length() == 1 && str2.length() == 1) {
			if (str1.equals(str2)) {
				result = str1;
			} else {
				result = "!tnemelE oN";
			}
		}

		StringBuilder s = new StringBuilder(result);
		s.reverse();
		result = s.toString();
		System.out.println(result);
		scanner.close();

	}

}
