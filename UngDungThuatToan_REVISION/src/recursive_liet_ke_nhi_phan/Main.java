package recursive_liet_ke_nhi_phan;

import java.util.Scanner;

/* BÀI 13: XÂY DỰNG CHƯƠNG TRÌNH LIỆT KÊ CÁC DÃY NHỊ PHÂN CÓ N PHẦN TỬ */
public class Main {

	public static void main(String[] liet_ke_nhi_phan) {
		// TODO Auto-generated method stub
		   Scanner sc = new Scanner(System.in);
	        System.out.print("Enter the length of binary strings: ");
	        int n = sc.nextInt();
	        int[] arr = new int[n];
	        generateBinaryStrings(arr, 0);
	        sc.close();
	} /* END MAIN */
	
	/* ĐỆ QUY - RECURSIVE - GENERATE BINARY STRINGS :: LIỆT KÊ CÁC DÃY NHỊ PHÂN CÓ N PHẦN TỬ*/
	private static void generateBinaryStrings(int[] arr, int idx) {
        if (idx == arr.length) {
            printArray(arr);
        } else {
            arr[idx] = 0;
            generateBinaryStrings(arr, idx + 1);
            arr[idx] = 1;
            generateBinaryStrings(arr, idx + 1);
        }
    } /* END generateBinaryStrings - LIỆT KÊ NHỊ PHÂN CÓ N PHẦN TỬ*/

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    } /* END PRINT ARRAY */

} /* END CLASS Main */
