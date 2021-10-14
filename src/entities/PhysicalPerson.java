package entities;

public class PhysicalPerson extends Taxpayer {
	private Double healthExpenses;

	private final Double TAX_PERCENT_ANNUAL_INCOME_LESS_THAN_20000 = 15.0;
	private final Double TAX_PERCENT_ANNUAL_INCOME_GREATER_THAN_20000 = 25.0;
	private final Double DISCOUNT_HEALTH_EXPENSES = 50.0;

	public PhysicalPerson() {
	}

	public PhysicalPerson(String name, Double annualIncome, Double healthExpenses) {
		super(name, annualIncome);
		this.healthExpenses = healthExpenses;
	}

	/**
	 * People whose annual income was below 20000.00 pay 15% tax.
	 * People with an annual income equal to or greater than 20000.00 pay 25% tax.
	 * If the person had health care expenses, 50% of these expenses are deducted
	 * from the tax.
	 */
	@Override
	public Double tax() {
		// Applied the Single Responsibility Principle:
		Double rawValue = getRawTax();
		Double value = applyDeductions(rawValue);
		return value;
	}

	private Double getRawTax() {
		if (super.getAnnualIncome() < 20000.0) {
			return (super.getAnnualIncome() * TAX_PERCENT_ANNUAL_INCOME_LESS_THAN_20000) / 100;
		}

		return (super.getAnnualIncome() * TAX_PERCENT_ANNUAL_INCOME_GREATER_THAN_20000) / 100;
	}

	private Double applyDeductions(Double rawTax) {
		if (healthExpenses > 0) {
			return rawTax - (healthExpenses * DISCOUNT_HEALTH_EXPENSES) / 100;
		}
		return rawTax;
	}
}
