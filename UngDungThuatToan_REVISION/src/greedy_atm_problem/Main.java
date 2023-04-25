package greedy_atm_problem;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] atm_problem) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		/* MỆNH GIÁ VIỆT NAM ĐỒNG */
		int[] menhGia = {10, 20, 50, 100, 200, 500 };
		System.out.println("CAC MENH GIA: ");

		/* SORT GIẢM DẦN CÁC MỆNH GIÁ */
		sortDecrease(menhGia);
		/* HIỂN THỊ DANH SÁCH MỆNH GIÁ */
		System.out.println(Arrays.toString(menhGia));

		int money;
		System.out.print("SO TIEN MUON RUT: ");
		money = sc.nextInt();
		ATM(menhGia, money);
		sc.close();
	}


	public static void sortDecrease(int a[]) {
		for (int i = 0; i < a.length; i++) {
			int max = a[i];
			int max_idx = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] > max) {
					max = a[j];
					max_idx = j;
				}
			}
			int temp = a[i];
			a[i] = a[max_idx];
			a[max_idx] = temp;
		}
	}

	public static void ATM(int menhGia[], int money) {
			int i = 0;
			while (money != 0) {
				int soTo = money / menhGia[i];
				money -= soTo * menhGia[i];
				if(soTo != 0) {
					System.out.println("BAN NHAN DUOC " + soTo + " TO TIEN MENH GIA " + menhGia[i] + "K VND");
				}
				i++;

			}
	}

}
