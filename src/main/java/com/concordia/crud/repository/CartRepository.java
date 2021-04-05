package com.concordia.crud.repository;

import org.springframework.stereotype.Repository;

import com.concordia.crud.model.Cart;

/**
 * Cart Repository
 *
 * @author Alexis
 *
 */

@Repository
public interface CartRepository  extends org.springframework.data.jpa.repository.JpaRepository<Cart, Long> {

	

	

}
