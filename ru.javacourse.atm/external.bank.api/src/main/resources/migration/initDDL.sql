CREATE SCHEMA IF NOT EXISTS api;

CREATE TABLE IF NOT EXISTS api.card (
    cardid serial NOT NULL,
    cardnumber VARCHAR(255) NOT NULL,
    cardpinhash VARCHAR(32) NOT NULL,
    cvcpinhash VARCHAR(32) NOT NULL,
    expiredate DATE NOT NULL,
    isblocked BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT t_card_pkey PRIMARY KEY (cardid)
);
