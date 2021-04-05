package com.concordia.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.concordia.crud.dto.ProductDTO;
import com.concordia.crud.model.Product;

public interface ProductService {

	void deleteProduct(long id);

	List<Product> getAllProducts();

	Product updateProduct(Product product, long id);

	ProductDTO getProduct(long id);

	// Pagination and sorting
	Page<ProductDTO> findPaginated(int pageNumber, int pageSize);

	Product addProduct(Product product);

}
