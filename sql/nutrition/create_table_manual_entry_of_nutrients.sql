DROP TABLE IF EXISTS nutrition.manual_entry_of_nutrients;

--栄養素の手動入力
CREATE TABLE nutrition.manual_entry_of_nutrients (
  manual_entry_of_nutrients_id INT,
  meal_id INT NOT NULL,
  nutrition_type VARCHAR(20) NOT NULL,
  nutrition_amount INT NOT NULL,
  created_at DATE NOT NULL,
  updated_at DATE NOT NULL,
  PRIMARY KEY (manual_entry_of_nutrients_id),
  FOREIGN KEY (meal_id) REFERENCES nutrition.meal (meal_id),
  FOREIGN KEY (nutrition_type) REFERENCES nutrition.nutrition (nutrition_type)
);

DROP SEQUENCE nutrition.manual_entry_of_nutrients_manual_entry_of_nutrients_id_SEQ;


CREATE SEQUENCE nutrition.manual_entry_of_nutrients_manual_entry_of_nutrients_id_SEQ
  INCREMENT BY 1
  MAXVALUE 2147483647
  START WITH 1
  NO CYCLE
;
