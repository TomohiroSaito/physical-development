--食材マスター
CREATE TABLE nutrition.foodstuff_master (
  foodstuff_master_id INT,
  foodstuff_name VARCHAR(10),
  nutrition_id VARCHAR(12),
  nutrient_amount NUMERIC,
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (foodstuff_master_id),
  FOREIGN KEY (nutrition_id) nutrition.nutrition REFERENCES (nutrition_id)
);
