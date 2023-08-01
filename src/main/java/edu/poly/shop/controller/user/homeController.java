package edu.poly.shop.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.poly.shop.domain.Product;
import edu.poly.shop.service.CategoryService;
import edu.poly.shop.service.ProductService;
import edu.poly.shop.service.StorageService;

@Controller
@RequestMapping("user/home")
public class homeController {
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	StorageService storageService ;
	
	
	@GetMapping("/index")
	public String login() {
		return "/admin/home/home";
	}
//	@GetMapping("/images/{filename:.+}")
//	@ResponseBody
//	public ResponseEntity<Resource> serveFile(@PathVariable String filename){
//		Resource file = storageService.loadResource(filename);
//		
//		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, 
//				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
//	}
	@RequestMapping("")
	public String list(ModelMap model) {
		List<Product> list = productService.findAll();
		
		model.addAttribute("products" , list); 
		
		return "admin/home/home";
	}
}
