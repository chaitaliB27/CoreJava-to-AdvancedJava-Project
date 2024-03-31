package com.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.pojo.Product;
import com.db.util.DBUtility;

public class ProductDaoImpl implements ProductDao{

	Connection con = null;
	PreparedStatement ps =null;
	String sql = null;
	ResultSet rs = null;
	
	@Override
	public Boolean addProduct(Product p) {
		
		con = DBUtility.makeConnection();
		try {
			
			sql = "insert into product(productName, productType, price, quantityInStock, rating, "
					+ "description) values(?, ?, ?, ?, ?, ?)";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, p.getProductName());
			ps.setString(2, p.getProductType());
			ps.setDouble(3, p.getPrice());
			ps.setInt(4, p.getQuantityInStock());
			ps.setDouble(5, p.getRating());
			ps.setString(6, p.getDescription());
			
			int i = ps.executeUpdate();
			
			if(i>0)
				return true;
		}
		catch(Exception e) {
			
		}
		
		finally {
			
			try {
				
				ps.close();
				con.close();
			} 
			catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	@Override
	public Boolean updateProduct(Product p) {
		
		con =DBUtility.makeConnection();
		sql = "update product set productName=?, productType=?, price=?, quantityInStock=?,"
				+ " rating=?, description=? where productId=?";
		try {
			
			ps=con.prepareStatement(sql);
			ps.setString(1, p.getProductName());
			ps.setString(2, p.getProductType());
			ps.setDouble(3, p.getPrice());
			ps.setInt(4, p.getQuantityInStock());
			ps.setDouble(5, p.getRating());
			ps.setString(6, p.getDescription());
			ps.setInt(7, p.getProductId());
			
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
		
		return null;
	}
	
	@Override
	public Boolean deleteProduct(Integer productId) {
		
		return false;
	}
	
	@Override
	public List<Product> showAllProducts() {
		
		con = DBUtility.makeConnection();
		sql = "select * from product";
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Product> plist = new ArrayList<Product>();
			
			while(rs.next()) {
				
				Product p = new Product();
				p.setProductId(rs.getInt(1));
				p.setProductName(rs.getString(2));
				p.setProductType(rs.getString(3));
				p.setPrice(rs.getDouble(4));
				p.setQuantityInStock(rs.getInt(5));
				p.setRating(rs.getDouble(6));
				p.setDescription(rs.getString(7));
				
				plist.add(p);
			}
			
			return plist;
		}
		catch(Exception e) {
			
		}
		
		finally {
			
			try {
				
				ps.close();
				rs.close();
				con.close();
			} 
			catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@Override
	public Product showProductById(Integer productId) {
		
		con = DBUtility.makeConnection();
		sql = "select * from product where productId=?";
		try {
		
			ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				
				Product p = new Product();
				p.setProductId(rs.getInt("productId"));
				p.setProductName(rs.getString(2));
				p.setProductType(rs.getString(3));
				p.setPrice(rs.getDouble(4));
				p.setQuantityInStock(rs.getInt(5));
				p.setRating(rs.getDouble(6));
				p.setDescription(rs.getString(7));
				
				return p;
			}
		}
		catch (Exception e){
			
			e.printStackTrace();
		}
		finally {
			
			try {
				
				ps.close();
				rs.close();
				con.close();
			} 
			catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		return null;
	}
	
	@Override
	public List<Product> searchProductByName(String productName) {
		
		con=DBUtility.makeConnection();
		sql="select * from product where productName like ?";//like is for matching special pattern
		try {
			
			ps=con.prepareStatement(sql);
			ps.setString(1, "%"+productName+"%");
			
			rs=ps.executeQuery();
			List<Product> plist=new ArrayList<Product>();
			
			while(rs.next()){
				
				Product p=new Product();
				p.setProductId(rs.getInt("productId"));
				p.setProductName(rs.getString(2));
				p.setProductType(rs.getString(3));
				p.setPrice(rs.getDouble(4));
				p.setQuantityInStock(rs.getInt(5));
				p.setRating(rs.getDouble(6));
				p.setDescription(rs.getString(7));
				
				plist.add(p);
			}
			
			return plist;
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

}
