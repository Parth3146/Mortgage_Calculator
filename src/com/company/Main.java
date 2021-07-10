package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		final byte MONTHS_IN_YEAR = 12;
		final byte PERCENTAGE = 100;

		int principal;
		float annualInterest;
		byte duration;

		Scanner scanner = new Scanner(System.in);

		//taking inputs
		while (true) {
			System.out.print("Principal Amount ($1K - $1M): ");
			principal = scanner.nextInt();
			if (principal >= 1_000 && principal <= 1_000_000)
				break;
			System.out.println("Enter amount between 1,000 and 1,000,000.");
		}

		while (true) {
			System.out.print("Annual Interest Rate: ");
			annualInterest = scanner.nextFloat();
			if (annualInterest > 0 && annualInterest <= 30)
				break;
			System.out.println("Enter a value between 0 and 30.");
		}

		while (true) {
			System.out.print("Duration (Years): ");
			duration = scanner.nextByte();
			if (duration >= 1 && duration <= 30)
				break;
			System.out.println("Enter a value between 1 and 30.");
		}

		//mortgage = principal * { [annualInterest (1 +annualInterest)^duration] / [ (1 +annualInterest)^duration -1] }  **values are per month**
		//calculating common expression: (1+annualInterest)^duration
		double temp = Math.pow((1 + (annualInterest / PERCENTAGE / MONTHS_IN_YEAR)), (duration * MONTHS_IN_YEAR));  //converted interest rate and duration values for months

		//calculating mortgage
		double mortgage = principal * (((annualInterest / PERCENTAGE / MONTHS_IN_YEAR) * temp) / (temp - 1));

		//displaying final result in currency format
		System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));

    }
}