package com.cts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@Column(name = "pid")
	@GeneratedValue
	private int productId;
	@NotBlank(message="ProductName can't be NULLL or BLANK")
	private String productName;
	@Column(name = "price")
	@Min(value=100,message="Product Price must be above 100")
	@Max(value=100000,message="Product price can't be above 1 lakh")
	private int productPrice;
	@Size(min=5,max=12,message="Category length must be between 5 and 12")
	private String productCategory;
	@Column(name = "quantity", length = 8)
	@Positive(message="Quantity can't be -ve")
	private int productQuantity;

		public Product(String productName, int productPrice, String productCategory , int productQuantity) {
			super();
			this.productName = productName;
			this.productPrice= productPrice;
			this.productCategory = productCategory;
			this.productQuantity = productQuantity;
		}
	
//		public Product() {
//			
//		}
	
	
 
}
