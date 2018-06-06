DROP TABLE IF EXISTS account.profile;

--プロフィール
CREATE TABLE account.profile (
  account_id INT,
  sex_type VARCHAR(10) NOT NULL,
  birthday DATE NOT NULL,
  created_at DATE NOT NULL,
  updated_at DATE NOT NULL,
  PRIMARY KEY (account_id),
  FOREIGN KEY (account_id) REFERENCES account.account (account_id),
  FOREIGN KEY (sex_type) REFERENCES account.sex (sex_type)
);
