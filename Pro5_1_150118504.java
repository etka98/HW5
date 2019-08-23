/*
 * MEHMET ETKA UZUN - 150118504
 * This program rolls 10 dices and add dices result.After this process collect them in one array.
 * 
 */

import java.util.Scanner;
public class Pro5_1_150118504 {

	public static void main(String[] args) {
		//create scan
		Scanner scan = new Scanner(System.in);
		
		//variables
		int[] count = new int[51];
		int dice, sum, input;
		
		//codes
		System.out.println("Welcome to dice simulator program.");
		System.out.print("Enter a value : ");
		input = scan.nextInt();
		
		//for dice
		for(int i = 0; i < input; i++) {
			sum = 0;
			for(int j = 0; j < 10; j++) {
				dice = (int)(Math.random() * 6 + 1);
				sum += dice;
			}
			count[sum - 10]++;
		}
		 
		//print
		for(int i = 0; i < count.length; i++) {
			System.out.print((10 + i) + ": ");
			for(int j = 0; j < count[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
