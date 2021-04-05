package com.concordia.crud.repository;

import org.springframework.stereotype.Repository;

import com.concordia.crud.model.CartItem;

/**
 * Cart Item Repository
 *
 * @author Alexis
 *
 */

@Repository
public interface CartItemRepository  extends org.springframework.data.jpa.repository.JpaRepository<CartItem, Long> {

	

	

}
