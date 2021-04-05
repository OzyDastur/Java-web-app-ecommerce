package com.concordia.crud.repository;

import org.springframework.stereotype.Repository;

import com.concordia.crud.model.ProductReview;

/**
 * Product Review Repository
 *
 * @author Alexis
 *
 */

@Repository
public interface ProductReviewRepository  extends org.springframework.data.jpa.repository.JpaRepository<ProductReview, Long> {

	

	

}
