DROP TABLE account.account;

--会員
CREATE TABLE account.account (
  account_id INT,
  login_id VARCHAR(20),
  password VARCHAR(20),
  created_at DATE,
  updated_at DATE,
  PRIMARY KEY (account_id),
  UNIQUE (login_id)
);
