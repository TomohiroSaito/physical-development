DROP TABLE account.profile;

--プロフィール
CREATE TABLE account.profile (
  account_id INT,
  sex_type VARCHAR(10),
  birthday DATE,
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (account_id),
  FOREIGN KEY (account_id) REFERENCES account.account (account_id),
  FOREIGN KEY (sex_type) REFERENCES account.sex (sex_type)
);
