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

import com.concordia.crud.dto.OrderItemDTO;
import com.concordia.crud.model.OrderItem;
import com.concordia.crud.repository.OrderItemRepository;
import com.concordia.crud.service.OrderItemService;
import com.github.dozermapper.core.DozerBeanMapperBuilder;

/**
 * Order Item Service Implementation
 *
 * @author Alexis
 *
 */

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public OrderItemDTO getOrderItem(Long id) {
		Optional<OrderItem> optional = orderItemRepository.findById(id);
		OrderItem orderItem = null;
		if (optional.isPresent()) {
			orderItem = optional.get();
		} else {
			throw new RuntimeException("Order Item not found for id : " + id);
		}

		return orderItemToOrderItemDTO(orderItem);
	}

	@Override
	@Transactional
	public void saveOrderItem(OrderItemDTO orderItemDTO) {
		OrderItem orderItem = new OrderItem();
		orderItem.setId(orderItemDTO.getId());
		orderItem.setPrice(orderItemDTO.getPrice());
		orderItem.setQuantity(orderItemDTO.getQuantity());
		orderItem.setSku(orderItemDTO.getSku());
		orderItem.setUserCreated(orderItemDTO.getCreatedAt());
		orderItem.setUserUpdated(orderItemDTO.getUpdatedAt());
		orderItemRepository.save(orderItem);

	}

	@Override
	@Transactional
	public void deleteOrderItem(Long id) {
		orderItemRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void updateOrderItem(OrderItemDTO orderItemDTO) {
		Optional<OrderItem> optional = orderItemRepository.findById(orderItemDTO.getId());
		OrderItem orderItem = null;
		if (optional.isPresent()) {
			orderItem = optional.get();
		} else {
			throw new RuntimeException("Order Item not found for id : " + orderItemDTO.getId());
		}
		
		orderItem.setId(orderItemDTO.getId());
		orderItem.setPrice(orderItemDTO.getPrice());
		orderItem.setQuantity(orderItemDTO.getQuantity());
		orderItem.setSku(orderItemDTO.getSku());
		orderItem.setUserCreated(orderItemDTO.getCreatedAt());
		orderItem.setUserUpdated(orderItemDTO.getUpdatedAt());
		orderItemRepository.save(orderItem);

	}

	@Override
	public List<OrderItemDTO> getAllOrderItems() {
		List<OrderItem> orderItems = this.orderItemRepository.findAll();
		
		List<OrderItemDTO> orderItemDTOs = new ArrayList<OrderItemDTO>(orderItems.size());
        for (OrderItem orderItem : orderItems) {
        	orderItemDTOs.add(orderItemToOrderItemDTO(orderItem));
        }
        
        return orderItemDTOs;
	}

	@Override
	public Page<OrderItemDTO> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);

		Page<OrderItemDTO> orderItemDTOs = this.orderItemRepository.findAll(pageable)
				.map((orderItem -> DozerBeanMapperBuilder.buildDefault().map(orderItem, OrderItemDTO.class)));

		return orderItemDTOs;
	}
	
	private OrderItemDTO orderItemToOrderItemDTO(OrderItem orderItem) {

		if (orderItem == null) {
			return null;
		}

		OrderItemDTO orderItemDTO = new OrderItemDTO();
		orderItemDTO.setId(orderItem.getId());
		orderItemDTO.setPrice(orderItem.getPrice());
		orderItemDTO.setQuantity(orderItem.getQuantity());
		orderItemDTO.setSku(orderItem.getSku());
		orderItemDTO.setCreatedAt(orderItem.getUserCreated());
		orderItemDTO.setUpdatedAt(orderItem.getUserUpdated());

		return orderItemDTO;
	}

}
