package application;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.LegalPerson;
import entities.PhysicalPerson;
import entities.Taxpayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Taxpayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		Integer number = sc.nextInt();
		
		for (int i = 0; i < number; i++) {
			System.out.println("Tax payer #" + (i + 1) + " data:");
			
			System.out.print("Physical ou Legal person (p/l)?");
			char typeTaxpayer = sc.next().charAt(0);
			
			System.out.print("Name: ");
			String name = sc.next();
			
			System.out.println("Annual Income: ");
			Double annualIncome = sc.nextDouble();
			
			if (typeTaxpayer == 'p') {
				System.out.println("Health expenditures: ");
				Double healthExpenses = sc.nextDouble();
				
				PhysicalPerson physicalPerson = new PhysicalPerson(name, annualIncome, healthExpenses);
				list.add(physicalPerson);
			} else {
				System.out.println("Number of employees: ");
				Integer numberOfEmployees = sc.nextInt();
				
				LegalPerson legalPerson = new LegalPerson(name, annualIncome, numberOfEmployees);
				list.add(legalPerson);
			}
			
		}
		
		System.out.println();
		
		System.out.println("TAXES PAID:");
		for (Taxpayer tax : list) {
			System.out.println(tax.getName() + ": $ " + String.format("%.2f", tax.tax()));
		}
	}

}
