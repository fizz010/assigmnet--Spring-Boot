package com.demo.project1.service;

import java.util.List;

import com.demo.project1.dto.Customer;
import com.demo.project1.dto.Order;
import com.demo.project1.dto.Product;

public interface ProjectService {
	
	public Order saveOrder(Order order);
	public Product getProductById(long id);
	public List<Product> getAllProducts();
	
}
