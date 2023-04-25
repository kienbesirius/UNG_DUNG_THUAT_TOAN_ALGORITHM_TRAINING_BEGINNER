package sort_insertion_sort;

import java.util.Arrays;

public class Main {

	public static void main(String[] insertion_sort) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 2, 1, 8, 4, 7, 6, 3 };
		insertionSort(arr);
		System.out.println("INSERTION SORT: " + Arrays.toString(arr));
	}

	public static void insertionSort(int[] arr) {
	    int n = arr.length;
	    for (int i = 1; i < n; i++) {
	    	/* CHỌN KEY LÀ MỘT GIÁ TRỊ PHẦN TỬ TRONG MẢNG */
	        int key = arr[i];
	        /* INDEX j LÀ INDEX j TRỪ ĐI 1 */
	        int j = i - 1;
	        /* KHI MÀ j >= 0; VÒNG LẶP ĐẦU TIÊN THÌ j SẼ = 0 */
	        /* NẾU PHẦN TỬ CỦA INDEX j LỚN HƠN KEY ĐÃ CHỌN THÌ ĐỔI DẤU - TĂNG DẦN LÀ > */
	        while (j >= 0 && arr[j] > key) {
	            arr[j + 1] = arr[j];
//	            arr[j] = key;
	            j--;
	        }
	        /* BỞI VÌ TRONG KHỐI While ĐANG TÌM VÀ SO SÁNH */
	        /* CHO NÊN PHẢI RA KHỎI While THÌ MỚI CÓ KẾT QUẢ CUỐI CÙNG ĐỂ ĐỔI CHỖ */
	        /* NẾU CHO CÂU LỆNH NÀY VÀO WHILE THÌ THUẬT TOÁN VẪN HOẠT ĐỘNG NHƯNG NÓ KO TỐI ƯU */
	        arr[j + 1] = key;
	    }
	}

}
