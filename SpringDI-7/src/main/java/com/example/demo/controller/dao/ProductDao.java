package com.example.demo.controller.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.entity.Product;

@Repository
public class ProductDao implements ProductDaos{
	private static final String SQL_SELECT_KEY_NAME = "SELECT p.id,product_id, category_id, p.name as name,description,price,c.name as category FROM products p INNER JOIN categories c ON p.category_id = c.id WHERE p.name LIKE :Pname or c.name LIKE :Cname";
	private static final String SQL_INSERT_PRODUCT = "insert into products (product_id, category_id, name, price, description)values(:id, :category, :name, :price, :description)";
	private static final String SQL_SELECT_ID = "SELECT product_id, category_id, p.name as name,description,price,c.name as category FROM products p INNER JOIN categories c ON p.category_id = c.id WHERE product_id = :id";
	private static final String SQL_DELETE ="delete from products where product_id = :id;";
	private static final String SQL_UPDATE ="UPDATE products SET product_id=:id,category_id =:category ,name= :name,price = :price,description = :des WHERE product_id = :oldid;";
	
	
    @Autowired
    private NamedParameterJdbcTemplate  jdbcTemplate;
   
	
    
	public List<Product> fintdByProductKey(String name) {
		List<Product> p = new ArrayList<>();
		String sql = SQL_SELECT_KEY_NAME;
		MapSqlParameterSource param = new MapSqlParameterSource();
	    param.addValue("Pname", "%"+name+"%");
	    param.addValue("Cname", "%"+name+"%");

	    p =  jdbcTemplate.query(sql,param, new BeanPropertyRowMapper<Product>(Product.class));
	    
	    return p;
	}
	
	public void insert(Product product) {
		String sql = SQL_INSERT_PRODUCT;

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", product.getProduct_id());
		param.addValue("category",product.getCategory_id() );
		param.addValue("name", product.getName());
		param.addValue("price", product.getPrice());
		param.addValue("description", product.getDescription());
		
		
		jdbcTemplate.update(sql,param);
	}
	public Product fintdByProductId(Integer userId) {
		List<Product> p = new ArrayList<>();
		String sql = SQL_SELECT_ID;
		MapSqlParameterSource param = new MapSqlParameterSource();
	    param.addValue("id", userId);
	    p =  jdbcTemplate.query(sql,param, new BeanPropertyRowMapper<Product>(Product.class));

	    return p.isEmpty() ? null : p.get(0);
	}
	
	public void delete(int id) {
		String sql = SQL_DELETE;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		jdbcTemplate.update(sql,param);
	}
	public void update(Product p,int oldid) {
		String sql = SQL_UPDATE;
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", p.getProduct_id());
		param.addValue("category", p.getCategory_id());
		param.addValue("name", p.getName());
		param.addValue("price", p.getPrice());
		param.addValue("des", p.getDescription());
		param.addValue("oldid", oldid);
		jdbcTemplate.update(sql,param);
	}
}