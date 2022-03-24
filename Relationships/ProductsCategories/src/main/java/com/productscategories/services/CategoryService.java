package com.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.productscategories.models.Category;
import com.productscategories.models.Product;
import com.productscategories.repositories.CategoryRepository;
import com.productscategories.repositories.ProductRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	 
	 public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
	     this.categoryRepository = categoryRepository;
	     this.productRepository = productRepository;
	 }
	 // returns all the categories
	 public List<Category> allCategories() {
	     return categoryRepository.findAll();
	 }
	 // create a new category
	 public Category createCategory(Category e) {
	     return categoryRepository.save(e);
	 }
	 
	// retrieves a category
		public Category findCategory(Long id) {
			Optional<Category> optionalCategory = categoryRepository.findById(id);
			if (optionalCategory.isPresent()) {
				return optionalCategory.get();
			} else {
				return null;
			}
		}
		
		// this method adds a product to a category
		public Category addProductToCategory(long id, long productId) {
			Optional<Category> c = categoryRepository.findById(id);
			Optional<Product> p = productRepository.findById(productId);
			if (c.isPresent() && p.isPresent()) {
				Category category = c.get();
				Product product = p.get();
				category.getProducts().add(product);
				return categoryRepository.save(category);
			} else {
				return null;
			}

		}
		
		//returns all categories that don't have a specific product
		public List<Category> findCategoriesNotInProduct(Product product) {
			return categoryRepository.findByProductsNotContains(product);
		}

}
