DROP TABLE IF EXISTS nutrition.meal;

--食事
CREATE TABLE nutrition.meal (
  meal_id INT,
  daily_nutrient_amount_id INT NOT NULL,
  order_of_meals INT NOT NULL,
  meal_name VARCHAR(20) NOT NULL,
  input_type VARCHAR(20) NOT NULL,
  created_at DATE NOT NULL,
  updated_at DATE NOT NULL,
  PRIMARY KEY (meal_id),
  FOREIGN KEY (daily_nutrient_amount_id) REFERENCES nutrition.daily_nutrient_amount (daily_nutrient_amount_id),
  FOREIGN KEY (input_type) REFERENCES nutrition.input_method (input_type)
);

DROP SEQUENCE nutrition.meal_meal_id_SEQ;

CREATE SEQUENCE nutrition.meal_meal_id_SEQ
  INCREMENT BY 1
  MAXVALUE 2147483647
  START WITH 1
  NO CYCLE
;
