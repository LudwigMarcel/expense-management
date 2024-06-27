/*
 * TO DO LIST:
 * 	metodo retorna lista de expense/income do mes/ano, por categoria/type
 * 	grafico demonstrativo por mes/ano
 * 	implementar CRUD
 * 	interface JavaFX
 */

package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import util.JsonHandler;

public class Management {

	private List<Expense> expenses;
	private List<Income> incomes;
	private JsonHandler jsonHandler;

	public Management() {
		this.expenses = new ArrayList<>();
		this.incomes = new ArrayList<>();
		this.jsonHandler = new JsonHandler();
		loadFromJson();
	}

	public void addExpense(Expense expense) {
		if (expense.getInstallment() > 1) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(expense.getDueDate());
			for (int i = 0; i < (expense.getInstallment()); i++) {
				expenses.add(new Expense(expense.getCategory(), expense.getTransactionNature(),
						expense.getTransactionType(), expense.getValue(), expense.getInstallment(), calendar.getTime(),
						expense.getDescription()));
				calendar.add(Calendar.MONTH, 1);
			}
		} else {
			expenses.add(expense);
		}
		saveToJson();
	}

	public void addIncome(Income income) {
		if (income.getInstallment() > 1) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(income.getDueDate());
			for (int i = 0; i < (income.getInstallment()); i++) {
				incomes.add(new Income(income.getCategory(), income.getTransactionNature(), income.getTransactionType(),
						income.getValue(), income.getInstallment(), calendar.getTime(), income.getDescription()));
				calendar.add(Calendar.MONTH, 1);
			}
		} else {
			incomes.add(income);
		}
		saveToJson();
	}

	public Double getSubTotalExpense() {
		return getSubTotalExpense(Calendar.getInstance());
	}

	public Double getSubTotalExpense(Calendar calendar) {
		Double subTotal = 0.0;
		for (Expense expense : expenses) {
			Calendar expenseCalendar = Calendar.getInstance();
			expenseCalendar.setTime(expense.getDueDate());
			if (expenseCalendar.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)
					&& expenseCalendar.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)) {
				subTotal += expense.getValue();
			}
		}
		return subTotal;
	}

	public Double getSubTotalExpenseYear() {
		return getSubTotalExpenseYear(Calendar.getInstance());
	}

	public Double getSubTotalExpenseYear(Calendar calendar) {
		Double subTotal = 0.0;
		for (Expense expense : expenses) {
			Calendar expenseCalendar = Calendar.getInstance();
			expenseCalendar.setTime(expense.getDueDate());
			if (expenseCalendar.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
				subTotal += expense.getValue();
			}
		}
		return subTotal;
	}

	public Double getSubTotalIncome() {
		return getSubTotalIncome(Calendar.getInstance());
	}

	public Double getSubTotalIncome(Calendar calendar) {
		Double subTotal = 0.0;
		for (Income income : incomes) {
			Calendar incomeCalendar = Calendar.getInstance();
			incomeCalendar.setTime(income.getDueDate());
			if (incomeCalendar.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)
					&& incomeCalendar.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)) {
				subTotal += income.getValue();
			}
		}
		return subTotal;
	}

	public Double getSubTotalIncomeYear() {
		return getSubTotalIncomeYear(Calendar.getInstance());
	}

	public Double getSubTotalIncomeYear(Calendar calendar) {
		Double subTotal = 0.0;
		for (Income income : incomes) {
			Calendar incomeCalendar = Calendar.getInstance();
			incomeCalendar.setTime(income.getDueDate());
			if (incomeCalendar.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
				subTotal += income.getValue();
			}
		}
		return subTotal;
	}

	public Double getTotal() {
		Calendar calendar = Calendar.getInstance();
		double subTotalExpense = getSubTotalExpense(calendar);
		double subTotalIncome = getSubTotalIncome(calendar);
		return subTotalIncome - subTotalExpense;
	}

	public Double getTotal(Calendar calendar) {
		Double subTotalExpense = getSubTotalExpense(calendar);
		Double subTotalIncome = getSubTotalIncome(calendar);
		return subTotalIncome - subTotalExpense;
	}

	public Double getTotalYear() {
		Calendar calendar = Calendar.getInstance();
		double subTotalExpense = getSubTotalExpenseYear(calendar);
		double subTotalIncome = getSubTotalIncomeYear(calendar);
		return subTotalIncome - subTotalExpense;
	}

	public Double getTotalYear(Calendar calendar) {
		Double subTotalExpense = getSubTotalExpenseYear(calendar);
		Double subTotalIncome = getSubTotalIncomeYear(calendar);
		return subTotalIncome - subTotalExpense;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public List<Income> getIncomes() {
		return incomes;
	}

	public List<Expense> getExpenseByMonth(Calendar calendar) {
		List<Expense> aux = new ArrayList<>();
		for (Expense expense : expenses) {
			Calendar expenseCalendar = Calendar.getInstance();
			expenseCalendar.setTime(expense.getDueDate());
			if (expenseCalendar.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)
					&& expenseCalendar.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)) {
				aux.add(expense);
			}
		}
		return aux;
	}

	public List<Expense> getExpenseByCategory(Integer category, Calendar calendar) {
		List<Expense> monthlyExpenses = getExpenseByMonth(calendar);	
		List<Expense> aux = new ArrayList<>();
		for (Expense expense : monthlyExpenses) {			
			if (expense.getCategory().equals(category)) {
				aux.add(expense);
			}
		}
		return aux;
	}

	public List<Income> getIncomeByMonth(Calendar calendar) {
		List<Income> aux = new ArrayList<>();
		for (Income income : incomes) {
			Calendar incomeCalendar = Calendar.getInstance();
			incomeCalendar.setTime(income.getDueDate());
			if (incomeCalendar.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)
					&& incomeCalendar.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)) {
				aux.add(income);
			}
		}
		return aux;
	}

	public List<Income> getIncomByCategory(Integer category, Calendar calendar) {
		List<Income> monthlyIncomes = getIncomeByMonth(calendar);
		List<Income> aux = new ArrayList<>();
		for (Income income : monthlyIncomes) {
			if (income.getCategory().equals(category)) {
				aux.add(income);
			}
		}
		return aux;
	}

	private void saveToJson() {
		jsonHandler.saveData(expenses, incomes);
	}

	private void loadFromJson() {
		List<Expense> loadedExpenses = jsonHandler.loadExpenses();
		List<Income> loadedIncomes = jsonHandler.loadIncomes();

		if (loadedExpenses != null) {
			expenses.addAll(loadedExpenses);
		}

		if (loadedIncomes != null) {
			incomes.addAll(loadedIncomes);
		}
	}

	public void saveData() {
		saveToJson();
	}

	public void loadData() {
		loadFromJson();
	}
}
