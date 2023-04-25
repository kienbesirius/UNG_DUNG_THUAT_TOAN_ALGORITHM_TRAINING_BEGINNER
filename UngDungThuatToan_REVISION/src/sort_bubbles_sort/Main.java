package sort_bubbles_sort;

import java.util.Arrays;

public class Main {

	public static void main(String[] bubbles_sort) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 2, 1, 8, 4, 7, 6, 3 };
		bubbleSort(arr);
		System.out.println("BUBBLES SORT: " + Arrays.toString(arr));
	}
	public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
            	/* TĂNG DẦN LÀ > */
                if (arr[j] > arr[j + 1]) {
                    /* SWAP */
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
