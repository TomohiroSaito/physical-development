--性別
CREATE TABLE user.sex (
  sex_type VARCHAR(5),
  sex_name VARCHAR(2),
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (sex_type),
  UNIQUE (sex_name)
);
