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
			session.setAttribute("Role", user.getRole());
			session.setAttribute("list", list);
			return "menu";
		} else {
			model.addAttribute("msg", "IDまたはパスワードが不正です");
			return "index";
		}
	}

	@RequestMapping("/menu")
	public String search(@RequestParam("key") String a,@RequestParam("category") String b,Model model) {
		List<Product> list = new ArrayList<>();
		list = pss.search(a);
		int count = 0;
		switch(b) {
		case "heigtprice":
			
			list.sort((p1, p2) -> p1.getPrice() >= p2.getPrice() ? -1 : 1);
			break;
		case "id":
			
			list.sort((p1, p2) -> p1.getProduct_id() <= p2.getProduct_id() ? -1 : 1);
			break;
		case "category":
			
			list.sort((p1, p2) -> p1.getCategory_id() >= p2.getCategory_id() ? -1 : 1);
			break;
		case "lowprice":
			
			list.sort((p1, p2) -> p1.getPrice() <= p2.getPrice() ? -1 : 1);
			break;
		case "oldid":
			
			list.sort((p1, p2) -> p1.getId() <= p2.getId() ? -1 : 1);
	
			break;
		case "newid":
			
			list.sort((p1, p2) -> p1.getId() >= p2.getId() ? -1 : 1);
			break;

		}
		for (Product i : list) {
			count++;
		}
		session.setAttribute("count", count);
		session.setAttribute("list", list);
		return "menu";
	}
	


	@RequestMapping("/insert")
	public String insert(@Validated @ModelAttribute("insert") ProductForm form, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "insert";
		}

		try {
			int id = form.getProductId();
			int categorynumber = form.getCategoryId();
			String name = form.getName();
			int price = form.getPrice();
			String des = form.getDescription();

			String msg = "登録が完了しました";
			model.addAttribute("msg", msg);
			pss.insert(id, categorynumber, name, price, des);
			return "insert";
		} catch (Exception e) {
			String msg = "idが重複しました";
			model.addAttribute("msg", msg);
			return "insert";
		}
	}

	@RequestMapping("/updatetable")
	public String update(@Validated @ModelAttribute("update") ProductForm form, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "update";
		}

		int id = form.getProductId();
		Product p = pss.fintdByProductId(id);

		int productid = 1;
		if (null != p) {
			productid = p.getProduct_id();
			System.out.println(p.getProduct_id());
		}

		Product a = (Product) session.getAttribute("product");

		if (productid == form.getProductId()) {
			String msg = "商品idが重複しています";
			model.addAttribute("erroridmsg", msg);
			return "update";
		}
		pss.update(form.getProductId(), form.getCategoryId(), form.getName(), form.getPrice(), form.getDescription(),
				a.getProduct_id());
		List<Product> list = new ArrayList<>();
		list = pss.search("");
		session.setAttribute("list", list);
		return "menu";
	}

	@RequestMapping("/in")
	public String in(@ModelAttribute("insert") ProductForm from, Model model) {
		
		return "insert";
	}

	@RequestMapping("/detail")
	public String detail(@RequestParam("name") int a, Model model) {
		Product p = pss.fintdByProductId(a);
		session.setAttribute("product", p);
		return "detail";
	}

	@RequestMapping("/edit")
	public String edit1(Model model) {
		Product p = (Product) session.getAttribute("product");
		pss.delete(p.getProduct_id());
		String msg = "消去が完了しました";
		model.addAttribute("deletemsg", msg);
		List<Product> list = new ArrayList<>();
		list = pss.search("");
		session.setAttribute("list", list);
		return "menu";
	}

	@RequestMapping("/update")
	public String update(@ModelAttribute("update") ProductForm form, Model model) {
		Product p = (Product) session.getAttribute("product");

		form.setProductId(p.getProduct_id());
		form.setName(p.getName());
		form.setPrice(p.getPrice());
		form.setDescription(p.getDescription());

		return "update";
	}

	@RequestMapping("/back")
	public String back(Model model) {
		List<Product> list = new ArrayList<>();
		list = pss.search("");
		session.setAttribute("list", list);
		return "menu";
	}
	@RequestMapping("/logout")
	public String logout(Model model) {
		
		System.out.println("sspk");
		session.invalidate();
		return "logout";
	}
}