INSERT INTO cliente (id, nome) VALUES (1, 'Eletrônicos Eletro'), (2, 'Smart Compras');

INSERT INTO produto (id, nome, valor) VALUES (1, 'Notebook', 2950.0), (2, 'Smartphone', 1800.0), (3, 'Tablet', 1100.0);

INSERT INTO venda (id, cliente_id, frete, total, cadastro) VALUES (1, 1, 15.0, 2965.0, sysdate());
INSERT INTO item (id, venda_id, produto_id, quantidade) VALUES (1,1,1,1);


INSERT INTO venda (id, cliente_id, frete, total, cadastro) VALUES (2, 1, 15.0, 4765.0, sysdate());
INSERT INTO item (id, venda_id, produto_id, quantidade) VALUES (2,2,1,1);
INSERT INTO item (id, venda_id, produto_id, quantidade) VALUES (3,2,2,1);