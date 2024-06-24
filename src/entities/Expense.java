package entities;

import java.util.Date;

public class Expense {

	private Integer id;
	private Integer category;
	private Integer transactionNature;
	private Integer transactionType;
	private Double value;
	private Integer installment;
	private Date dueDate;
	private String description;

	public Expense() {
	}

	public Expense(Integer id, Integer category, Integer transactionNature, Integer transactionType, Double value,
			Integer installment, Date dueDate, String description) {
		this.id = id;
		this.category = category;
		this.transactionNature = transactionNature;
		this.transactionType = transactionType;
		this.value = value;
		this.installment = installment;
		this.dueDate = dueDate;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Integer getTransactionNature() {
		return transactionNature;
	}

	public void setTransactionNature(Integer transactionNature) {
		this.transactionNature = transactionNature;
	}

	public Integer getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(Integer transactionType) {
		this.transactionType = transactionType;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Integer getInstallment() {
		return installment;
	}

	public void setInstallment(Integer installment) {
		this.installment = installment;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
