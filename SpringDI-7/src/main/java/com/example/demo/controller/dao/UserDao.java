package com.example.demo.controller.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.entity.User;

@Repository
public class UserDao implements UserDaos{
	
    @Autowired
    private NamedParameterJdbcTemplate  jdbcTemplate;
    @Autowired
    private JdbcTemplate  jdbcTemplate2;
	
	private static final String SQL_SELECT_ID_PASS = "select * from users where login_id = :id AND password = :pass";

	public User fintdByUserIdPass(String id, String pass) {
	    	String sql = SQL_SELECT_ID_PASS;
	    	
	        MapSqlParameterSource param = new MapSqlParameterSource();
		    param.addValue("id", id);
		    param.addValue("pass", pass);

		    List<User> list =  jdbcTemplate.query(sql,param, new BeanPropertyRowMapper<User>(User.class));

		    return list.isEmpty() ? null : list.get(0);

	}
}