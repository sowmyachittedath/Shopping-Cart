package com.shoppingcart.shoppingCartApp.serviceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.shoppingCartApp.entity.Product;
import com.shoppingcart.shoppingCartApp.repository.ProductRepository;
import com.shoppingcart.shoppingCartApp.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Override
	public Product saveProduct(Product productObj) {
		return productRepo.save(productObj);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductbyId(Long productId) {

		return productRepo.findById(productId).get();

	}

	@Override
	public Product updateProductById(Long productId, Product productObj) {
		Product product = productRepo.findById(productId).get();

		if (Objects.nonNull(productObj.getProductName()) && !"".equalsIgnoreCase(productObj.getProductName())) {
			product.setProductName(productObj.getProductName());
		}

		if (Objects.nonNull(productObj.getProductDescription())
				&& !"".equalsIgnoreCase(productObj.getProductDescription())) {
			product.setProductDescription(productObj.getProductDescription());
		}

		if (Objects.nonNull(productObj.getProductCode()) && !"".equalsIgnoreCase(productObj.getProductCode())) {
			product.setProductCode(productObj.getProductCode());
		}

		return productRepo.save(product);
	}

	@Override
	public Product updateProductByIdbyPatch(Long productId, Product productObj) {
		Product product = productRepo.findById(productId).get();

		if (Objects.nonNull(productObj.getProductName()) && !"".equalsIgnoreCase(productObj.getProductName())) {
			product.setProductName(productObj.getProductName());
		}

		if (Objects.nonNull(productObj.getProductDescription())
				&& !"".equalsIgnoreCase(productObj.getProductDescription())) {
			product.setProductDescription(productObj.getProductDescription());
		}

		if (Objects.nonNull(productObj.getProductCode()) && !"".equalsIgnoreCase(productObj.getProductCode())) {
			product.setProductCode(productObj.getProductCode());
		}

		return productRepo.save(product);
	}

	@Override
	public void deleteProductbyId(Long productId) {
		productRepo.deleteById(productId);

	}

}
