package com.shoppingcart.shoppingCartApp.service;

import java.util.List;

import com.shoppingcart.shoppingCartApp.entity.Product;

public interface ProductService {

	public Product saveProduct(Product productObj);

	public List<Product> getAllProducts();

	public Product getProductbyId(Long productId);

	public Product updateProductById(Long productId, Product productObj);

	public Product updateProductByIdbyPatch(Long productId, Product productObj);

	public void deleteProductbyId(Long productId);

}
