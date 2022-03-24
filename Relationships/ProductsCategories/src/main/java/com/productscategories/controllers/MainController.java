package com.productscategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.productscategories.models.Category;
import com.productscategories.models.Product;
import com.productscategories.services.CategoryService;
import com.productscategories.services.ProductService;

@Controller
public class MainController {
	
	private final ProductService productService;
	private final CategoryService categoryService;

	public MainController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	@GetMapping("/products/new")
    public String newProduct(Model model , @ModelAttribute("product") Product product) {
		List<Category> categories = categoryService.allCategories();
		model.addAttribute("categories", categories);
		return "product.jsp";
    }
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "category.jsp";
	}
	
	@PostMapping("/products")
	public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "Product.jsp";
		} else {
			productService.createProduct(product);
			return "redirect:/products/new";
		}
	}
	
	@PostMapping("/categories")
	public String createNew(@Valid @ModelAttribute("categpry") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "Category.jsp";
		} else {
			categoryService.createCategory(category);
			return "redirect:/categories/new";
		}
	}
	
	@GetMapping("/")
	public String dashboard(Model model) {

		List<Category> categories = categoryService.allCategories();
		List<Product> products = productService.allProducts();
		model.addAttribute("categories", categories);
		model.addAttribute("products", products);

		return "index.jsp";
	}
	
	@GetMapping("/products/{id}")
	public String prodInfo(@PathVariable("id") Long id, Model model) {
		Product product = productService.findProduct(id);
		List<Category> categories = categoryService.findCategoriesNotInProduct(product);
		model.addAttribute("product", product);
		model.addAttribute("categories", categories);
		return "prodInfo.jsp";
	}
	
	@GetMapping("/categories/{id}")
	public String catInfo(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.findCategory(id);
		List<Product> products = productService.findProductsNotInCategory(category);
		model.addAttribute("category", category);
		model.addAttribute("products", products);
		return "catInfo.jsp";
	}
	
	@PutMapping("/products/{id}")
	public String addCat(@PathVariable("id") Long id, @RequestParam(value = "id") Long categoryId) {
		productService.addCategoryToProduct(id, categoryId);
		return String.format("redirect:/products/%d", id);

	}
	
	@PutMapping("/categories/{id}")
	public String addProd(@PathVariable("id") Long id, @RequestParam(value = "id") Long productId) {
		categoryService.addProductToCategory(id, productId);
		return String.format("redirect:/categories/%d", id);

	}

}


