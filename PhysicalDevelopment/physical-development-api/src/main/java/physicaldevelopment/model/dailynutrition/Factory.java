package physicaldevelopment.model.dailynutrition;

import java.util.Date;

import physicaldevelopment.model.account.AccountId;

public abstract class Factory {
	public final Product create(Date date, AccountId accountId) {
		Product product = createProduct(date, accountId);
		registerProduct(product);
		return product;
	}

	protected abstract Product createProduct(Date date, AccountId accountId);

	protected abstract void registerProduct(Product product);
}
