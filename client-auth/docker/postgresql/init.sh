#!/usr/bin/env bash

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE client_auth_test;
    GRANT ALL PRIVILEGES ON DATABASE client_auth_test TO ${POSTGRES_USER};
EOSQL
