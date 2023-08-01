package edu.poly.shop.controller;

import javax.mail.Session;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.shop.domain.Account;
import edu.poly.shop.model.AdminLoginDto;
import edu.poly.shop.service.AccountService;

@Controller
public class AdminLoginController {
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private HttpSession httpSession;
	
	
	@GetMapping("alogin")
	public String login(ModelMap model) {
		model.addAttribute("account" , new AdminLoginDto());
		return "/admin/accounts/login";
	}
	
	@PostMapping("alogin")
	public ModelAndView login(ModelMap model,
			@Valid @ModelAttribute("account") AdminLoginDto dto, 
			BindingResult result) {
		
		if(result.hasErrors()) {
			return new ModelAndView("/admin/accounts/login" , model);
		}
		
		Account account = accountService.login(dto.getUsername() , dto.getPassword());
		
		if(account == null) {
			model.addAttribute("message", "INvalid username or password");
			return new ModelAndView("/admin/accounts/login" , model);
		}
		httpSession.setAttribute("username", account.getUsername());
		
		
		Boolean isAdmin = account.getIsLogin();
		if(isAdmin == false) {
			return new ModelAndView("forward:/user/home");
		}
		
		Object ruri = httpSession.getAttribute("redirect-uri");
		
		if(ruri != null) {
			httpSession.removeAttribute("redirect-uri");
			return new ModelAndView("redirect:" + ruri);
		}
		
		model.addAttribute("account" , dto);
		
		return new ModelAndView("forward:/admin/products" ,  model);
		
	}
	 
	@GetMapping("alogout")
	public ModelAndView logout(ModelMap model) {
	 	httpSession.setAttribute("username", null);
//			model.addAttribute("account" , null);
		 	
		 	return new ModelAndView("forward:/alogin" , model);
	}
}
 