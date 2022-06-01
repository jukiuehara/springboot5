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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.controller.entity.Product;
import com.example.demo.controller.entity.User;
import com.example.demo.controller.form.ProductForm;
import com.example.demo.controller.form.loginForm;
import com.example.demo.controller.service.ProductServices;
import com.example.demo.controller.service.UserServices;

@Controller
public class productController {

	@Autowired
	private UserServices uss;
	@Autowired
	private ProductServices pss;
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
		User user = uss.login(form.getId(), form.getPass());

		if (user != null) {
			List<Product> list = new ArrayList<>();
			list = pss.search("");
			session.setAttribute("Username", user.getName());
			session.setAttribute("list", list);
			return "menu";
		} else {
			model.addAttribute("msg", "IDまたはパスワードが不正です");
			return "index";
		}

	}
	
	@RequestMapping("/menu")
	public String search(@RequestParam("key")String a,Model model) {
		List<Product> list = new ArrayList<>();
		list = pss.search(a);
		
		int count = 0;
		for (Product i : list) {
			System.out.print( i.getProduct_id());
			count++;
		}
		session.setAttribute("count", count);
		session.setAttribute("list", list);
		return"menu";
	}
	
	@RequestMapping("/insert")
	public String insert(@Validated @ModelAttribute("insert") ProductForm form, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "insert";
		}
		
		try{
			int id = form.getProductId();
			int categorynumber = form.getCategoryId();
			String name = form.getName();
			int price = form.getPrice();
			String des =form.getDescription();

			String msg = "登録が完了しました";
			model.addAttribute("msg", msg);
			pss.insert(id, categorynumber, name, price, des);
			return"insert";
		} catch (Exception e) {
			String msg = "idが重複しました";
			model.addAttribute("msg", msg);
			return"insert";
		}
	}
	@RequestMapping("/in")
	public String in(@ModelAttribute("insert") ProductForm from, Model model) {
		return "insert";
	}

	@RequestMapping("/detail")
	public String detail(@RequestParam("name")int a,Model model) {
		Product p = pss.fintdByProductId(a);
		session.setAttribute("product", p);
		return"detail";
	}
	
	@RequestMapping("/edit")
	public String edit1(@RequestParam("name")int a,Model model) {
		pss.delete(a);
		return"detail";
	}
	@RequestMapping("/back")
	public String back(Model model) {

		return"menu";
	}
}