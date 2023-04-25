package recursive_min_cost_of_changing_string;

import java.util.Scanner;

/* BÀI 9: VIẾT CHƯƠNG TRÌNH BIẾN ĐỔI XÂU x=(x1,x2,…) VÀ y=(y1,y2,…) 
 * TÌM SỐ THAO TÁC NHỎ NHẤT ĐỂ BIẾN ĐỔI XÂU X VỀ XÂU Y.
 * VÍ DỤ: XÂU ‘cat’ VÀ ‘cut’ CẦN 1 PHÉP TOÁN ĐỂ BIẾN ĐỔI ‘a’ THÀNH ‘u’. 
 */
public class Main {

	/* ĐỆ QUY - RECURSIVE */
	public static void main(String[] min_cost_of_changing_string) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Frist String: ");
		String str01 = sc.nextLine();
		System.out.println("Second String: ");
		String str02 = sc.nextLine();

		int xlen = str01.length();
		int ylen = str02.length();

		System.out.println("Min Cost Of Changing String!");
		System.out.println("From: " + str01);
		System.out.println("To: " + str02);
		System.out.println("Min Cost (Step): " + minCost(str01, str02, xlen, ylen));
		sc.close();
	}

	public static int minCost(String x, String y, int xlen, int ylen) {
		/* XLEN == 0 TỨC LÀ ĐÃ KIỂM TRA XONG XÂU X */
		/*
		 * TỨC LÀ KHI XÂU X CÓ KÍCH THƯỚC NHỎ HƠN XÂU Y THÌ SỐ KÝ TỰ CÒN LẠI,
		 * MÀ KHÁC VỚI KÝ TỰ CÓ Ở XÂU X LÀ SỐ BƯỚC THỰC HIỆN
		 */
		if (xlen == 0) {
			return ylen;
		}
		/* YLEN == 0 TỨC LÀ ĐÃ KIỂM TRA XONG XÂU Y */
		if (ylen == 0) {
			return xlen;
		}
		/*
		 * NẾU KÝ TỰ CUỐI CÙNG CỦA XÂU X VÀ Y GIỐNG NHAU, 
		 * TIẾP TỤC KIỂM TRA CÁC KÝ TỰ TIẾP THEO
		 */
		if (x.charAt(xlen - 1) == y.charAt(ylen - 1)) {
			return minCost(x, y, xlen - 1, ylen - 1);
		}

		/*
		 * NẾU KÝ TỰ CUỐI CÙNG CỦA XÂU X VÀ Y KHÁC NHAU, 
		 * TÍNH TOÁN CHI PHÍ CỦA CÁC PHÉP TOÁN VÀ LẤY PHÉP TOÁN CÓ CHI PHÍ NHỎ NHẤT
		 */
		else {
			int insert = minCost(x, y, xlen, ylen - 1);
			int delete = minCost(x, y, xlen - 1, ylen);
			int replace = minCost(x, y, xlen - 1, ylen - 1);
			return 1 + Math.min(Math.min(insert, delete), replace);
		}
	}
}
