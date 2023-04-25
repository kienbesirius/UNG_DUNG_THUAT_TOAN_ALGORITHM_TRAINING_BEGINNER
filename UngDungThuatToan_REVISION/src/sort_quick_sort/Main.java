package sort_quick_sort;

import java.util.Arrays;

public class Main {

	public static void main(String[] quick_sort) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 2, 1, 8, 4, 7, 6, 3 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println("QUICK SORT: " + Arrays.toString(arr));
	}

	/* THỰC HIỆN QUICKSORT */
	/*
	 * leftPole : LÀ INDEX PHÍA BÊN TRÁI CỦA MẢNG (SAU PHI PHÂN VÙNG) rightPole : LÀ
	 * INDEX PHÍA BÊN PHẢI CỦA MẢNG (SAU KHI PHÂN VÙNG) ĐẦU TIÊN CHIA ĐÔI MẢNG VỚI
	 * pivotIndex, pivotIndex NÀY NẰM GIỮA leftPole VÀ rightPole
	 */
	public static void quickSort(int[] arr, int leftPole, int rightPole) {
		if (leftPole < rightPole) {
			/* GIÁ TRỊ pivotIndex PHỤ THUỘC VÀO SỐ LẦN ĐỔI CHỖ TRONG PARTITION */
			int pivotIndex = partition(arr, leftPole, rightPole);
			/* ĐỆ QUY NỬA TRÁI CỦA MẢNG */
			quickSort(arr, leftPole, pivotIndex - 1);
			/* ĐỆ QUY NỬA PHẢI CỦA MẢNG */
			quickSort(arr, pivotIndex + 1, rightPole);
		}

	}

	/* PHÂN ĐÔI MẢNG ĐỂ ĐỔI CHỖ */
	public static int partition(int[] arr, int leftPole, int rightPole) {
		/* pivotValue DÙNG ĐỂ SO SÁNH VỚI NHỮNG GIÁ TRỊ PHẦN TỬ MẢNG KHÁC */
		int pivotValue = arr[rightPole];

		/* GIÁ TRỊ CỦA leftPole Ở HÀM NÀY KHI MỚI BẮT ĐẦU CHƯƠNG TRÌNH LÀ 0 */
		int i = leftPole - 1;
		for (int j = leftPole; j < rightPole; j++) {
			/* <= LÀ SẮP SẾP TĂNG DẦN */
			if (arr[j] <= pivotValue) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, rightPole);
		return i + 1;
	}

	/* ĐỔI CHỖ */
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
