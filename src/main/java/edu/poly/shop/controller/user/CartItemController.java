package edu.poly.shop.controller.user;

import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.shop.domain.Category;
import edu.poly.shop.domain.Product;
import edu.poly.shop.model.ProductDto;
import edu.poly.shop.service.CategoryService;
import edu.poly.shop.service.ProductService;
import edu.poly.shop.service.StorageService;

@Controller
@RequestMapping("admin/home")
public class CartItemController {
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	StorageService storageService ;
	
//	@GetMapping("edit/{productId}")
//	public ModelAndView edit(ModelMap model , @PathVariable("productId") Long productId) {
//		
//		Optional<Product>  opt = productService.findById(productId);
//		ProductDto dto = new ProductDto();
//		
//		if(opt.isPresent()) {
//			Product entiry = opt.get();
//			
//			BeanUtils.copyProperties(entiry, dto);
//			
//			dto.setCategoryId(entiry.getCategory().getCategoryId());
//			dto.setIsEdit(true);
//			
//			model.addAttribute("product",dto);
//			
////			return new ModelAndView("admin/products/addOrEdit",model);
//		}
//		model.addAttribute("message", "Product is not existed");
//		
//		return new ModelAndView("forward:/admin/home",model) ;
//	}
//	@PostMapping("saveOrUpdate")
//	public ModelAndView saveOrUpdate(ModelMap model,
//			@Valid @ModelAttribute("product") ProductDto dto, BindingResult result) {
//		
//		if(result.hasErrors()) {
//			return new ModelAndView("admin/products/addOrEdit");
//		}
//		
//		Product entity = new Product();
//		BeanUtils.copyProperties(dto, entity);
//		
//		Category category = new Category();
//		category.setCategoryId(dto.getCategoryId());
//		entity.setCategory(category);
//		
//		if(!dto.getImageFile().isEmpty()) {
//			UUID uuid = UUID.randomUUID();
//			String uuString = uuid.toString();
//			
//			entity.setImage(storageService.getStoredFilename(dto.getImageFile(), uuString));
//			storageService.store(dto.getImageFile(), entity.getImage());
//		}
//		
//		productService.save(entity);
//		
//		model.addAttribute("message", "Product is saved!");
//		
//		return new ModelAndView("forward:/admin/home" , model) ;
//	}
}
