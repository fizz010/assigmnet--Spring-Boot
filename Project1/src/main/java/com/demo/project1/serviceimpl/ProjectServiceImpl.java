package com.demo.project1.serviceimpl;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.project1.dto.Customer;
import com.demo.project1.dto.Order;
import com.demo.project1.dto.Product;
import com.demo.project1.repository.CustomerRepository;
import com.demo.project1.repository.OrderRepository;
import com.demo.project1.repository.ProductRepository;
import com.demo.project1.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	

	
	@Override
	public Order saveOrder(Order order) {
		customerRepository.save(order.getCustomer());
		productRepository.saveAll(order.getProducts());
		return orderRepository.save(order);
	}
	
	@Override
	public Product getProductById(long id) {
		return productRepository.findById(id).get();
	}
	
	@Override
	public List<Product> getAllProducts(){
		List<Product> products = productRepository.findAll();
		return products;
	}
	
	public List<Product> getBooksCategory(){
		List<Product> books = productRepository.findAll().stream()
							  .filter(product -> product.getCategory().equals("Book") && product.getPrice()>100)
							.collect(Collectors.toList());
		return books;
							  
	}
	
}
