package physicaldevelopment.model.primitive;

public enum Sex {
	MAN("男性"),
	WOMAN("女性"),
	OTHER("不明");

	private final String typeName;

	private Sex(final String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public static Sex getTypeByValue(String stringSex) {
		for(Sex sex : values()) {
			if(sex.name().equals(stringSex)) {
				return sex;
			}
		}
		return null;
	}
}
