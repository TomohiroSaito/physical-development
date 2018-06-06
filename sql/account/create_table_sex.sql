DROP TABLE account.sex;

--性別
CREATE TABLE account.sex (
  sex_type VARCHAR(10),
  sex_name VARCHAR(10),
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (sex_type),
  UNIQUE (sex_name)
);
