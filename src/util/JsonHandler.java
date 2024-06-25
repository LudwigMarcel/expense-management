package util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import entities.Expense;
import entities.Income;

public class JsonHandler {
    private static final String FILE_PATH = "C://Users/londo/eclipse-workspace/expense-management/data.json"; // Caminho do arquivo JSON
    private Gson gson;

    public JsonHandler() {
        this.gson = new Gson(); // Inicializa a instância Gson
    }

    public void saveData(List<Expense> expenses, List<Income> incomes) {
        DataWrapper dataWrapper = new DataWrapper(expenses, incomes); // Cria um objeto DataWrapper com as listas de despesas e entradas
        try (FileWriter writer = new FileWriter(FILE_PATH)) { // Tenta abrir um FileWriter para o arquivo JSON
            gson.toJson(dataWrapper, writer); // Converte o objeto dataWrapper em JSON e o escreve no arquivo
        } catch (IOException e) {
            e.printStackTrace(); // Em caso de erro, imprime o stack trace
        }
    }

    public List<Expense> loadExpenses() {
        List<Expense> expenses = new ArrayList<>();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type dataType = new TypeToken<DataWrapper>() {}.getType();
            DataWrapper dataWrapper = gson.fromJson(reader, dataType);
            if (dataWrapper != null) {
                expenses.addAll(dataWrapper.getExpenses());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    public List<Income> loadIncomes() {
        List<Income> incomes = new ArrayList<>();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type dataType = new TypeToken<DataWrapper>() {}.getType();
            DataWrapper dataWrapper = gson.fromJson(reader, dataType);
            if (dataWrapper != null) {
                incomes.addAll(dataWrapper.getIncomes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return incomes;
    }

    // Classe interna para encapsular os dados de despesas e entradas
    private class DataWrapper {
        private List<Expense> expenses;
        private List<Income> incomes;

        public DataWrapper(List<Expense> expenses, List<Income> incomes) {
            this.expenses = expenses;
            this.incomes = incomes;
        }

        public List<Expense> getExpenses() {
            return expenses;
        }

        public List<Income> getIncomes() {
            return incomes;
        }
    }
}
