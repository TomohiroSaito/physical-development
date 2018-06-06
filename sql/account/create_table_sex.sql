DROP TABLE IF EXISTS account.sex;

--性別
CREATE TABLE account.sex (
  sex_type VARCHAR(10),
  sex_name VARCHAR(10) NOT NULL,
  created_at DATE NOT NULL,
  updated_at DATE NOT NULL,
  PRIMARY KEY (sex_type),
  UNIQUE (sex_name)
);
