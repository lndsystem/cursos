INSERT INTO cliente (id, nome) VALUES (1, 'Jose'), (2, 'Maria');

INSERT INTO produto (id, nome, valor) VALUES (1, 'Notebook', 1980.0), (2, 'Smartphone', 1299.0), (3, 'Tablet', 999.0);

INSERT INTO venda (id, cliente_id, frete, total, cadastro) VALUES (1, 1, 2.0, 1998.0, getdate());
INSERT INTO item (id, venda_id, produto_id, quantidade, valor_unitario) VALUES (1,1,3,2,999.0);

INSERT INTO venda (id, cliente_id, frete, total, cadastro) VALUES (2, 2, 50.0, 4328.0, getdate());
INSERT INTO item (id, venda_id, produto_id, quantidade, valor_unitario) VALUES (2,2,1,1,1980.0);
INSERT INTO item (id, venda_id, produto_id, quantidade, valor_unitario) VALUES (3,2,2,1,1299.0);
INSERT INTO item (id, venda_id, produto_id, quantidade, valor_unitario) VALUES (4,2,3,1,999.0);