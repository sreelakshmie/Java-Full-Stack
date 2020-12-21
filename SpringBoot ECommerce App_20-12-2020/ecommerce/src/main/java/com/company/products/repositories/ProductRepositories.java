package com.company.products.repositories;
import com.company.products.entities.Products;
import org.springframework.data.repository.CrudRepository;

//Products here is the java class
public interface ProductRepositories extends CrudRepository<Products, Integer> {
	
	

}
