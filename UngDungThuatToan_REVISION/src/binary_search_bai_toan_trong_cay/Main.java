package binary_search_bai_toan_trong_cay;

import java.util.Arrays;
import java.util.Scanner;

/*
 * BÀI 6:
 * BÀI TOÁN TRỒNG CÂY
 * CHO n HẠT GIỐNG CÓ SÔ NGÀY RA HOA TƯƠNG ỨNG LÀ d1, d2, d3,…. 
 * TRỒNG MỖI NGÀY 1 HẠT GIỐNG. 
 * VIẾT CHƯƠNG TRÌNH TÌM SỐ NGÀY SỚM NHẤT ĐỂ TỔ CHỨC TIỆC NGOÀI VƯỜN KHI TẤT CẢ CÁC HẠT GIỐNG ĐÃ RA HOA
 */
public class Main {

	public static void main(String[] bai_toan_trong_cay) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("ENTER THE SEEDS: ");
		int n = scanner.nextInt();
		/* days FOR CHECK()  */
		int[] days = new int[n];
		/* d FOR earliestPartyDAy() */
		int[] d = new int[n];
		System.out.println("ENTER THE DURATION FOR EACH SEED!");
		for (int i = 0; i < n; i++) {
			System.out.print("SEED (" + (i+1) + "): ");
			days[i] = scanner.nextInt();
			d[i] = days[i];
		}

		Arrays.sort(days);
		System.out.println("MATURE AND BLOOM DAYS OF EACH SEED: " + Arrays.toString(days));
		System.out.println("DAY NEED FOR PARTY: " + check(days));
		Arrays.sort(d);
		System.out.println("MATURE AND BLOOM DAYS OF EACH SEED: " + Arrays.toString(d));
		System.out.println("DAY NEED FOR PARTY: " + earliestPartyDay(d));
		scanner.close();
	}

	/* NORMAL CALCULATE */
	private static int check(int[] days) {
		/* SỐ NGÀY CẦN ĐỂ TRỒNG HẾT SỐ HẠT */
		int plantTime = days.length; 
		for(int i = plantTime - 1; i > -1 ;i--) {
			int timeUsed =  i + 1;
			days[i] -= timeUsed;
		}
		int result = -1;
		for(int i : days) {
			result = Math.max(result, i);
		}
		return result;
	}
	
	/* BINARY SEARCH */
	public static int earliestPartyDay(int[] d) {
	    int shortestGrowth = 1, longestGrowth = Integer.MIN_VALUE;
	    for (int i = 0; i < d.length; i++) {
	        longestGrowth = Math.max(longestGrowth, d[i]);
	    }
	    while (shortestGrowth < longestGrowth) {
	        int averageGrowth = (longestGrowth + shortestGrowth) / 2;
	        boolean allGrown = true;
	        for (int i = 0; i < d.length; i++) {
	            if (averageGrowth < d[i]) {
	                allGrown = false;
	                break;
	            }
	        }
	        if (allGrown) {
	            longestGrowth = averageGrowth;
	        } else {
	            shortestGrowth = averageGrowth + 1;
	        }
	    }
	    return shortestGrowth;
	}
}
