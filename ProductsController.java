package com.john.mystore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.john.mystore.models.Product;
import com.john.mystore.models.ProductDto;
import com.john.mystore.services.ProductsService;

import jakarta.validation.Valid;




@Controller
@RequestMapping("/products")
public class ProductsController {
	@Autowired
	private ProductsService service;
	
	@GetMapping({"","/"})
	public String showProductList(Model model) {
		List<Product> productsList = service.getProducts();
		model.addAttribute("productsList",productsList);
		return "products/ProductsList";
	}
	@GetMapping("/create")
	public String showCreateProduct(Model model) {
		System.out.println("Testing111");
		ProductDto productDto=new ProductDto();
		
		model.addAttribute("productDto",productDto);
		return "products/CreateProduct";
	}
	
	@PostMapping("/create")
	public String createProduct(@Valid @ModelAttribute ProductDto productDto,BindingResult result) {
		
		System.out.println("Testing123");
		if(result.hasErrors()) {
			System.out.println("Testing13333");
			return "products/CreateProduct";
		}
		
		Product product = new Product();
		product.setName(productDto.getName());
		product.setBrand(productDto.getBrand());
		product.setCategory(productDto.getCategory());
		product.setPrice(productDto.getPrice());
		
		service.addProduct(product);
		
		return "redirect:/products";
	}
	
	@GetMapping({"/edit"})
	public String showEditProduct() {
		return "products/EditProduct";
	}
	
	@PostMapping("/edit")
	public String EditProduct() {
		
		return "redirect:/products";
	}
}
