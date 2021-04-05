package com.concordia.crud.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.concordia.crud.dto.CartDTO;
import com.concordia.crud.model.Cart;
import com.concordia.crud.repository.CartRepository;
import com.concordia.crud.service.CartService;

/**
 * Cart Service Implementation
 *
 * @author Alexis
 *
 */

@Service
public class CartServiceImp implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Override
	public CartDTO getCart(Long id) {
		Optional<Cart> optional = cartRepository.findById(id);
		Cart cart = null;
		if (optional.isPresent()) {
			cart = optional.get();
		} else {
			throw new RuntimeException("Cart not found for id : " + id);
		}

		return cartToCartDTO(cart);
	}

	@Override
	@Transactional
	public void saveCart(CartDTO cartDTO) {
		Cart cart = new Cart();
		cart.setId(cartDTO.getId());
		cart.setName(cartDTO.getFirstname());
		cart.setLastName(cartDTO.getLastname());
		cart.setEmailAddress(cartDTO.getEmail());
		cart.setUserCity(cartDTO.getCity());
		cart.setUserProvince(cartDTO.getProvince());
		cart.setUserCountry(cartDTO.getCountry());
		cart.setMobileNumber(cartDTO.getMobile());
		cart.setUserCreated(cartDTO.getCreatedAt());
		cart.setUserUpdated(cartDTO.getUpdatedAt());
		cartRepository.save(cart);

	}

	@Override
	@Transactional
	public void deleteCart(Long id) {
		cartRepository.deleteById(id);

	}

	@Override
	@Transactional
	public void updateCart(CartDTO cartDTO) {
		Optional<Cart> optional = cartRepository.findById(cartDTO.getId());
		Cart cart = null;
		if (optional.isPresent()) {
			cart = optional.get();
		} else {
			throw new RuntimeException("Cart not found for id : " + cartDTO.getId());
		}
		cart.setId(cartDTO.getId());
		cart.setName(cartDTO.getFirstname());
		cart.setLastName(cartDTO.getLastname());
		cart.setEmailAddress(cartDTO.getEmail());
		cart.setUserCity(cartDTO.getCity());
		cart.setUserProvince(cartDTO.getProvince());
		cart.setUserCountry(cartDTO.getCountry());
		cart.setMobileNumber(cartDTO.getMobile());
		cart.setUserCreated(cartDTO.getCreatedAt());
		cart.setUserUpdated(cartDTO.getUpdatedAt());
		cartRepository.save(cart);
	}

	private CartDTO cartToCartDTO(Cart cart) {

		if (cart == null) {
			return null;
		}

		CartDTO cartDTO = new CartDTO();
		cartDTO.setId(cart.getId());
		cartDTO.setFirstname(cart.getName());
		cartDTO.setLastname(cart.getLastName());
		cartDTO.setEmail(cart.getEmailAddress());
		cartDTO.setCity(cart.getUserCity());
		cartDTO.setProvince(cart.getUserProvince());
		cartDTO.setCountry(cart.getUserCountry());
		cartDTO.setMobile(cart.getMobileNumber());
		cartDTO.setCreatedAt(cart.getUserCreated());
		cartDTO.setUpdatedAt(cart.getUserUpdated());

		return cartDTO;
	}

}
