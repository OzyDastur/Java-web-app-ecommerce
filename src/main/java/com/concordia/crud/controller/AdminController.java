package com.concordia.crud.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.concordia.crud.model.Admin;
import com.concordia.crud.service.AdminService;

@Controller
public class AdminController {
	
	
	@Autowired
	private AdminService adminService;

	@RequestMapping(path = "/admin", method = RequestMethod.GET)
	public String getAllProducts(Model model) {
		return getPaginated(1,model);
// 		Modified for pagination and sorting
//		List<Product> products = productService.getAllProducts();
//		model.addAttribute("products", products);
//		return "product";


		
	}

	// new is what will appear in the URL in the browsers
	@RequestMapping(path = "/newAdmin", method = RequestMethod.GET)
	public String newProduct(Model model) {

		Admin productAdmin = new Admin();
		model.addAttribute("productAdmin", productAdmin);

		// This's the file name to be created
		return "new_productAdmin";
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute(name="productAdmin") Admin productAdmin,
			@RequestParam("fileImage") MultipartFile multipartFile ) throws IOException {
		
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		
		productAdmin.setImage(fileName);
		
		
		Admin savedProduct = adminService.addProduct(productAdmin);
		String uploadDir = "./productAdmin-images/" + savedProduct.getId();
		Path uploadPath = Paths.get(uploadDir);
		
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		try(InputStream inputStream = multipartFile.getInputStream()){
			Path filePath = uploadPath.resolve(fileName);
			System.out.println(filePath.toFile().getAbsolutePath());
			Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
		}
		catch(IOException e) {
			throw new IOException("could not save upload file:"+fileName);
		}
		
		

		return "redirect:/admin";
	}

	@RequestMapping(path = "/update/{id}", method = RequestMethod.GET)
	public String getProduct(@PathVariable(name = "id") long id, Model model) {

		Optional<Admin> productAdmin = adminService.getProduct(id);
		model.addAttribute("productAdmin", productAdmin);

		return "edit_productAdmin";
	}

	@RequestMapping(path = "/remove/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable(name = "id") long id) {
		adminService.deleteProduct(id);

		return "redirect:/admin";
	}
	
	@GetMapping("/pageAdmin/{pageNumberAdmin}")
	public String getPaginated(@PathVariable (value ="pageNumberAdmin") int pageNumber, Model model) {
		
		int pageSize = 4;
		
		Page<Admin> page = adminService.getPaginated(pageNumber, pageSize);
		
		List<Admin> productsAdmin = page.getContent();
		
		model.addAttribute("currentPageAdmin", pageNumber);
		model.addAttribute("totalPagesAdmin", page.getTotalPages());
		model.addAttribute("totalItemsAdmin", page.getTotalElements());
		model.addAttribute("productsAdmin", productsAdmin);
		return "admin";
	}


}
