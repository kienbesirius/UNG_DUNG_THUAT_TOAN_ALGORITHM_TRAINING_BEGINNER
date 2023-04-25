package greedy_balo_gia_tri_nguyen;

import java.util.Arrays;

/* BÀI 14:  BÀI TOÁN XẾP BALO (XẾP BALO GIÁ TRỊ NGUYÊN) - KNAPSACK PROBLEM */
public class Main {

	/*
	 * HÀM COMPAREABLE �?ƯỢC IMPLEMENTS DÙNG ĐỂ SO SÁNH VÀ SẮP XẾP MẢNG Item TRONG
	 * TƯƠNG LAI
	 */
	static class Item implements Comparable<Item> {
		int value, weight;

		public Item(int value, int weight) {
			this.value = value;
			this.weight = weight;
		}

		public double getRatio() {
			return (double) value / weight;
		}

		@Override
		public int compareTo(Item other) {
			return Double.compare(other.getRatio(), this.getRatio());
		}

		@Override
		public String toString() {
			return "Item [value=" + value + ", weight=" + weight + "]";
		}
		
	}
	
	/* USE GREEDY PROGRAMING */
	public static void main(String[] balo_gia_tri_nguyen) {
		// TODO Auto-generated method stub
		int[] values = { 10, 40, 30, 50, 60 };
		int[] weights = { 5, 4, 6, 3, 8 };
		int fixedWeight = 10;

		int n = values.length;
		Item[] items = new Item[n];
		for (int i = 0; i < n; i++) {
			items[i] = new Item(values[i], weights[i]);
		}

		/*
		 * PHƯƠNG THỨC @Override compareTo(Item other){...} SẼ ĐƯỢC GỌI TRONG KHI GỌI
		 * Arrays.sort(items)
		 */
		Arrays.sort(items);
		for(Item item : items) {
			System.out.println(item.toString());
		}

		int totalValue = 0;
		int totalWeight = 0;
		for (Item item : items) {
			/* GREEDY PATH */
			if (totalWeight + item.weight <= fixedWeight) {
				totalValue += item.value;
				totalWeight += item.weight;
			} else {
				break;
			}
		}

		System.out.println("Maximum value that can be put in the knapsack is: " + totalValue);
	}

}
