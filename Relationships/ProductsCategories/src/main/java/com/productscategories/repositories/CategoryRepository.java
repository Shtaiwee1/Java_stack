package com.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.productscategories.models.Category;
import com.productscategories.models.Product;



@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	// this method retrieves all the books from the database
    List<Category> findAll();
    //this method returns a list of categories that a particular product doesn't belong to
    List<Category> findByProductsNotContains(Product product);

}



	
	

