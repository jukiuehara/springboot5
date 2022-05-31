package com.example.demo.controller.dao;

import java.util.List;

import com.example.demo.controller.entity.Product;

public interface ProductDaos {
	public List<Product> fintdByProductKey(String name);
}
