/*
 * MEHMET ETKA UZUN - 150118504
 * This program check all neighbor cells and change the cells' depends on rules
 * 
 */

import java.util.Scanner;

public class Pro5_2_150118504 {

	public static void main(String[] args) {
		// create scan
		Scanner scan = new Scanner(System.in);

		// variables
		String str;
		int stepNum;
		int checkPoint = 0;
		int checkPoint2 = 1;
		
		// header
		System.out.println("Welcome to our program");

		// take inputs
		do {
			System.out.print("Enter a string: ");
			str = scan.next();
			if (check(str) == true)
				checkPoint = 1;
			else
				System.out.println("The number " + invalid(str) + " cannot be represented with " + size(str) + "x" + size(str) + " array!");
						

		} while (checkPoint == 0);
		System.out.print("Enter a number of steps: ");
		stepNum = scan.nextInt();

		// Working system of code

		// variables of arrays
		int[][] original = new int[size(str)][size(str)];
		int[][] fake = new int[size(str)][size(str)];
		int[] binary = new int[size(str)];// it stores the binary
		int[] decimal = new int[size(str)];// it stores decimal

		// filling the original array
		for (int i = 0; i < binary.length; i++) {
			binary = convert(num(str, i, size(str)), size(str));
			for (int j = 0; j < binary.length; j++) {
				original[i][j] = binary[j];
			}
		}

		// to transfer the original array to fake one
		transfer(original, fake);

		// writing the original one
		dash(size(str));
		for (int i = 0; i < original.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < original[i].length; j++) {
				System.out.print(original[i][j] + " | ");
			}
			System.out.println();
			dash(size(str));
		}

		// changing fake array depends on rules
		while (checkPoint2 <= stepNum) {
			change(original, fake);
			System.out.println();
			System.out.println(
					"It is converted to the following table after " + checkPoint2 + placement(checkPoint2) + " step:");
			dash(size(str));
			for (int i = 0; i < fake.length; i++) {
				System.out.print("| ");
				for (int j = 0; j < fake[i].length; j++) {
					System.out.print(fake[i][j] + " | ");
				}
				System.out.println();
				dash(size(str));
			}
			transfer(fake, original);
			checkPoint2++;
		}

		System.out.println();
		
		// convert the binary to decimal
		decimal = bToDecimal(decimal, fake);

