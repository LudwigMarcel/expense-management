package config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import entities.Expense;
import entities.Income;
import entities.Management;

public class TestConfig {

	private Management management;

	@Before
	public void setUp() {
		management = new Management();
	}

	/*@Test
	public void testAddExpense() {
		Expense expense = new Expense(1, 1, 1, 1, 150.0, 1, new Date(2024 / 06 / 24), "Rancho");
		management.addExpense(expense);

		List<Expense> expenses = management.getExpenses();
		assertFalse(expenses.isEmpty());
		assertEquals(1, expenses.size());
		assertEquals(expense, expenses.get(0));
	}

	@Test
	public void testAddIncome() {
		Income income = new Income(1, 1, 1, 1, 5000.0, 1, new Date(2024 / 06 / 24), "salario");

		management.addIncome(income);

		List<Income> incomes = management.getIncomes();
		assertFalse(incomes.isEmpty());
		assertEquals(1, incomes.size());
		assertEquals(income, incomes.get(0));
	}*/

	@Test
	public void testSaveAndLoadData() {
		Expense expense = new Expense(1, 1, 1, 1, 150.0, 1, new Date(), "Rancho");
		Income income = new Income(1, 1, 1, 1, 5000.0, 1, new Date(), "salario");

		management.addExpense(expense);
		management.addIncome(income);
		
		
		// Simulate reloading the application
		management = new Management();

		List<Expense> expenses = management.getExpenses();
		List<Income> incomes = management.getIncomes();	
		
		System.out.println("Expected Expense: " + expense);
	    System.out.println("Loaded Expense: " + expenses.get(0));
	    System.out.println("Expected Income: " + income);
	    System.out.println("Loaded Income: " + incomes.get(0));

		assertEquals(1, expenses.size());
		assertEquals(expense, expenses.get(0));

		System.out.println("Test 1 done");
		
		assertEquals(1, incomes.size());
		assertEquals(income, incomes.get(0));
		
		System.out.println("Test 2 done");
		
	}
}