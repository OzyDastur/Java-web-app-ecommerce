package com.concordia.crud.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.concordia.crud.dto.OrderItemDTO;
import com.concordia.crud.dto.ProductDTO;
import com.concordia.crud.model.OrderItem;
import com.concordia.crud.model.Product;
import com.concordia.crud.repository.ProductRepository;
import com.concordia.crud.service.ProductService;
import com.github.dozermapper.core.DozerBeanMapperBuilder;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {

		List<Product> products = new ArrayList<>();
		productRepository.findAll().forEach(products::add);

		return products;
	}

	@Override
	public Product addProduct(Product product) {
//		product.setId(product.getId());
//		product.setName(productDTO.getName());
//		product.setImage(productDTO.getImage());
//		product.setPrice(productDTO.getPrice());
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product, long id) {

		return productRepository.save(product);

	}

	@Override
	public void deleteProduct(long id) {
		productRepository.deleteById(id);

	}

	@Override
	public ProductDTO getProduct(long id) {

		Optional<Product> optional = productRepository.findById(id);
		Product product = null;
		if (optional.isPresent()) {
			product = optional.get();
		} else {
			throw new RuntimeException("Productnot found for id : " + id);
		}

		return productToProductDTO(product);

//		return productRepository.findById(id);

	}

	@Override
	public Page<ProductDTO> findPaginated(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);

		Page<ProductDTO> productDTOs = this.productRepository.findAll(pageable)
				.map((product -> DozerBeanMapperBuilder.buildDefault().map(product, ProductDTO.class)));

		return productDTOs;
	}

	private ProductDTO productToProductDTO(Product product) {

		if (product == null) {
			return null;
		}

		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setImage(product.getImage());
		productDTO.setPrice(product.getPrice());

		return productDTO;
	}

}