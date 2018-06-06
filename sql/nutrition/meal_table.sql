--食事
CREATE TABLE nutrition.meal (
  meal_id INT,
  daily_nutrient_amount_id INT,
  order_of_meals INT,
  meal_name VARCHAR(10),
  input_type VARCHAR(6),
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (meal_id),
  FOREIGN KEY (daily_nutrient_amount_id) nutrition.daily_nutrient_amount REFERENCES (daily_nutrient_amount_id),
  FOREIGN KEY (input_type) nutrition.input_method REFERENCES (input_type)
);
