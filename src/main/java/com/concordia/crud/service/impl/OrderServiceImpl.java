package com.concordia.crud.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.concordia.crud.dto.OrderDTO;
import com.concordia.crud.model.Order;
import com.concordia.crud.repository.OrderRepository;
import com.concordia.crud.service.OrderService;

/**
 * Order Service Implementation
 *
 * @author Alexis
 *
 */

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public OrderDTO getOrder(Long id) {
		Optional<Order> optional = orderRepository.findById(id);
		Order order = null;
		if (optional.isPresent()) {
			order = optional.get();
		} else {
			throw new RuntimeException("Order not found for id : " + id);
		}

		return orderToOrderDTO(order);
	}

	@Override
	@Transactional
	public void saveOrder(OrderDTO orderDTO) {
		Order order = new Order();
		order.setId(orderDTO.getId());
		order.setName(orderDTO.getFirstname());
		order.setLastName(orderDTO.getLastname());
		order.setMiddleName(orderDTO.getMiddlename());
		order.setEmailAddress(orderDTO.getMiddlename());
		order.setUserCity(orderDTO.getCity());
		order.setUserProvince(orderDTO.getProvince());
		order.setUserCountry(orderDTO.getCountry());
		order.setMobileNumber(orderDTO.getMobile());
		order.setUserStatus(orderDTO.getStatus());
		order.setUserTax(orderDTO.getTax());
		order.setUserTotal(orderDTO.getTotal());
		order.setUserCreated(orderDTO.getCreatedAt());
		order.setUserUpdated(orderDTO.getUpdatedAt());
		orderRepository.save(order);
	}

	@Override
	@Transactional
	public void deleteOrder(Long id) {

		orderRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void updateOrder(OrderDTO orderDTO) {
		Optional<Order> optional = orderRepository.findById(orderDTO.getId());
		Order order = null;
		if (optional.isPresent()) {
			order = optional.get();
		} else {
			throw new RuntimeException("Order not found for id : " + orderDTO.getId());
		}
		order.setId(orderDTO.getId());
		order.setName(orderDTO.getFirstname());
		order.setLastName(orderDTO.getLastname());
		order.setMiddleName(orderDTO.getMiddlename());
		order.setEmailAddress(orderDTO.getEmail());
		order.setUserCity(orderDTO.getCity());
		order.setUserProvince(orderDTO.getProvince());
		order.setUserCountry(orderDTO.getCountry());
		order.setMobileNumber(orderDTO.getMobile());
		order.setUserStatus(orderDTO.getStatus());
		order.setUserTax(orderDTO.getTax());
		order.setUserTotal(orderDTO.getTotal());
		order.setUserCreated(orderDTO.getCreatedAt());
		order.setUserUpdated(orderDTO.getUpdatedAt());
		orderRepository.save(order);
	}
	
	private OrderDTO orderToOrderDTO(Order order) {

		if (order == null) {
			return null;
		}

		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setId(order.getId());
		orderDTO.setFirstname(order.getName());
		orderDTO.setLastname(order.getLastName());
		orderDTO.setMiddlename(order.getMiddleName());
		orderDTO.setEmail(order.getEmailAddress());
		orderDTO.setCity(order.getUserCity());
		orderDTO.setProvince(order.getUserProvince());
		orderDTO.setCountry(order.getUserCountry());
		orderDTO.setMobile(order.getMobileNumber());
		orderDTO.setStatus(order.getUserStatus());
		orderDTO.setTax(order.getUserTax());
		orderDTO.setTotal(order.getUserTotal());
		orderDTO.setCreatedAt(order.getUserCreated());
		orderDTO.setUpdatedAt(order.getUserUpdated());

		return orderDTO;
	}
	

	


}
