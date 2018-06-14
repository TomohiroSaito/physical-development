package physicaldevelopment.model.nutrition;

public enum Nutrition {
	ENERGY("エネルギー"),
	PROTEIN("たんぱく質"),
	LIPID("脂質"),
	CARBOHYDRATE("炭水化物");

	private final String typeName;

	private Nutrition(final String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return this.typeName;
	}
}
