package com.demo.project1.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.project1.dto.Order;
import com.demo.project1.dto.Product;
import com.demo.project1.service.ProjectService;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService service;
	
	@PostMapping("/product")
	public Order saveOrder(@RequestBody Order order) {
		return service.saveOrder(order);
	}
	
	@GetMapping("/products")
	public List<Product> getBooksCategory(){
		return service.getAllProducts();
		
	}
	
	@GetMapping("/product/{id}")
	public String getProductById(@PathVariable("id") long id) {
		Product product= service.getProductById(id);
		System.out.println(product);
		return product.getName();
	}
}
