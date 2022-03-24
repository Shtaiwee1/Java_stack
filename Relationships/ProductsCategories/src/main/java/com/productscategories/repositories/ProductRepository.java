package com.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.productscategories.models.Category;
import com.productscategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	//this method retrieves all the books from the database
	List<Product> findAll();
	//Retrieves a list of any products that doesn't belong to a particular repository particular category
    
	List<Product> findByCategoriesNotContains(Category category);
	}

