package com.db.dao;

import com.db.pojo.Customer;

public interface CustomerDao {

	public boolean addCustomer(Customer c);   //Employee's object store employee details in this method
	public boolean updateCustomer(Customer c);
	
	public Customer showCustomerById(Integer custId);
	
}
