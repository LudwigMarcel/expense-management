package entities;

import java.util.Date;
import java.util.Objects;

public class Income {

	private static Integer lastID = 0;
	private Integer id;
	private Integer category;
	private Integer transactionNature;
	private Integer transactionType;
	private Double value;
	private Integer installment = 1;
	private Date dueDate;
	private String description;

	public Income() {
	}

	// Credit
	public Income(Integer category, Integer transactionNature, Integer transactionType, Double value,
			Integer installment, Date dueDate, String description) {
		this.id = ++lastID;
		this.category = category;
		this.transactionNature = transactionNature;
		this.transactionType = transactionType;
		this.value = value;
		this.installment = installment;
		this.dueDate = dueDate;
		this.description = description;
	}

	// Debit
	public Income(Integer category, Integer transactionNature, Integer transactionType, Double value, Date dueDate,
			String description) {
		this.id = ++lastID;
		this.category = category;
		this.transactionNature = transactionNature;
		this.transactionType = transactionType;
		this.value = value;
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

	@Override
	public String toString() {
		return "Income [id=" + id + ", category=" + category + ", transactionNature=" + transactionNature
				+ ", transactionType=" + transactionType + ", value=" + value + ", installment=" + installment
				+ ", dueDate=" + dueDate + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, description, dueDate, id, installment, transactionNature, transactionType, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Income other = (Income) obj;
		return Objects.equals(category, other.category) && Objects.equals(description, other.description)
				&& Objects.equals(dueDate, other.dueDate) && Objects.equals(id, other.id)
				&& Objects.equals(installment, other.installment)
				&& Objects.equals(transactionNature, other.transactionNature)
				&& Objects.equals(transactionType, other.transactionType) && Objects.equals(value, other.value);
	}

}
