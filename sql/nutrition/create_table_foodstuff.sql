DROP TABLE nutrition.foodstuff;

--食材
CREATE TABLE nutrition.foodstuff (
  foodstuff_id INT,
  meal_id INT,
  foodstuff_master_id INT,
  amount_to_use INT,
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (foodstuff_id),
  FOREIGN KEY (meal_id) REFERENCES nutrition.meal (meal_id),
  FOREIGN KEY (foodstuff_master_id) REFERENCES nutrition.foodstuff_master (foodstuff_master_id)
);
