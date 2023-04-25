package recursive_liet_ke_hoan_vi;

import java.util.Scanner;

/* BÀI 11: XÂY DỰNG CHƯƠNG TRÌNH LIỆT KÊ CÁC HOÁN VỊ CỦA N PHẦN TỬ */
public class Main {

	/* MAIN */
	public static void main(String[] liet_ke_hoan_vi) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of elements: ");
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		permute(arr, 0, n - 1);
		sc.close();
	} /* END MAIN */

	/* ĐỆ QUY - RECURSIVE - PERMUTE :: HÀM LIỆT KÊ HOÁN VỊ SỬ DỤNG ĐỆ QUY */
	private static void permute(int[] arr, int left, int right) {
		if (left == right) {
			printArray(arr);
		} else {
			for (int i = left; i <= right; i++) {
				swap(arr, left, i);
				permute(arr, left + 1, right);
				swap(arr, left, i);
			}
		}
	} /* END PERMUTE - LIỆT KÊ HÓAN VỊ */

	/* ĐỔI CHỖ 2 PHẦN TỬ TRONG MẢNG ĐƯỢC TRUYỀN VÀO */
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	} /* END SWAP */

	/* ĐƠN GIẢN LÀ HIỂN THỊ RA DÃY MẢNG ĐƯỢC TRUYỀN VÀO */
	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	} /* END PRINT ARRAY */

} /* END CLASS Main */
