select name from SalesPerson 
where sales_id NOT IN ( select distinct sales_id from Orders o JOIN Company c ON o.com_id=c.com_id and c.name="RED")