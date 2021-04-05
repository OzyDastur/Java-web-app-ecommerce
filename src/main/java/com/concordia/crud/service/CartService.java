package com.concordia.crud.service;

import com.concordia.crud.dto.CartDTO;

/**
 * Cart Service Interface
 *
 * @author Alexis
 *
 */

public interface CartService {

	CartDTO getCart(Long id);

	void saveCart(CartDTO cartDTO);

	void deleteCart(Long id);

	void updateCart(CartDTO cartDTO);

}
