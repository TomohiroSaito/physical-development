 DROP TABLE IF EXISTS nutrition.target_nutrient_amount;

--目標栄養素量
CREATE TABLE nutrition.target_nutrient_amount (
  target_nutrient_amount_id INT,
  account_id INT NOT NULL,
  nutrition_type VARCHAR(20) NOT NULL,
  target_nutrient_amount INT NOT NULL,
  created_at DATE NOT NULL,
  updated_at DATE NOT NULL,
  PRIMARY KEY (target_nutrient_amount_id),
  FOREIGN KEY (account_id) REFERENCES account.account (account_id),
  FOREIGN KEY (nutrition_type) REFERENCES nutrition.nutrition (nutrition_type)
);

DROP SEQUENCE nutrition.target_nutrient_amount_target_nutrient_amount_id_SEQ;

CREATE SEQUENCE nutrition.target_nutrient_amount_target_nutrient_amount_id_SEQ
  INCREMENT BY 1
  MAXVALUE 2147483647
  START WITH 1
  NO CYCLE
;
