package entities;

import java.util.ArrayList;
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
		expenses.add(expense);
		saveToJson();
	}

	public void addIncome(Income income) {
		incomes.add(income);
		saveToJson();
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public List<Income> getIncomes() {
		return incomes;
	}

	private void saveToJson() {
		jsonHandler.saveData(expenses, incomes);
	}

	private void loadFromJson() {
		jsonHandler.loadData(expenses, incomes);
	}
}
