package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.exceptions.ProductNotFound;
import com.cts.model.Product;
import com.cts.repository.ProductRepository;
//import com.cts.repository.ProductRepositoryImpl;
@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	Logger log= LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	ProductRepository repository;
	
//	public ProductServiceImpl() {
//		repository=new ProductRepositoryImpl();
//	}
	@Override
	public String saveProduct(Product product) {
		log.info("In ProductServiceImpl saveproduct method....");
		Product pro= repository.save(product);
		if(pro != null)
			return "Product saved successfully";
		else
			return "Something went wrong";
	}

	@Override
	public Product updateProduct(Product product) {		 		
		return repository.save(product);
	}

	@Override
	public String removeProduct(int productId) {
		repository.deleteById(productId);		
		return "Product deleted";
	}

	@Override
	public Product getProduct(int productId) throws ProductNotFound {
		Optional<Product> optional = repository.findById(productId);
		if(optional.isPresent())
			return optional.get();
		else
			throw new ProductNotFound("Product Id is invalid...");
		
	}

	@Override
	public List<Product> getAllProducts() {		
		return repository.findAll();
	}

	@Override
	public List<Product> findByProductPriceBetween(int initialPrice, int finalPrice) {
		
		return repository.findByProductPriceBetween(initialPrice, finalPrice);
	}

	@Override
	public List<Product> findByProductCategory(String category) {
		return repository.findByProductCategory(category);
	}
	@Override
	public List<Product> findByProductPriceGreaterThan(int givenPrice) {		
		return repository.findByProductPriceGreaterThan(givenPrice);
	}

}
