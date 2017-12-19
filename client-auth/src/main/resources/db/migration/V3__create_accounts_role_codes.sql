CREATE TABLE accounts_role_codes (
  account_id   INTEGER NOT NULL,
  role_code_id INTEGER NOT NULL,
  PRIMARY KEY (account_id, role_code_id),
  FOREIGN KEY (account_id) REFERENCES accounts (id),
  FOREIGN KEY (role_code_id) REFERENCES role_codes (id)
);