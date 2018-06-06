DROP TABLE IF EXISTS nutrition.recommended_intake;

--推奨摂取量
CREATE TABLE nutrition.recommended_intake (
  recommended_intake_id SERIAL,
  age INT NOT NULL,
  sex_type VARCHAR(10) NOT NULL,
  nutrition_type VARCHAR(20) NOT NULL,
  recommended_intake INT NOT NULL,
  created_at DATE NOT NULL,
  updated_at DATE NOT NULL,
  PRIMARY KEY (recommended_intake_id),
  FOREIGN KEY (sex_type) REFERENCES account.sex (sex_type),
  FOREIGN KEY (nutrition_type) REFERENCES nutrition.nutrition (nutrition_type)
);
