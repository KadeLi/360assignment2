package cse360assign2;

import java.util.Scanner;

public class AddingMachine {

	private int total;
	private String record;

	/**
	 *To use, simple enter values in the format: [Operation][Integer], for example, to do + 5, enter "+5" without the "".
	 *If desired, add by [char] value. Code will transform char to its int val.
	 * Use the following commands:
	 *+ [int] for add operation
	 *- [int] for subtract operation
	 *P to print record
	 *C to clear record
	 *Q to quit
	 */
	
	public static void main(String[] args) {
		
		char input = 'x';
		int num;

		
		Scanner Scan = new Scanner(System.in);
		AddingMachine AM = new AddingMachine();
		
		System.out.println("Enter in the format [Operation][Integer]");
		
		while (Scan.hasNextLine() && !(input =='Q')) {

			String cut = Scan.nextLine();
			
			try {
				input = cut.charAt(0);
			}
			catch(Exception e) {
				input = 'x';
			}
			
			switch(input){
			
			case '+':
				
				try {
					
					num = Character.getNumericValue(cut.charAt(1));
					
				}
				catch(Exception e) {
					
					System.out.println("Input Incorrectly Formated");
					
					break;
					
				}
				
				AM.add(num);
				break;
				
			case '-':
				
				try {
					
					num = Character.getNumericValue(cut.charAt(1));
					
				}
				catch(Exception e) {
					
					System.out.println("Input Incorrectly Formated");
					
					break;
					
				}
				
				
				AM.subtract(num);	
				break;
			
			case 'P':
				System.out.println(AM.toString());
				break;
				
			case 'C':
				AM.clear();
				System.out.println("Record Cleared");
				break;
				
			case 'Q':
				break;
				
			default:
				System.out.println("Enter in the format [Operation][Integer]");
				
			}
			
		}
		
		
	}
	
	
	public AddingMachine () {
		
		record = "0";
		total = 0;  // not needed - included for clarity
		
	}
	
	/**
	 *Method returning final value after calculations. 
	 */
	
	public int getTotal () {
		
		return total;
	
	}
	
	/**
	 *Method that adds to the passed value
	 */
	
	public void add (int value) {
		
		System.out.print(total + " + " + value + " = " + (total + value) + " ");
		record = record.concat(" + " + Integer.toString(value));
		
		total = total+value;
		
		
	}
	
	/**
	 *Method that subtracts from the passed value
	 */
	
	public void subtract (int value) {
		
		System.out.print(total + " - " + value + " = " + (total - value) + " ");
		
		record = record.concat(" + " + Integer.toString(value));
		
		total = total-value;
		
	}
		
	/**
	 *Method that prints
	 */
	
	public String toString () {
		
		return record;
	}
	
	/**
	 *Method that deletes data stored for calculations.
	 */

	public void clear() {
		
		record = "";
	
	}
}
