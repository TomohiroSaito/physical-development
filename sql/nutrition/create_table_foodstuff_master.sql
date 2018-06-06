DROP TABLE nutrition.foodstuff_master;

--食材マスター
CREATE TABLE nutrition.foodstuff_master (
  foodstuff_master_id SERIAL,
  foodstuff_name VARCHAR(30),
  nutrition_type VARCHAR(20),
  nutrient_amount NUMERIC,
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (foodstuff_master_id),
  FOREIGN KEY (nutrition_type) REFERENCES nutrition.nutrition (nutrition_type)
);
