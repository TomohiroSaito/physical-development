DROP TABLE nutrition.meal;

--食事
CREATE TABLE nutrition.meal (
  meal_id INT,
  daily_nutrient_amount_id INT,
  order_of_meals INT,
  meal_name VARCHAR(20),
  input_type VARCHAR(20),
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (meal_id),
  FOREIGN KEY (daily_nutrient_amount_id) REFERENCES nutrition.daily_nutrient_amount (daily_nutrient_amount_id),
  FOREIGN KEY (input_type) REFERENCES nutrition.input_method (input_type)
);
