package com.example.demo.controller.service;

import java.util.List;

import com.example.demo.controller.entity.Product;

public interface ProductServices {
	public List<Product> search(String key);
//	public void insert(int pid,int cid,String name, int price,String description);
}
