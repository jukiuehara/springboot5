package com.example.demo.controller.entity;

public class Product{
	private int id;
	private int product_id;
	private int category_id;
	private String name;
	private int price;
	private String description;
	private String category;
	
	public Product() {
		
	}
	
	public Product(int id,int product_id,int category_id,String name,int price,String description,String category) {
		this.id = id;
		this.product_id = product_id;
		this.category_id = category_id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}