DELETE FROM api.card;
INSERT INTO api.card (cardid, cardnumber, cardpinhash, cvcpinhash, expiredate, isblocked) VALUES
(16, '5169147129584558', 'b59c67bf196a4758191e42f76670ceba', '73f7634ab3f381fb40995f93740b3f8a', '2020-02-02', FALSE),
(31, '4000000000000002', '738cccd4fda172441f216712a488dca6', 'a1c3ae6c49a89d92aef2d423dadb477f', '2021-01-30', TRUE),
(48, '5105105105105100', 'b59c67bf196a4758191e42f76670ceba', 'bcbe3365e6ac95ea2c0343a2395834dd', '2019-07-31', FALSE),
(35, '4111110000000112', '934b535800b1cba8f96a5d72f72f1611', '310dcbbf4cce62f762a2aaa148d556bd', '2018-11-01', FALSE),
(12, '4222222222222220', '2be9bd7a3434f7038ca27d1918de58bd', '550a141f12de6341fba65b0ad0433500', '2020-05-25', TRUE);

DELETE FROM api.client;
INSERT INTO api.client (clientid, accountid) VALUES
('251', '21'),
('320', '19'),
('16', '47'),
('11', '54'),
('5', '25');

DELETE FROM api.account;
INSERT INTO api.account (cardid, accountid, accountnumber, accountbalance, accountisocode) VALUES
(16, '21', '40807840611111212111', 1213121.91, 'USD'),
(39, '19', '40101643811111111111', 1212121212121212.12, 'RUB'),
(16, '47', '03016431211111111111', -0.54, 'RUB'),
(12, '47', '40702643512121212121', 185301.56, 'RUB'),
(48, '25', '40802840212121212121', 12.00, 'USD');
