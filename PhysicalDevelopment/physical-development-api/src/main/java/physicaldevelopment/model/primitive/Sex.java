package physicaldevelopment.model.primitive;

import javax.validation.constraints.NotNull;

public enum Sex {
	MAN("男性"),
	WOMAN("女性");

	@NotNull(message="必須です。")
	private final String typeName;

	private Sex(final String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return this.typeName;
	}
}
