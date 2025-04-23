package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	public abstract List<Product> findByProductPriceBetween(int intialPrice, int finalPrice);
	 
	public abstract List<Product> findByProductCategory(String category);
	
	public abstract List<Product> findByProductPriceGreaterThan(int price);
 
//	@Query("select p from Product p where p.productPrice between ?1 and ?2")
//	public abstract List<Product> getAllProductsBetween(int intialPrice, int finalPrice);
 
//	@Query("select p from Product p where p.productCategory=?1")
//	public abstract List<Product> getAllProductsByCategory(String category);
	
//public abstract List<Product> getProductsGreaterThanGivenPrice(int givenPrice);

}








/*public abstract String saveProduct(Product product);//save

public abstract String updateProduct(Product product);//save (for both save n insert)

public abstract String removeProduct(int productId); /delete

public abstract Product getProduct(int productId);//findById

public abstract List<Product> getAllProducts();//findAll */