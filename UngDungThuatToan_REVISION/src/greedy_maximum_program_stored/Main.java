package greedy_maximum_program_stored;

import java.util.Arrays;

/* BÀI 15: BÀI TOÁN LƯU TRỮ TỐI ĐA SỐ LƯỢNG CHƯƠNG TRÌNH (maximum program stored)*/
public class Main {

	/* USE GREEDY PROGRAMING */
	static class Program implements Comparable<Program> {
		int size, value;

		public Program(int size, int value) {
			this.size = size;
			this.value = value;
		}

		@Override
		public int compareTo(Program other) {
			return Integer.compare(other.value, this.value);
		}
	}

	public static void main(String[] maximum_program_stored) {
		// TODO Auto-generated method stub
		Program[] programs = { new Program(10, 60), new Program(20, 100), new Program(30, 120) };
		int memorySize = 50;
		int maxTotalValue = maxProgramStored(programs, memorySize);
		System.out.println("The maximum total value of stored programs is " + maxTotalValue);
	}

	/* GREEDY METHOD */
	public static int maxProgramStored(Program[] programs, int memorySize) {
		Arrays.sort(programs);
		int totalValue = 0;
		int totalSize = 0;
		int i = 0;
		while (i < programs.length && totalSize + programs[i].size <= memorySize) {
			totalValue += programs[i].value;
			totalSize += programs[i].size;
			i++;
		}
		return totalValue;
	}

}
