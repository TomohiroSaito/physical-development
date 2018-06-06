--推奨摂取量
CREATE TABLE nutrition.recommended_intake (
  recommended_intake_id SERIAL,
  age INT,
  sex_type VARCHAR(5),
  nutrition_type VARCHAR(12),
  recommended_intake INT,
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (recommended_intake_id),
  FOREIGN KEY (sex_type) REFERENCES user.sex (sex_type),
  FOREIGN KEY (nutrition_type) REFERENCES nutrition.nutrition (nutrition_type)
);
