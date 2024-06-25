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

	public Double getSubTotalExpense() {
		Double subTotal = 0.0;
		for (int i = 0; i < expenses.size(); i++) {
			subTotal += expenses.get(i).getValue();
		}
		return subTotal;
	}

	public Double getSubTotalIncome() {
		Double subTotal = 0.0;
		for (int i = 0; i < incomes.size(); i++) {
			subTotal += incomes.get(i).getValue();
		}
		return subTotal;
	}

	public Double getTotal() {
		Double subTotalExpense = getSubTotalExpense();
		Double subTotalIncome = getSubTotalIncome();
		return subTotalIncome - subTotalExpense;
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
		List<Expense> loadedExpenses = jsonHandler.loadExpenses();
		List<Income> loadedIncomes = jsonHandler.loadIncomes();

		if (loadedExpenses != null) {
			expenses.addAll(loadedExpenses);
		}

		if (loadedIncomes != null) {
			incomes.addAll(loadedIncomes);
		}
	}
}
