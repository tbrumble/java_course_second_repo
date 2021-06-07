CREATE SCHEMA IF NOT EXISTS api;

CREATE TABLE IF NOT EXISTS api.card (
    id serial NOT NULL,
    cardid serial NOT NULL,
    cardnumber VARCHAR(255) NOT NULL,
    cardpinhash VARCHAR(32) NOT NULL,
    cvcpinhash VARCHAR(32) NOT NULL,
    expiredate DATE NOT NULL,
    isblocked BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT t_card_pkey PRIMARY KEY (cardid)
);

CREATE TABLE IF NOT EXISTS api.client (
    id serial NOT NULL,
    clientid serial NOT NULL,
    accountid serial NOT NULL,
    CONSTRAINT t_client_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS api.account (
    id serial NOT NULL,
    cardid serial NOT NULL,
    accountid serial NOT NULL,
    accountnumber VARCHAR(20) NOT NULL,
    accountbalance NUMERIC(18,2),
    accountisocode VARCHAR(3),
    CONSTRAINT t_account_pkey PRIMARY KEY (id)
);
