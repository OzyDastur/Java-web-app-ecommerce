package com.concordia.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.concordia.crud.model.Admin;

public interface AdminService {

	List<Admin> getAllProducts();

	Admin addProduct(Admin admin);

	Admin updateProduct(Admin admin, long id);

	void deleteProduct(long id);

	Optional<Admin> getProduct(long id);

	Page<Admin> getPaginated(int pageNumber, int pageSize);

}
