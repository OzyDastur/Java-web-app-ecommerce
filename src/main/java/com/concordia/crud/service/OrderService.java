package com.concordia.crud.service;

import com.concordia.crud.dto.OrderDTO;

/**
 * Order Service Interface
 *
 * @author Alexis
 *
 */

public interface OrderService {

	OrderDTO getOrder(Long id);

	void saveOrder(OrderDTO orderDTO);

	void deleteOrder(Long id);

	void updateOrder(OrderDTO orderDTO);

}
