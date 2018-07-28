package physicaldevelopment.model.meal;

public enum InputType {
	AUTO("自動入力"), MANUAL("手動入力");

	private final String typeName;

	private InputType(final String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return this.typeName;
	}

}
