CREATE TABLE CUSTOMER (CUSTOMER_ID int, CUSTOMER_NAME VARCHAR2(50) );
CREATE TABLE TRANSACTION (TRANSACTION_ID int,CUSTOMER_ID int ,TRANSACTION_DATE DATE,AMOUNT int);
INSERT INTO CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME) values (1,'TransCust1');
INSERT INTO CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME) values (2,'TransCust2');
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1,1,'2023-09-12',10);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (2,1,'2023-09-01',58);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (3,1,'2023-08-04',120);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (4,1,'2023-07-01',40);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (5,2,'2023-09-05',135);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (6,2,'2023-09-27',68);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (7,2,'2023-08-04',98);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (8,2,'2023-07-01',45);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (9,2,'2023-07-27',220);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (10,2,'2023-07-15',135);
COMMIT;