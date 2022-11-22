package teck.jidoka.question2Exception;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws EvenNumberException, OddNumberException{
		Check check = new Check();
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter the number: ");
			int n = sc.nextInt();
			
			check.checkEvenOdd(n);
		}
	}
}

// this main method will throw message as an exception if the number you have typed is even or odd
