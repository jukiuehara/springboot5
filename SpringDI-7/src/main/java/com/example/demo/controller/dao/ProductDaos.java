package com.example.demo.controller.dao;

import java.util.List;

import com.example.demo.controller.entity.Product;

public interface ProductDaos {
	public List<Product> fintdByProductKey(String name);
	public void insert(Product product);
	public Product fintdByProductId(Integer userId);
	public void delete(int id);
}