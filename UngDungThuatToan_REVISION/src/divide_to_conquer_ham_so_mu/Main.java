package divide_to_conquer_ham_so_mu;

import java.util.Scanner;

public class Main {

	public static void main(String[] ham_so_mu) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Put a: ");
		int a = sc.nextInt();
		System.out.println("Put n: ");
		int soMu = sc.nextInt();
		System.out.println(soMu(a,soMu));
		sc.close();
	}
	
	private static int soMu(int a, int soMu) {
		if(soMu == 0) {
			return 1;
		}else {
			if(soMu == 1) {
				return a;
			}
			else {
				if(soMu % 2 == 0) {
					return soMu(a, soMu/2) * soMu(a, soMu/2);
				}else {
					return soMu(a, soMu - 1) * a;
				}
			}
		}
	}

}
