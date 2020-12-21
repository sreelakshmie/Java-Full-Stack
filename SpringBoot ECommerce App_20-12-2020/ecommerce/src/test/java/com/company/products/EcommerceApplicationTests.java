package com.company.products;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.company.products.entities.Products;
import com.company.products.repositories.ProductRepositories;

@SpringBootTest
class EcommerceApplicationTests {

	@Autowired
	private ProductRepositories productRepo;
	@Test
	public void testCreateProduct() {
		Products products=new Products();
		products.setTitle("Fjallraven");
		products.setCategory("men clothing");
		products.setDescription("Your perfect pack for everyday use");
		products.setPrice(109.95);
		products.setImage("https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg");
		
		productRepo.save(products);
	}
	
	@Test
	public void testFindProductById() {
		Products products=productRepo.findById(2).get();
		System.out.println(products);
	}
	
	@Test
	public void testUpdateProductById() {
		Products products=productRepo.findById(2).get();
		System.out.println(products);
		products.setPrice(167.00);
		productRepo.save(products);
	}
	
	@Test
	public void testDeleteProductById() {
		Products products=productRepo.findById(2).get();
		productRepo.delete(products);
	
	}

}
