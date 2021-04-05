package com.concordia.crud.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.concordia.crud.dto.ProductReviewDTO;
import com.concordia.crud.model.ProductReview;
import com.concordia.crud.repository.ProductReviewRepository;
import com.concordia.crud.service.ProductReviewService;
import com.github.dozermapper.core.DozerBeanMapperBuilder;

/**
 * Product Review Service Implementation
 *
 * @author Alexis
 *
 */

@Service
public class ProductReviewServiceImp implements ProductReviewService {

	@Autowired
	private ProductReviewRepository productReviewRepository;

	@Override
	public ProductReviewDTO getProductReview(Long id) {
		Optional<ProductReview> optional = productReviewRepository.findById(id);
		ProductReview productReview = null;
		if (optional.isPresent()) {
			productReview = optional.get();
		} else {
			throw new RuntimeException("Product Review not found for id : " + id);
		}

		return productReviewToProductReviewDTO(productReview);
	}

	@Override
	@Transactional
	public void saveProductReview(ProductReviewDTO productReviewDTO) {
		ProductReview productReview = new ProductReview();
		productReview.setId(productReviewDTO.getId());
		productReview.setParentId(productReviewDTO.getParentId());
		productReview.setPublished(productReviewDTO.getPublished());
		productReview.setPublishedDate(productReviewDTO.getPublishedAt());
		productReview.setRating(productReviewDTO.getRating());
		productReview.setTitle(productReviewDTO.getTitle());
		productReview.setUserCreated(productReviewDTO.getCreatedAt());
		productReviewRepository.save(productReview);

	}

	@Override
	@Transactional
	public void deleteProductReview(Long id) {
		productReviewRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void updateProductReview(ProductReviewDTO productReviewDTO) {
		Optional<ProductReview> optional = productReviewRepository.findById(productReviewDTO.getId());
		ProductReview productReview = null;
		if (optional.isPresent()) {
			productReview = optional.get();
		} else {
			throw new RuntimeException("Product Review not found for id : " + productReviewDTO.getId());
		}
		productReview.setId(productReviewDTO.getId());
		productReview.setParentId(productReviewDTO.getParentId());
		productReview.setPublished(productReviewDTO.getPublished());
		productReview.setPublishedDate(productReviewDTO.getPublishedAt());
		productReview.setRating(productReviewDTO.getRating());
		productReview.setTitle(productReviewDTO.getTitle());
		productReview.setUserCreated(productReviewDTO.getCreatedAt());
		productReviewRepository.save(productReview);

	}

	@Override
	public List<ProductReviewDTO> getAllProductReviews() {
		List<ProductReview> productReviews = this.productReviewRepository.findAll();

		List<ProductReviewDTO> productReviewDTOs = new ArrayList<ProductReviewDTO>(productReviews.size());
		for (ProductReview productReview : productReviews) {
			productReviewDTOs.add(productReviewToProductReviewDTO(productReview));
		}

		return productReviewDTOs;
	}

	@Override
	public Page<ProductReviewDTO> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);

		Page<ProductReviewDTO> productReviewDTOs = this.productReviewRepository.findAll(pageable)
				.map((productReview -> DozerBeanMapperBuilder.buildDefault().map(productReview, ProductReviewDTO.class)));

		return productReviewDTOs;
	}

	private ProductReviewDTO productReviewToProductReviewDTO(ProductReview productReview) {

		if (productReview == null) {
			return null;
		}

		ProductReviewDTO productReviewDTO = new ProductReviewDTO();
		productReviewDTO.setId(productReview.getId());
		productReviewDTO.setParentId(productReview.getParentId());
		productReviewDTO.setPublished(productReview.getPublished());
		productReviewDTO.setPublishedAt(productReview.getPublishedDate());
		productReviewDTO.setRating(productReview.getRating());
		productReviewDTO.setTitle(productReview.getTitle());
		productReviewDTO.setCreatedAt(productReview.getUserCreated());

		return productReviewDTO;
	}

}
