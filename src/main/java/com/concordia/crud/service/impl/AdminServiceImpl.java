package com.concordia.crud.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.concordia.crud.model.Admin;
import com.concordia.crud.repository.AdminRepository;
import com.concordia.crud.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	


	@Override
	public List<Admin> getAllProducts() {
		
		List<Admin> products = new ArrayList<>();
		adminRepository.findAll().forEach(products::add);
		
		return products;
	}
	
	@Override
	public Admin addProduct(Admin admin) {
		
		return adminRepository.save(admin);
	}

	@Override
	public Admin updateProduct(Admin admin, long id) {
		
		return adminRepository.save(admin);
		
	}

	@Override
	public void deleteProduct(long id) {
		adminRepository.deleteById(id);
		
	}

	@Override
	public Optional<Admin> getProduct(long id) {
		
		
		return adminRepository.findById(id);
		
//		return productRepository.findById(id);
		
	}

	@Override
	public Page<Admin> getPaginated(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		
		return adminRepository.findAll(pageable);
	}


}
