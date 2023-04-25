package sort_heap_sort;

import java.util.Arrays;

public class Main {

	public static void main(String[] heap_sort) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 2, 1, 8, 4, 7, 6, 3 };
		heapSort(arr);
		System.out.println("HEAP SORT: " + Arrays.toString(arr));
	}

	public static void heapSort(int[] arr) {
	    int n = arr.length;
	    // Tạo một heap từ mảng
	    for (int i = n / 2 - 1; i >= 0; i--)
	        heapify(arr, n, i);

	    // Sắp xếp từng phần tử của heap
	    for (int i = n - 1; i >= 0; i--) {
	        // Đưa phần tử lớn nhất (gốc) vào cuối mảng
	        int temp = arr[0];
	        arr[0] = arr[i];
	        arr[i] = temp;

	        // Tạo lại heap với các phần tử còn lại
	        heapify(arr, i, 0);
	    }
	}

	private static void heapify(int[] arr, int n, int i) {
	    int largest = i; /* GÁN INDEX TỪ GIỮA ĐẾN CỰC PHẢI CỦA MẢNG LÀM PHẦN TỬ LỚN NHẤT - VÒNG FOR ĐẦU CỦA heapSort() */
	    int left = 2 * i + 1; /* INDEX CỰC TRÁI */
	    int right = 2 * i + 2; /* INDEX CỰC PHẢI */
	    /* NẾU NHƯ CỰC TRÁI LẠI LỚN HƠN LỚN NHẤT THÌ CẬP NHẬT LỚN NHẤT */
	    /* ĐIỀU KIỆN left < n LÀ ĐẢM BẢO CHO KHÔNG RUN PHẢI LỖI OUT OF INDEX EXCEPTION */
	    /* TĂNG DẦN LÀ > */
	    if (left < n && arr[left] > arr[largest])
	        largest = left;

	    /* NẾU NHƯ CỰC PHẢI LẠI LỚN HƠN LỚN NHẤT THÌ CẬP NHẬT LỚN NHẤT */
	    /* ĐIỀU KIỆN right < n LÀ ĐẢM BẢO CHO KHÔNG RUN PHẢI LỖI OUT OF INDEX EXCEPTION */
	    /* TĂNG DẦN LÀ > */
	    if (right < n && arr[right] > arr[largest])
	        largest = right;

	    /* NẾU LỚN NHẤT ĐÃ ĐƯỢC CẬP NHẬT THÌ ĐỔI CHỖ LỚN NHẤT BAN ĐẦU VỚI LỚN NHẤT MỚI ĐƯỢC CẬP NHẬT */
	    if (largest != i) {
	    	/* SWAP */
	        int temp = arr[i];
	        arr[i] = arr[largest];
	        arr[largest] = temp;
	        /* TIẾP TỤC DỌN ĐỐNG VỚI LARGEST MỚI TÌM ĐƯỢC - ĐÃ ĐƯỢC CẬP NHẬT Ở CÁC VÒNG IF TRƯÓC */
	        heapify(arr, n, largest);
	    }
	}

}
