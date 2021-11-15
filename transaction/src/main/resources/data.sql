insert into  transaction (amount, customer_id, date_created, date_modified, merchant_id, status, tran_id) 
    values (5000, 1, sysdate, sysdate, 1, 'APPROVED', transaction_id_sequence.nextval);
    
insert into tran_product(date_created, date_modified, description, price, quantity, tran_id, id) 
    values  (sysdate, sysdate, 'Product 1', 5000, 30, 1,  tran_product_id_sequence.nextval);
    
select transaction_id_sequence.nextval;
