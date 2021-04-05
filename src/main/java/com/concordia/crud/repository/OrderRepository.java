package com.concordia.crud.repository;

import org.springframework.stereotype.Repository;
import com.concordia.crud.model.Order;

/**
 * Order Repository
 *
 * @author Alexis
 *
 */

@Repository
public interface OrderRepository  extends org.springframework.data.jpa.repository.JpaRepository<Order, Long> {

	

	

}
