package com.hsbc.dao;

import java.util.List;

import com.hsbc.exceptions.ProductAlreadyExistsException;
import com.hsbc.exceptions.ProductNotFoundException;
import com.hsbc.model.Product;

public interface IProductRepo {

	void saveProduct(Product product) throws ProductAlreadyExistsException;
	void updateProduct(Product product) throws ProductNotFoundException;
	List<Product> findProducts() throws ProductNotFoundException;
	Product findProductById(int productId) throws ProductNotFoundException;
	void deleteProduct(Product product) throws ProductNotFoundException;
}
