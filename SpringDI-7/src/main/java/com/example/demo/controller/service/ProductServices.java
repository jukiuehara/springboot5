package com.example.demo.controller.service;

import java.util.List;

import com.example.demo.controller.entity.Product;

public interface ProductServices {
	public List<Product> search(String key);
	public void insert(int pid,int cid,String name, int price,String description);
	public Product fintdByProductId(Integer id);
	public void delete(int id);
	public void update(int pid,int cid,String name, int price,String description ,int oldid);
}
