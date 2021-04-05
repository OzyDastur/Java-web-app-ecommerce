package com.concordia.crud.repository;

import org.springframework.stereotype.Repository;
import com.concordia.crud.model.OrderItem;

/**
 * Order Item Repository
 *
 * @author Alexis
 *
 */

@Repository
public interface OrderItemRepository  extends org.springframework.data.jpa.repository.JpaRepository<OrderItem, Long> {

	

	

}
