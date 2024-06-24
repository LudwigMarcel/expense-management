package entities.enums;

public enum TransactionNature {

	FIXED(1), VARIABLE(2);

	private int code;

	private TransactionNature(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static TransactionNature valueOf(int code) {
		for (TransactionNature value : TransactionNature.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid transaction code");
	}
}

