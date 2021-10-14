package entities;

public class LegalPerson extends Taxpayer {
	private Integer numberOfEmployees;

	private final Double TAX_PERCENT_NUMBER_EMPLOYEES_EQUAL_OR_LESS_THAN_10 = 16.0;
	private final Double TAX_PERCENT_NUMBER_EMPLOYEES_GREATER_THAN_10 = 14.0;

	public LegalPerson() {
	}

	public LegalPerson(String name, Double annualIncome, Integer numberOfEmployees) {
		super(name, annualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	/**
	 * Legal entities pay 16% tax. However, if the company has more than 10
	 * employees, it pays 14% tax. Example: a company whose income was 400000.00 and
	 * has 25 employees, the tax is: 400000 * 14% = 56000.00
	 */
	@Override
	public Double tax() {
		if (numberOfEmployees <= 10) {
			return (super.getAnnualIncome() * TAX_PERCENT_NUMBER_EMPLOYEES_EQUAL_OR_LESS_THAN_10) / 100;
		}
		return (super.getAnnualIncome() * TAX_PERCENT_NUMBER_EMPLOYEES_GREATER_THAN_10) / 100;
	}
}
