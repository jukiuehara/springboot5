package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.controller.entity.Product;
import com.example.demo.controller.entity.User;
import com.example.demo.controller.form.loginForm;
import com.example.demo.controller.service.ProductServices;
import com.example.demo.controller.service.UserServices;

@Controller
public class productController {

	@Autowired
	private UserServices us;
	@Autowired
	private ProductServices ps;
	@Autowired
	HttpSession session;

	@RequestMapping("/index")
	public String index(@ModelAttribute("product") loginForm from, Model model) {
		return "index";
	}

	@RequestMapping("/rogin")
	public String rogin(@Validated @ModelAttribute("product") loginForm form, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "index";
		}
		User user = us.login(form.getId(), form.getPass());

		if (user != null) {
			List<Product> list = new ArrayList<>();
			list = ps.search("");
			session.setAttribute("list", list);
			return "menu";
		} else {
			model.addAttribute("msg", "IDまたはパスワードが不正です");
			return "index";
		}

	}

}
