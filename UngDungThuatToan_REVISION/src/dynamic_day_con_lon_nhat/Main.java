package dynamic_day_con_lon_nhat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s = dataInput();
		int n = s.length;
		long begin;
		long end;

		/* DUYỆT THƯỜNG */
		System.out.println("\n/* DUYỆT THƯỜNG */");
		begin = Calendar.getInstance().getTimeInMillis();
		DuyetDayCon(s, n);
		end = Calendar.getInstance().getTimeInMillis();
		System.out.println("Execution Time: " + (end - begin) + " ms");

		/* DUYỆT CHIA ĐỂ TRỊ */
		System.out.println("\n/* DUYỆT CHIA ĐỂ TRỊ */");
		begin = Calendar.getInstance().getTimeInMillis();
		divide_to_conquer(s, n);
		end = Calendar.getInstance().getTimeInMillis();
		System.out.println("Execution Time: " + (end - begin) + " ms");

		/* DUYỆT QUY HOẠCH ĐỘNG */
		System.out.println("\n/* DUYỆT QUY HOẠCH ĐỘNG */");
		begin = Calendar.getInstance().getTimeInMillis();
		dynamic(s);
		end = Calendar.getInstance().getTimeInMillis();
		System.out.println("Execution Time: " + (end - begin) + " ms");

	}

	public static void DuyetDayCon(int[] s, int n) {
		int max_sum = 0;
		int start_index = -1;
		int end_index = -1;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += s[j];
				if (sum > max_sum) {
					max_sum = sum;
					start_index = i;
					end_index = j;
				}
			}
		}
		// In kết quả
		System.out.println("Tong lon nhat: " + max_sum);
		System.out.print("Day con tuong ung: ");
		for (int i = start_index; i <= end_index; i++) {
			System.out.print(s[i] + " ");
		}
		System.out.println();
	}

	public static void dynamic(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n]; // Tạo mảng dp để lưu trữ dãy con liên tiếp có tổng lớn nhất tại vị trí i

		// Khởi tạo giá trị đầu tiên
		dp[0] = nums[0];
		int maxSum = dp[0];
		int end_index = 0;
		// Tính toán dãy con liên tiếp có tổng lớn nhất tại vị trí i bằng cách so sánh
		// giá trị của số đang xét và tổng của số đó với dãy con liên tiếp có tổng lớn
		// nhất tại vị trí i-1
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
			if (maxSum < dp[i]) {
				maxSum = dp[i];
				end_index = i;
			}
		}
		System.out.println("MaxSum = " + maxSum);
		System.out.println("end_index: " + end_index);

	}

	// Chia để trị
	public static void divide_to_conquer(int[] s, int n) {
		int max_sum = timConMax(s, 0, n - 1);
		// In kết quả
		System.out.println("MAX SUM: " + max_sum);
	}

	public static int timConMax(int[] a, int from, int to) {
		if (from == to) {
			return a[from];
		}
		int mid = (from + to) / 2;
		int left_sum = timConMax(a, from, mid);
		int right_sum = timConMax(a, mid + 1, to);
		int crossing_sum = findMaxCrossingSubarraySum(a, from, mid, to);
		return Math.max(Math.max(right_sum, left_sum), crossing_sum);

	}

	public static int findMaxCrossingSubarraySum(int[] a, int from, int mid, int to) {
		int left_sum = -999;
		int sum = 0;
		for (int i = mid; i >= from; i--) {
			sum = sum + a[i];
			if (sum > left_sum)
				left_sum = sum;
		}
		int right_sum = -999;
		sum = 0;
		for (int i = mid + 1; i <= to; i++) {
			sum = sum + a[i];
			if (sum > right_sum)
				right_sum = sum;
		}
		return left_sum + right_sum;
	}

	public static int[] dataInput() {
		int array[] = new int[1];
		String fileName = "my_data_number_int_array.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String[] values = br.readLine().toString().split(" ");
			array = new int[values.length];
			for(int i = 0; i<array.length; i++) {
				try {
					array[i] = Integer.parseInt(values[i]);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return array;
		} catch (IOException e) {
			e.printStackTrace();
			return array;
		}
	}

}
