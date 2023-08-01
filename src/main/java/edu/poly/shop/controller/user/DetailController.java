package edu.poly.shop.controller.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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
import org.springframework.web.servlet.ModelAndView;

import edu.poly.shop.domain.Product;
import edu.poly.shop.model.ProductDto;
import edu.poly.shop.service.CategoryService;
import edu.poly.shop.service.ProductService;
import edu.poly.shop.service.StorageService;

@Controller
@RequestMapping("user/home/")
public class DetailController {

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	StorageService storageService ;
	
	@GetMapping("detail/{productId}")
	public ModelAndView edit(ModelMap model , @PathVariable("productId") Long productId) {
		
		Optional<Product>  opt = productService.findById(productId);
		ProductDto dto = new ProductDto();
		
		if(opt.isPresent()) {
			Product entiry = opt.get();
			
			BeanUtils.copyProperties(entiry, dto);
			
			dto.setCategoryId(entiry.getCategory().getCategoryId());
//			dto.setIsEdit(true);
			
			model.addAttribute("product",dto);
			
			return new ModelAndView("admin/home/detail",model);
		}
		model.addAttribute("message", "Product is not existed");
		
		return new ModelAndView("forward:/admin/home",model) ;
	}
	@GetMapping("/images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename){
		Resource file = storageService.loadResource(filename);
		
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, 
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}
}
