package physicaldevelopment.datasource.dailynutrition;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.dailynutrition.DailyNutritionMapper;
import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.dailynutrition.DailyNutrientAmountId;
import physicaldevelopment.model.evaluation.NotSubjectToEvaluation;
import physicaldevelopment.model.nutrition.NutrientAmount;

@Repository
public class DailyNutritionDaoImpl implements DailyNutritionDao {
	@Autowired
	DailyNutritionMapper dailyNutritionMapper;

	@Override
	public DailyNutrientAmountId selectNextDailyNutrientAmountId() {
		DailyNutrientAmountId dailyNutrientAmountId = new DailyNutrientAmountId(
				dailyNutritionMapper.selectNextDailyNutrientAmountId());
		return dailyNutrientAmountId;
	}

	@Override
	public void insertDailyNutrition(
			DailyNutrientAmountId nextDailyNutrientAmountId,
			AccountId accountId, Date date) {
		dailyNutritionMapper.insertDailyNutrition(nextDailyNutrientAmountId,
				accountId, date);
	}

	@Override
	public void insertEvaluation(DailyNutrientAmountId dailyNutrientAmountId) {
		dailyNutritionMapper.insertEvaluation(dailyNutrientAmountId);
	}

	@Override
	public DailyNutrientAmountId selectDailyNutrientAmountId(Date date,
			AccountId accountId) {
		return dailyNutritionMapper
				.selectDailyNutrientAmountId(date, accountId);
	}

	@Override
	public NutrientAmount selectEnergyTotalNutrientAmountPerDay(
			DailyNutrientAmountId dailyNutrientAmountId) {
		return dailyNutritionMapper
				.selectEnergyTotalNutrientAmountPerDay(dailyNutrientAmountId);
	}

	@Override
	public NutrientAmount selectProteinTotalNutrientAmountPerDay(
			DailyNutrientAmountId dailyNutrientAmountId) {
		return dailyNutritionMapper
				.selectProteinTotalNutrientAmountPerDay(dailyNutrientAmountId);
	}

	@Override
	public NutrientAmount selectLipidTotalNutrientAmountPerDay(
			DailyNutrientAmountId dailyNutrientAmountId) {
		return dailyNutritionMapper
				.selectLipidTotalNutrientAmountPerDay(dailyNutrientAmountId);
	}

	@Override
	public NutrientAmount selectCarbohydrateTotalNutrientAmountPerDay(
			DailyNutrientAmountId dailyNutrientAmountId) {
		return dailyNutritionMapper
				.selectCarbohydrateTotalNutrientAmountPerDay(dailyNutrientAmountId);
	}

	@Override
	public NotSubjectToEvaluation selectNotSubjectToEvaluation(
			DailyNutrientAmountId dailyNutrientAmountId) {
		return dailyNutritionMapper
				.selectNotSubjectToEvaluation(dailyNutrientAmountId);
	}

}
