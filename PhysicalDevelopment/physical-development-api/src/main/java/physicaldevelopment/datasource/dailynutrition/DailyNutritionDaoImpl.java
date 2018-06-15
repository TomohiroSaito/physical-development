package physicaldevelopment.datasource.dailynutrition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.dailynutrition.DailyNutritionMapper;
import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.dailynutrition.DailyNutrientAmountId;
import physicaldevelopment.model.primitive.YearMonthDay;

@Repository
public class DailyNutritionDaoImpl implements DailyNutritionDao {
	@Autowired
	DailyNutritionMapper dailyNutritionMapper;

	@Override
	public DailyNutrientAmountId selectNextDailyNutrientAmountId() {
		DailyNutrientAmountId dailyNutrientAmountId = new DailyNutrientAmountId(dailyNutritionMapper.selectNextDailyNutrientAmountId());
		return dailyNutrientAmountId;
	}

	@Override
	public void insertDailyNutrition(DailyNutrientAmountId nextDailyNutrientAmountId, AccountId accountId,
			YearMonthDay yearMothDay) {
		dailyNutritionMapper.insertDailyNutrition(nextDailyNutrientAmountId, accountId, yearMothDay);
	}

	@Override
	public void insertEvaluation(DailyNutrientAmountId dailyNutrientAmountId) {
		dailyNutritionMapper.insertEvaluation(dailyNutrientAmountId);
	}

}
