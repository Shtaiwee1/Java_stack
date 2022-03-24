package com.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.productscategories.models.Category;
import com.productscategories.models.Product;
import com.productscategories.repositories.CategoryRepository;
import com.productscategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	 
	 public ProductService(CategoryRepository categoryRepository, ProductRepository productRepository) {
	     this.categoryRepository = categoryRepository;
	     this.productRepository = productRepository;
	 }
	 // returns all the products
	 public List<Product> allProducts() {
	     return productRepository.findAll();
	 }
	 // create a new Product
	 public Product createProduct(Product e) {
	     return productRepository.save(e);
	 }
	 
	// retrieves a product
		public Product findProduct(Long id) {
			Optional<Product> optionalProduct = productRepository.findById(id);
			if (optionalProduct.isPresent()) {
				return optionalProduct.get();
			} else {
				return null;
			}
		}
		
		//this method adds a category to a product
		public Product addCategoryToProduct(long id, long categoryId) {
			Optional<Product> p = productRepository.findById(id);
			Optional<Category> c = categoryRepository.findById(categoryId);
			if (p.isPresent() && c.isPresent()) {
				Product product = p.get();
				Category category = c.get();
				product.getCategories().add(category);
				return productRepository.save(product);
			} else {
				return null;
			}
		}
		
		// finds all products that don't belong to a specific category
		public List<Product> findProductsNotInCategory(Category category) {
			return productRepository.findByCategoriesNotContains(category);
		}


}
