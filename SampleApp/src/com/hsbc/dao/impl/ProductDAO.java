package com.hsbc.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.dao.IProductRepo;
import com.hsbc.exceptions.ProductAlreadyExistsException;
import com.hsbc.exceptions.ProductNotFoundException;
import com.hsbc.helper.DBHelper;
import com.hsbc.model.Product;

public class ProductDAO implements IProductRepo {

	@Override
	public void saveProduct(Product product) throws ProductAlreadyExistsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(Product product) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> findProducts() throws ProductNotFoundException {
		// TODO Auto-generated method stub
		
		ResultSet rs=null;
		List<Product> p=new ArrayList<Product>();
		try {
			Statement ps=DBHelper.getDb().getCon()
					.createStatement();
			 rs=ps.executeQuery("select productId,productName,category,price,quantity,rol from app.product"
						);
				while(rs.next()) {
					p.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6)));
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Product findProductById(int productId) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		Product p=null;
		try {
			PreparedStatement ps=DBHelper.getDb().getCon()
					.prepareStatement(
							"select productId,productName,category,price,quantity,rol from app.product where productId=?"
							);
			ps.setInt(1, productId);
			 rs=ps.executeQuery();
			if(!rs.next()) 
				throw new ProductNotFoundException("Product with productId "+productId+" does not exist");
			else {
				p=new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void deleteProduct(Product product) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
