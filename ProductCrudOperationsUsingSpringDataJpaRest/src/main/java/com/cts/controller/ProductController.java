package com.cts.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exceptions.ProductNotFound;
import com.cts.model.Product;
import com.cts.service.ProductService;
 
@RestController
@RequestMapping("/products") // http://localhost:1110/products
public class ProductController {
	@Autowired //to get the obj that is created
	ProductService service;
	
	// @RequestMapping(value="/getMsg".method=RequestMethod.GET)
	@GetMapping("/getMsg") // http://localhost:1110/products/getMsg
	public String sayHello() {
		return "wow !!!!";
	}
 
	@PostMapping("/saveproduct") // http://localhost:1110/products/saveproduct
	public String insertProduct(@RequestBody @Validated Product product) {
		return service.saveProduct(product);
	}
	@PutMapping("/updateproduct") // http://localhost:1110/products/updateproduct
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	@GetMapping("/getproduct/{pid}") // http://localhost:1110/products/getproduct/1
	public Product fetchProduct(@PathVariable("pid") int productId) throws ProductNotFound {
		return service.getProduct(productId);
	}
	@DeleteMapping("/deleteproduct/{pid}") // http://localhost:1110/products/deleteproduct/1
	public String removeProduct(@PathVariable("pid") int productId) {
		return service.removeProduct(productId);
	}
	@GetMapping("/getallproducts") // http://localhost:1110/products/getallproduct
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}
	@GetMapping("/getallproductsbetween/{price1}{price2}") // http://localhost:1110/products/getproduct/1
	public List<Product> getAllProductPriceBetween(@PathVariable("price1") int initialPrice,@PathVariable("price2") int finalPrice) {
		return service.findByProductPriceBetween(initialPrice,finalPrice);
	}
	@GetMapping("/getallproductsbycategory/{category}") // http://localhost:1110/products/getallproductsbycategory/electronics
	public List<Product> fetchProductByCategory(@PathVariable("category") String category) {
		return service.findByProductCategory(category);
	}
//	@ExceptionHandler(exception = ProductNotFound.class,produces = "Product Id Is Invalid")
//	public void handleProductNotFound()
//	{
//		
//	}
}