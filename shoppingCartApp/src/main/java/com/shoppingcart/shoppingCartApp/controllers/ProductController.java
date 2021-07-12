package com.shoppingcart.shoppingCartApp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.shoppingCartApp.entity.Product;
import com.shoppingcart.shoppingCartApp.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@PostMapping("/products")
	public Product saveProduct(@Valid @RequestBody Product productObj) {
		LOGGER.info("Inside Post Mapping Method");
		return productService.saveProduct(productObj);
	}

	@GetMapping("/products")
	public List<Product> getAllProducts() {

		List<Product> listProducts = productService.getAllProducts();
		return listProducts;
	}

	@GetMapping("/products/{productId}")
	public Product getProductbyId(@PathVariable("productId") Long productId) {
		LOGGER.info("Inside Get Mapping Method");
		return productService.getProductbyId(productId);

	}

	@PutMapping("/products/{productId}")
	public Product updateProductById(@PathVariable("productId") Long productId, @RequestBody Product productObj) {
		return productService.updateProductById(productId, productObj);

	}

	@PatchMapping("/products/{productId}")
	public Product updateProductByIdbyPatch(@PathVariable("productId") Long productId,
			@RequestBody Product productObj) {
		return productService.updateProductByIdbyPatch(productId, productObj);

	}

	@DeleteMapping("/products/{productId}")
	public String deleteProductbyId(@PathVariable("productId") Long productId) {
		productService.deleteProductbyId(productId);
		return "Deleted Successfully";

	}

}