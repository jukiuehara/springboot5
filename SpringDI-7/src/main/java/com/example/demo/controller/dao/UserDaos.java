package com.example.demo.controller.dao;

import com.example.demo.controller.entity.User;

public interface UserDaos {
	public User fintdByUserIdPass(String id, String password);
}
