package com.concordia.crud.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.concordia.crud.dto.CartItemDTO;

/**
 * Cart Item Service Interface
 *
 * @author Alexis
 *
 */

public interface CartItemService {

	CartItemDTO getCartItem(Long id);

	void saveCartItem(CartItemDTO cartItemDTO);

	void deleteCartItem(Long id);

	void updateCartItem(CartItemDTO cartItemDTO);

	List<CartItemDTO> getAllCartItems();

	Page<CartItemDTO> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
