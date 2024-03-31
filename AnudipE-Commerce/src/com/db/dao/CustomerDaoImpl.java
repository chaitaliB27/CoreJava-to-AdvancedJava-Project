package com.db.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.pojo.Customer;
import com.db.pojo.Product;
import com.db.util.DBUtility;

public class CustomerDaoImpl implements CustomerDao{
	
	Connection con=null;
	PreparedStatement ps=null;
	String sql=null;
	ResultSet rs=null;
	List<Customer> custlist=null;
	
	@Override
	public boolean addCustomer(Customer c) {
		
		con=DBUtility.makeConnection();
		try {
			
			sql="insert into Customer_6201(custName, email, permanentAddress, contact, password) values(?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, c.getCustName());
			ps.setString(2, c.getEmail() );
			ps.setString(3, c.getPermanentAddress());
			ps.setLong(4, c.getContact());
			ps.setString(5, c.getPassword() );
			
			int i=ps.executeUpdate();
			
			if(i>0)
				return true;
		
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			
			try {
				ps.close();
				con.close();
			}
			catch(SQLException e) {
				
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		
		con=DBUtility.makeConnection();
		sql="update Customer_6201 set custName=?, email=?, permanentAddress=?, contact=?, password=? where custId=?";
		
		try {
			
			ps=con.prepareStatement(sql);
			
			ps.setString(1, c.getCustName());
			ps.setString(2, c.getEmail() );
			ps.setString(3, c.getPermanentAddress());
			ps.setLong(4, c.getContact());
			ps.setString(5, c.getPassword() );
			
			ps.setInt(6, c.getCustId());
			
			int i=ps.executeUpdate();
			if(i>0)
				return true;
			
		} 
		catch (Exception e) {
			
			e.printStackTrace();
			
		}
		finally {
			
			try {
				ps.close();
				con.close();
			} 
			catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public Customer showCustomerById(Integer custId) {
		
		con=DBUtility.makeConnection();
		sql="select * from Customer_6201 where custId=?";
		try {
			
			ps=con.prepareStatement(sql);
			ps.setInt(1, custId);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				Customer c=new Customer();
				c.setCustId(rs.getInt("custId"));
				c.setCustName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPermanentAddress(rs.getString(4));
				c.setContact(rs.getLong(5));
				c.setPassword(rs.getString(6));
				
				
				return c;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		finally {
			
			try {
				ps.close();
				rs.close();
				con.close();
			}
			catch(Exception e) {
				
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public LoginDaoImpl2 makeObject() {
		
		con=DBUtility.makeConnection();
		sql="select * from Customer_6201";
		
		custlist=new ArrayList<Customer>();
		
	    try {
	    	
	    	ps=con.prepareStatement(sql);
	    	rs=ps.executeQuery();
	    	
	        while (rs.next()) {
	            Customer c = new Customer();
	            c.setCustId(rs.getInt("custId"));
	            c.setCustName(rs.getString(2));
	            c.setEmail(rs.getString(3));
	            c.setPermanentAddress(rs.getString(4));
	            c.setContact(rs.getLong(5));
	            c.setPassword(rs.getString(6));

	            custlist.add(c);
	        }
	    } 
	    catch (SQLException e) {
	    	
	        e.printStackTrace();
	    } 
	    finally {
	    	
	        try {
	        	
	            rs.close();
	        } 
	        catch (SQLException e) {
	        	
	            e.printStackTrace();
	        }
	    }
		return new LoginDaoImpl2(custlist);
	}

}
