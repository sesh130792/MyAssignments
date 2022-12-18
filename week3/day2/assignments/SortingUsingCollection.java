package week3.day2.assignments;

import java.util.Arrays;

public class SortingUsingCollection {

	public static void main(String[] args) {
		
		String[] companies = {"HCL", "Wipro", "Aspire Systems", "CTS"};
		int companiesLength = companies.length;
		Arrays.sort(companies);
		for (int i = companiesLength-1; i >= 0; i--) {
			String company = companies[i];
			System.out.print(company + " ");
		}
	}
}
