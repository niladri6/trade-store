DROP TABLE IF EXISTS STORE;  
CREATE TABLE STORE (  
trade_id VARCHAR(10) NOT NULL, 
version INT(8) NOT NULL,
container_party_id VARCHAR(50) NOT NULL,  
book_id VARCHAR(50) NOT NULL, 
maturity_date VARCHAR(20) NOT NULL,
created_date VARCHAR(20) NOT NULL,
expired VARCHAR(20) NOT NULL
); 