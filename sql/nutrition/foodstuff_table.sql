--食材
CREATE TABLE nutrition.foodstuff (
  foodstuff_id INT,
  meal_id INT,
  foodstuff_master_id INT,
  amount_to_use INT,
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (foodstuff_id),
  FOREIGN KEY (meal_id) nutrition.meal REFERENCES (meal_id),
  FOREIGN KEY (foodstuff_master_id) nutrition.foodstuff_master REFERENCES (foodstuff_master_id)
);
