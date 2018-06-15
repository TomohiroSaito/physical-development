package physicaldevelopment.datasource.mapper.dailynutrition;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import physicaldevelopment.datasource.mapper.MyMapper;
import physicaldevelopment.model.account.AccountId;
import physicaldevelopment.model.dailynutrition.DailyNutrientAmountId;
import physicaldevelopment.model.primitive.YearMonthDay;

@MyMapper
@Repository
public interface DailyNutritionMapper {

	Integer selectNextDailyNutrientAmountId();

	void insertDailyNutrition(@Param("dailyNutrientAmountId") DailyNutrientAmountId dailyNutrientAmountId, @Param("accountId") AccountId accountId,
			@Param("yearMothDay") YearMonthDay yearMothDay);

	void insertEvaluation(@Param("dailyNutrientAmountId") DailyNutrientAmountId dailyNutrientAmountId);

}
