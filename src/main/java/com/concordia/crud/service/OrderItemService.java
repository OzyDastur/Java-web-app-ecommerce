package com.concordia.crud.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.concordia.crud.dto.OrderItemDTO;

/**
 * Order Item Service Interface
 *
 * @author Alexis
 *
 */

public interface OrderItemService {

	OrderItemDTO getOrderItem(Long id);

	void saveOrderItem(OrderItemDTO orderItemDTO);

	void deleteOrderItem(Long id);

	void updateOrderItem(OrderItemDTO orderItemDTO);

	List<OrderItemDTO> getAllOrderItems();

	Page<OrderItemDTO> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
