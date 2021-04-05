package com.concordia.crud.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.concordia.crud.dto.ProductReviewDTO;

/**
 * Product Review Service Interface
 *
 * @author Alexis
 *
 */

public interface ProductReviewService {

	ProductReviewDTO getProductReview(Long id);

	void saveProductReview(ProductReviewDTO productReviewDTO);

	void deleteProductReview(Long id);

	void updateProductReview(ProductReviewDTO productReviewDTO);

	List<ProductReviewDTO> getAllProductReviews();

	Page<ProductReviewDTO> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);


}
