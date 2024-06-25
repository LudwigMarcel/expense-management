package util;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
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

    public void loadData(List<Expense> expenses, List<Income> incomes) {
        try (FileReader reader = new FileReader(FILE_PATH)) { // Tenta abrir um FileReader para o arquivo JSON
            Type dataType = new TypeToken<DataWrapper>() {}.getType(); // Define o tipo do objeto que será lido do JSON
            DataWrapper dataWrapper = gson.fromJson(reader, dataType); // Lê e converte o JSON para um objeto DataWrapper
            if (dataWrapper != null) { // Se a leitura foi bem-sucedida, adiciona os dados lidos às listas fornecidas
                expenses.addAll(dataWrapper.getExpenses());
                incomes.addAll(dataWrapper.getIncomes());
            }
        } catch (IOException e) {
            e.printStackTrace(); // Em caso de erro, imprime o stack trace
        }
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
