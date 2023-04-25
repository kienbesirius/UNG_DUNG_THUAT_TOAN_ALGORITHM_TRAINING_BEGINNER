package dynamic_balo_gia_tri_nguyen;

import java.util.ArrayList;
import java.util.List;

/* BÀI 14:  BÀI TOÁN XẾP BALO (XẾP BALO GIÁ TRỊ NGUYÊN) - KNAPSACK PROBLEM */
public class Main {

	/* USE DYNAMIC PROGRAMING */
	public static void main(String[] balo_gia_tri_nguyen) {
		// TODO Auto-generated method stub
		  int[] values = {10, 40, 30, 50, 60};
	        int[] weights = {5, 4, 6, 3, 8};
	        int maxKnapsackWeight = 10;

	        int n = values.length;
	        int[][] Knapsack = new int[n+1][maxKnapsackWeight+1];

	        for (int i = 0; i <= n; i++) {
	            for (int maxW = 0; maxW <= maxKnapsackWeight; maxW++) {
	                if (i == 0 || maxW == 0) {
	                    Knapsack[i][maxW] = 0;
	                } else if (weights[i-1] > maxW) {
	                	Knapsack[i][maxW] = Knapsack[i-1][maxW];
	                } else {
	                	Knapsack[i][maxW] = Math.max(Knapsack[i-1][maxW], Knapsack[i-1][maxW-weights[i-1]] + values[i-1]);
	                }
	            }
	        }
	        
	        int maxValue = Knapsack[n][maxKnapsackWeight];
	        System.out.println("Maximum value that can be put in the knapsack is: " + maxValue);

	        int w = maxKnapsackWeight;
	        List<Integer> items = new ArrayList<>();
	        for (int i = n; i > 0 && maxValue > 0; i--) {
	            if (maxValue == Knapsack[i-1][w]) {
	                continue;
	            } else {
	                items.add(i-1);
	                maxValue -= values[i-1];
	                w -= weights[i-1];
	            }
	        }
	        System.out.println("Items that are selected:");
	        for (int i = items.size()-1; i >= 0; i--) {
	            System.out.println("Item " + items.get(i) + " with value " + values[items.get(i)] + " and weight " + weights[items.get(i)]);
	        }
	}

}
