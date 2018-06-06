DROP TABLE nutrition.foodstuff;

--食材
CREATE TABLE nutrition.foodstuff (
  foodstuff_id INT,
  meal_id INT NOT NULL,
  foodstuff_master_id INT NOT NULL,
  amount_to_use INT NOT NULL,
  created_at DATE NOT NULL,
  updated_at DATE NOT NULL,
  PRIMARY KEY (foodstuff_id),
  FOREIGN KEY (meal_id) REFERENCES nutrition.meal (meal_id),
  FOREIGN KEY (foodstuff_master_id) REFERENCES nutrition.foodstuff_master (foodstuff_master_id)
);

DROP SEQUENCE nutrition.foodstuff_foodstuff_id_SEQ;

CREATE SEQUENCE nutrition.foodstuff_foodstuff_id_SEQ
  INCREMENT BY 1
  MAXVALUE 2147483647
  START WITH 1
  NO CYCLE
;
