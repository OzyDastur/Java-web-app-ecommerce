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

import com.concordia.crud.dto.CartItemDTO;
import com.concordia.crud.model.CartItem;
import com.concordia.crud.repository.CartItemRepository;
import com.concordia.crud.service.CartItemService;
import com.github.dozermapper.core.DozerBeanMapperBuilder;

/**
 * Cart Item Service Implementation
 *
 * @author Alexis
 *
 */

@Service
public class CartItemServiceImp implements CartItemService {

	@Autowired
	private CartItemRepository cartItemRepository;

	@Override
	public CartItemDTO getCartItem(Long id) {
		Optional<CartItem> optional = cartItemRepository.findById(id);
		CartItem cartItem = null;
		if (optional.isPresent()) {
			cartItem = optional.get();
		} else {
			throw new RuntimeException("Cart Item not found for id : " + id);
		}

		return cartItemToCartItemDTO(cartItem);
	}

	@Override
	@Transactional
	public void saveCartItem(CartItemDTO cartItemDTO) {
		CartItem cartItem = new CartItem();
		cartItem.setId(cartItemDTO.getId());
		cartItem.setPrice(cartItemDTO.getPrice());
		cartItem.setDiscount(cartItemDTO.getDiscount());
		cartItem.setQuantity(cartItemDTO.getQuantity());
		cartItem.setActiveState(cartItemDTO.getActive());
		cartItem.setSku(cartItemDTO.getSku());
		cartItem.setUserCreated(cartItemDTO.getCreatedAt());
		cartItem.setUserUpdated(cartItemDTO.getUpdatedAt());
		cartItemRepository.save(cartItem);
	}

	@Override
	@Transactional
	public void deleteCartItem(Long id) {
		cartItemRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void updateCartItem(CartItemDTO cartItemDTO) {
		Optional<CartItem> optional = cartItemRepository.findById(cartItemDTO.getId());
		CartItem cartItem = null;
		if (optional.isPresent()) {
			cartItem = optional.get();
		} else {
			throw new RuntimeException("Cart Item not found for id : " + cartItemDTO.getId());
		}
		cartItem.setId(cartItemDTO.getId());
		cartItem.setPrice(cartItemDTO.getPrice());
		cartItem.setDiscount(cartItemDTO.getDiscount());
		cartItem.setQuantity(cartItemDTO.getQuantity());
		cartItem.setActiveState(cartItemDTO.getActive());
		cartItem.setSku(cartItemDTO.getSku());
		cartItem.setUserCreated(cartItemDTO.getCreatedAt());
		cartItem.setUserUpdated(cartItemDTO.getUpdatedAt());
		cartItemRepository.save(cartItem);
	}

	@Override
	public List<CartItemDTO> getAllCartItems() {
		List<CartItem> cartItems = this.cartItemRepository.findAll();
		
		List<CartItemDTO> cartItemDTOs = new ArrayList<CartItemDTO>(cartItems.size());
        for (CartItem cartItem : cartItems) {
        	cartItemDTOs.add(cartItemToCartItemDTO(cartItem));
        }
        
        return cartItemDTOs;
	}

	@Override
	public Page<CartItemDTO> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);

		Page<CartItemDTO> cartItemDTOs = this.cartItemRepository.findAll(pageable)
				.map((cartItem -> DozerBeanMapperBuilder.buildDefault().map(cartItem, CartItemDTO.class)));

		return cartItemDTOs;
	}

	private CartItemDTO cartItemToCartItemDTO(CartItem cartItem) {

		if (cartItem == null) {
			return null;
		}

		CartItemDTO cartItemDTO = new CartItemDTO();
		cartItemDTO.setId(cartItem.getId());
		cartItemDTO.setPrice(cartItem.getPrice());
		cartItemDTO.setDiscount(cartItem.getDiscount());
		cartItemDTO.setQuantity(cartItem.getQuantity());
		cartItemDTO.setActive(cartItem.getActiveState());
		cartItemDTO.setSku(cartItem.getSku());
		cartItemDTO.setCreatedAt(cartItem.getUserCreated());
		cartItemDTO.setUpdatedAt(cartItem.getUserUpdated());

		return cartItemDTO;
	}

}
