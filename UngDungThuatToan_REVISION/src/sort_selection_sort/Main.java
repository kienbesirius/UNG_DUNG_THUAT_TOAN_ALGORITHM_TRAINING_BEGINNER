package sort_selection_sort;

import java.util.Arrays;

public class Main {

	public static void main(String[] selection_sort) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 2, 1, 8, 4, 7, 6, 3 };
		selectionSort(arr);
		System.out.println("SELECTION SORT: " + Arrays.toString(arr));
	}
	
	public static void selectionSort(int[] arr) {
	    int n = arr.length;
	    for (int i = 0; i < n - 1; i++) {
	    	/* ĐẶT PHẦN TỬ THỨ i LÀ MIN */
	        int minIndex = i;
	        for (int j = i + 1; j < n; j++) {
	        	/* NẾU MÀ CÓ PHẦN TỬ NÀO NHỎ HƠN PHẦN TỬ NÊU TRÊN THÌ CẬP NHẬT GIÁ TRỊ */
	        	/* TĂNG DẦN LÀ < */ 
	        	/* GIẢM DẦN THÌ ĐỔI DẤU "<" THÀNH DẤU ">" */
	            if (arr[j] < arr[minIndex]) {
	            	/* TÌM ĐƯỢC minIndex NHỎ NHẤT */
	                minIndex = j;
	            }
	        }
	        /* ĐỔI CHỖ PHẦN TỬ MIN BAN ĐẦU VỚI PHẦN TỬ MIN MỚI TÌM ĐƯỢC */
	        int temp = arr[minIndex];
	        arr[minIndex] = arr[i];
	        arr[i] = temp;
	    }
	}

}
