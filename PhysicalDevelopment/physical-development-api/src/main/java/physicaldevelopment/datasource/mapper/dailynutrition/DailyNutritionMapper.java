package physicaldevelopment.datasource.mapper.dailynutrition;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.MyMapper;
import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.dailynutrition.DailyNutrientAmountId;
import physicaldevelopment.model.evaluation.NotSubjectToEvaluation;
import physicaldevelopment.model.nutrition.NutrientAmount;

@MyMapper
@Repository
public interface DailyNutritionMapper {

	Integer selectNextDailyNutrientAmountId();

	void insertDailyNutrition(
			@Param("dailyNutrientAmountId") DailyNutrientAmountId dailyNutrientAmountId,
			@Param("accountId") AccountId accountId, @Param("date") Date date);

	void insertEvaluation(
			@Param("dailyNutrientAmountId") DailyNutrientAmountId dailyNutrientAmountId);

	DailyNutrientAmountId selectDailyNutrientAmountId(@Param("date") Date date,
			@Param("accountId") AccountId accountId);

	NutrientAmount selectEnergyTotalNutrientAmountPerDay(
			@Param("dailyNutrientAmountId") DailyNutrientAmountId dailyNutrientAmountId);

	NutrientAmount selectProteinTotalNutrientAmountPerDay(
			@Param("dailyNutrientAmountId") DailyNutrientAmountId dailyNutrientAmountId);

	NutrientAmount selectLipidTotalNutrientAmountPerDay(
			@Param("dailyNutrientAmountId") DailyNutrientAmountId dailyNutrientAmountId);

	NutrientAmount selectCarbohydrateTotalNutrientAmountPerDay(
			@Param("dailyNutrientAmountId") DailyNutrientAmountId dailyNutrientAmountId);

	NotSubjectToEvaluation selectNotSubjectToEvaluation(
			@Param("dailyNutrientAmountId") DailyNutrientAmountId dailyNutrientAmountId);

}
