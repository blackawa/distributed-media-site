CREATE TABLE role_codes (
  id          SERIAL PRIMARY KEY,
  description VARCHAR(1024),
  enabled_at  TIMESTAMP,
  disabled_at TIMESTAMP
);