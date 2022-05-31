package com.example.demo.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.dao.ProductDaos;
import com.example.demo.controller.entity.Product;


@Service
public class ProductService implements ProductServices{

	@Autowired
	private ProductDaos dao;
	
      public List<Product> search(String key){
          try {
              return dao.fintdByProductKey(key);
          } catch (Exception e) {
              e.printStackTrace();
          }
          return null;
}
//      public void insert(int pid,int cid,String name, int price,String description) {
//  		Product p = new Product();
//  		Connection con = DbUtil.getConnection();
//  		ProductDao pd = new ProductDao(con);
//  		
//		p.setProduct_id(pid);
//		p.setCategory_id(cid);
//		p.setName(name);
//		p.setPrice(price);
//		p.setDescription(description);
//		
//		pd.insert(p);
//      }
//      


}