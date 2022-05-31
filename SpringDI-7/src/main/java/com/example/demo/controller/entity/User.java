package com.example.demo.controller.entity;

public class User {
	private String id;
	private String password;
	private String name;
	private int role;

	public User() {

	}

	public User(String login_id, String password, String name,int role) {
		this.id = login_id;
		this.name = name;
		this.password = password;
		this.role = role;

	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String login_id) {
		this.id = login_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}