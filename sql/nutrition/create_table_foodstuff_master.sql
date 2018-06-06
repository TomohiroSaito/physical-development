DROP TABLE IF EXISTS nutrition.foodstuff_master;

--食材マスター
CREATE TABLE nutrition.foodstuff_master (
  foodstuff_master_id SERIAL,
  foodstuff_name VARCHAR(30) NOT NULL,
  nutrition_type VARCHAR(20) NOT NULL,
  nutrient_amount NUMERIC NOT NULL,
  created_at DATE NOT NULL,
  updated_at DATE NOT NULL,
  PRIMARY KEY (foodstuff_master_id),
  FOREIGN KEY (nutrition_type) REFERENCES nutrition.nutrition (nutrition_type)
);
