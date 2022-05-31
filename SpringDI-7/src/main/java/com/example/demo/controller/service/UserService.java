package com.example.demo.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.dao.UserDaos;
import com.example.demo.controller.entity.User;
@Service
public class UserService implements UserServices{
	
	@Autowired
	private UserDaos dao;
	
      public User login(String id,String pass){

        	  return dao.fintdByUserIdPass(id,pass);
}
}