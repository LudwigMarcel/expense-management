package config;

import java.util.Date;

import entities.Expense;
import entities.Income;
import entities.Management;

public class Test {

	private Management management;

	public void setUp() {
		management = new Management();
		
		Expense expense = new Expense(1, 1, 1, 1, 150.0, 1, new Date(2024 / 06 / 24), "Rancho");
		Income income = new Income(1, 1, 1, 1, 5000.0, 1, new Date(2024 / 06 / 24), "salario");
		management.addIncome(income);
		management.addExpense(expense);
		
	}
}
