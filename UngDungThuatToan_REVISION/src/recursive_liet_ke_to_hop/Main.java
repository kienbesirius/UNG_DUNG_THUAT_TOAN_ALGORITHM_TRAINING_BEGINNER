package recursive_liet_ke_to_hop;

import java.util.Scanner;

/* BÀI 12: XÂY DỰNG CHƯƠNG TRÌNH LIỆT KÊ CÁC TỔ HỢP CỦA N PHẦN TỬ */
public class Main {

	public static void main(String[] liet_ke_to_hop) {
		// TODO Auto-generated method stub
	    Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        System.out.print("Enter the size of combinations: ");
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        int[] comb = new int[k];
        combine(arr, comb, 0, 0);
        sc.close();
	} /* END MAIN */

	/* ĐỆ QUY - RECURSIVE - COMBINE :: HÀM LIỆT KÊ TỔ HỢP */
	private static void combine(int[] arr, int[] comb, int start, int idx) {
        if (idx == comb.length) {
            printArray(comb);
        } else {
            for (int i = start; i < arr.length; i++) {
                comb[idx] = arr[i];
                combine(arr, comb, i + 1, idx + 1);
            }
        }
    } /* END COMBINE - LIỆT KÊ TỔ HỢP */

	/* ĐƠN GIẢN LÀ HIỂN THỊ RA DÃY MẢNG ĐƯỢC TRUYỀN VÀO */
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    } /* END PRINT ARRAY */
	
} /* END CLASS Main */
