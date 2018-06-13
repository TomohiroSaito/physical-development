package physicaldevelopment.model.primitive;

public enum Sex {
	MAN("男性"),
	WOMAN("女性");

	private final String typeName;

	private Sex(final String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return this.typeName;
	}
}
