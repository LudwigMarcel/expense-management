package config;

import java.util.Calendar;
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

		// Criar despesas e receitas com parcelas
		Calendar date1 = Calendar.getInstance();
		date1.set(2024, Calendar.JUNE, 12);
		Date dueDate1 = date1.getTime();

		Calendar calendar = Calendar.getInstance();
		calendar.set(2024, Calendar.MAY, 12); // 12 de maio de 2024
		Date dueDate = calendar.getTime();

		Expense expense = new Expense(1, 1, 1, 300.0, dueDate1, "Rancho");
		Expense expense1 = new Expense(7, 1, 1, 150.0, 3, dueDate1, "Calça"); // 3 parcelas
		Income income = new Income(4, 1, 1, 1500.0, 12, dueDate1, "Salario"); // Receita anual
		Income income1 = new Income(10, 1, 1, 500.0, dueDate1, "Frellance"); // Receita anual

		// Adicionar despesas e receitas ao management
		management.addExpense(expense);
		management.addExpense(expense1);
		management.addIncome(income);
		management.addIncome(income1);
	}

	@Test
	public void upen() {
		// Simular recarregamento do aplicativo
		management = new Management();

		Calendar date1 = Calendar.getInstance();
		date1.set(2024, Calendar.JUNE, 12);
		Date upDate = date1.getTime();
		
		List<Expense> expenses = management.getExpenses();
		List<Income> incomes = management.getIncomes();

		//Update expense
		management.updateExpense(1, 1, 1, 1, 350.0, upDate, "Rancho");
		
		//Delete income
		management.deleteIncome(2);
		
		// Verificar as despesas e receitas carregadas
		System.out.println(date1.getTime());

		double subTotalExpenseYear = management.getSubTotalExpenseYear(date1);
		double subTotalIncomeYear = management.getSubTotalIncomeYear(date1);
		double totalYear = management.getTotalYear(date1);

		double subTotalExpense = management.getSubTotalExpense(date1);
		double subTotalIncome = management.getSubTotalIncome(date1);
		double total = management.getTotal(date1);

		// Imprimir resultados
		System.out.println("Expense by category: " + management.getExpenseByMonth(date1));
		System.out.println("Income by category: " + management.getIncomeByMonth(date1));
		System.out.println(" ");
		System.out.println("Subtotal of year expenses: " + subTotalExpenseYear);
		System.out.println("Subtotal of year income: " + subTotalIncomeYear);
		System.out.println("Total of year: " + totalYear);
		System.out.println("Subtotal of all expenses: " + subTotalExpense);
		System.out.println("Subtotal of all incomes: " + subTotalIncome);
		System.out.println("Total (Income - Expense): " + total);
	}
}
/*
 * @Test public void testAddExpense() { Expense expense = new Expense(1, 1, 1,
 * 1, 150.0, 1, new Date(), "Rancho"); Expense expense1 = new Expense(1, 1, 1,
 * 1, 30.0, 1, new Date(), "IFood"); Expense expense2 = new Expense(1, 1, 1, 1,
 * 15.0, 1, new Date(), "Gasolina"); Expense expense3 = new Expense(1, 1, 1, 1,
 * 50.0, 1, new Date(), "Brinco");
 * 
 * management.addExpense(expense); management.addExpense(expense1);
 * management.addExpense(expense2); management.addExpense(expense3);
 * 
 * 
 * List<Expense> expenses = management.getExpenses(); //
 * assertFalse(expenses.isEmpty()); // assertEquals(4, expenses.size()); //
 * assertEquals(expense, expenses.get(0)); }
 * 
 * @Test public void testAddIncome() { Income income = new Income(1, 1, 1, 1,
 * 5000.0, 1, new Date(), "Salario"); Income income1 = new Income(1, 1, 1, 1,
 * 200.0, 1, new Date(), "Bonus");
 * 
 * management.addIncome(income); management.addIncome(income1);
 * 
 * 
 * 
 * List<Income> incomes = management.getIncomes(); //
 * assertFalse(incomes.isEmpty()); // assertEquals(2, incomes.size()); //
 * assertEquals(income, incomes.get(0)); }
 * 
 * 
 * @Test public void testSubTotal() {
 * 
 * JsonHandler jsonHandler = new JsonHandler();
 * 
 * // Carregar despesas e receitas do arquivo JSON List<Expense> expenses =
 * jsonHandler.loadExpenses(); List<Income> incomes = jsonHandler.loadIncomes();
 * 
 * // Adicionar despesas e receitas ao management if (management == null) {
 * management.getExpenses().addAll(expenses);
 * management.getIncomes().addAll(incomes); }
 * 
 * // Calcular subtotais e total double subTotalExpense =
 * management.getSubTotalExpense(); double subTotalIncome =
 * management.getSubTotalIncome(); double total = management.getTotal();
 * 
 * // Imprimir resultados System.out.println("Subtotal of all expenses: " +
 * subTotalExpense); System.out.println("Subtotal of all incomes: " +
 * subTotalIncome); System.out.println("Total (Income - Expense): " + total);
 * 
 * }
 * 
 * @Test public void testSaveAndLoadData() { Expense expense = new Expense(1, 1,
 * 1, 1, 150.0, 1, new Date(), "Rancho"); Income income = new Income(1, 1, 1, 1,
 * 5000.0, 1, new Date(), "Salario");
 * 
 * management.addExpense(expense); management.addIncome(income);
 * 
 * // Simulate reloading the application management = new Management();
 * 
 * List<Expense> expenses = management.getExpenses(); List<Income> incomes =
 * management.getIncomes();
 * 
 * System.out.println("Expected Expense: " + expense);
 * System.out.println("Loaded Expense: " + expenses.get(0));
 * System.out.println("Expected Income: " + income);
 * System.out.println("Loaded Income: " + incomes.get(0));
 * 
 * printVariableType(expenses.get(0).getId());
 * 
 * assertEquals(1, expenses.size()); assertEquals(expense, expenses.get(0));
 * 
 * System.out.println("Test 1 done");
 * 
 * assertEquals(1, incomes.size()); assertEquals(income, incomes.get(0));
 * 
 * System.out.println("Test 2 done");
 * 
 * }
 */