		// write the decimal number after steps
		System.out.print("The decimal value for the second table after " + stepNum + " steps:");
		for (int i = 0; i < decimal.length; i++) {
			System.out.print(decimal[i]);
			if (i != decimal.length - 1)
				System.out.print("-");
		}
		// write dot
		System.out.print(".");
	}

	// convert method
	public static int[] convert(int num, int size) {
		int[] arr = new int[size];
		for (int i = (size - 1); i >= 0; i--) {
			arr[i] = num % 2;
			num = num / 2;
		}
		return arr;
	}

	// method num
	public static int num(String str, int point, int size) {
		int[] arr = new int[size];
		int count = 0;
		String num = "";

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '-') {
				count++;
				arr[count - 1] = Integer.parseInt(num);
				num = "";
			} else if (i == str.length() - 1) {
				count++;
				arr[count - 1] = Integer.parseInt(num + str.charAt(i));
			} else
				num += str.charAt(i);
		}
		return arr[point];
	}

	// method size
	public static int size(String str) {
		int size = 1;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '-')
				size++;
		}
		return size;
	}

	// method check
	public static boolean check(String str) {
		for (int i = 0; i < size(str); i++) {
			if (num(str, i, size(str)) > Math.pow(2, size(str)) - 1)
				return false;
		}
		return true;

	}

	// method transfer
	public static void transfer(int[][] arr, int[][] arr1) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr1[i][j] = arr[i][j];
			}
		}
	}

	// method if i is zero
	public static int iIsZero(int[][] arr, int a, int b) {
		int sum = 0;
		if (a == 0) {
			for (int i = a; i < a + 2; i++) {
				if (b == 0) {
					for (int j = b; j < b + 2; j++) {
						if (arr[i][j] == 1)
							sum++;
					}
				} else if (b == arr.length - 1) {
					for (int j = b; j > b - 2; j--) {
						if (arr[i][j] == 1)
							sum++;
					}
				} else {
					for (int j = b - 1; j < b + 2; j++) {
						if (arr[i][j] == 1)
							sum++;
					}
				}
			}
		}
		return sum;
	}

	// method check the i is length - 1
	public static int iIsL(int[][] arr, int a, int b) {
		int sum = 0;
		if (a == arr.length - 1) {
			for (int i = a; i > a - 2; i--) {
				if (b == 0) {
					for (int j = b; j < b + 2; j++) {
						if (arr[i][j] == 1)
							sum++;
					}
				} else if (b == arr.length - 1) {
					for (int j = b; j > b - 2; j--) {
						if (arr[i][j] == 1)
							sum++;
					}
				} else {
					for (int j = b - 1; j < b + 2; j++) {
						if (arr[i][j] == 1)
							sum++;
					}
				}
			}
		}
		return sum;
	}

	// method check the i is else
	public static int iIsElse(int[][] arr, int a, int b) {
		int sum = 0;
		if (a < arr.length - 1 && a > 0) {
			for (int i = a - 1; i < a + 2; i++) {
				if (b == 0) {
					for (int j = b; j < b + 2; j++) {
						if (arr[i][j] == 1)
							sum++;
					}
				} else if (b == arr.length - 1) {
					for (int j = b; j > b - 2; j--) {
						if (arr[i][j] == 1)
							sum++;
					}
				} else {
					for (int j = b - 1; j < b + 2; j++) {
						if (arr[i][j] == 1)
							sum++;
					}
				}
			}
		}
		return sum;
	}

	// method to check the cell and change the cell depend on rules
	public static void change(int[][] arr, int[][] arr1) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 1) {
					if (i == 0 && iIsZero(arr, i, j) - 1 < 2 || iIsZero(arr, i, j) - 1 > 3) {
						arr1[i][j] = 0;
					} else if (i == arr.length - 1 && iIsL(arr, i, j) - 1 < 2 || iIsL(arr, i, j) - 1 > 3) {
						arr1[i][j] = 0;
					} else if ((i < arr.length - 1 && i > 0) && iIsElse(arr, i, j) - 1 < 2
							|| iIsElse(arr, i, j) - 1 > 3) {
						arr1[i][j] = 0;
					}
				} else if (arr[i][j] == 0) {
					if (i == 0 && iIsZero(arr, i, j) == 3) {
						arr1[i][j] = 1;
					} else if (i == arr.length - 1 && iIsL(arr, i, j) == 3) {
						arr1[i][j] = 1;
					} else if ((i < arr.length - 1 && i > 0) && iIsElse(arr, i, j) == 3) {
						arr1[i][j] = 1;
					}
				}

			}
		}
	}

	// method to change binary to decimal
	public static int[] bToDecimal(int[] arr, int[][] arr1) {
		for (int i = 0; i < arr.length; i++) {
			int k = arr.length - 1;
			for (int j = 0; j < arr.length; j++) {
				arr[i] += arr1[i][j] * Math.pow(2, k);
				k--;
			}
		}
		return arr;
	}

	// method to write st-nd-rd-th
	public static String placement(int num) {
		if (num < 14 && num > 10)
			return "th";
		else if (num % 10 == 1)
			return "st";
		else if (num % 10 == 2)
			return "nd";
		else if (num % 10 == 3)
			return "rd";
		else
			return "th";
	}

	// method to write dash
	public static void dash(int size) {
		for (int i = 0; i < size * 4 + 1; i++) {
			System.out.print("-");
		}
		System.out.println();

	}
	//method to print invalid value
	public static int invalid(String str) {
		int invalid = 0;
		for (int i = 0; i < size(str); i++) {
			if (num(str, i, size(str)) > Math.pow(2, size(str)) - 1)
				invalid = num(str, i, size(str));
		}
		return invalid;
	}
	
}
