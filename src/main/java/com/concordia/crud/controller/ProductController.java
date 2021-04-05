package com.concordia.crud.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

import com.concordia.crud.dto.ProductDTO;
import com.concordia.crud.model.Product;
import com.concordia.crud.repository.ProductRepository;
import com.concordia.crud.service.ProductService;
import com.concordia.email.impl.EmailServiceImpl;



@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(path = "/product", method = RequestMethod.GET)
	public String getAllProducts(Model model) {
		return findPaginated(1,model);
// 		Modified for pagination and sorting
//		List<Product> products = productService.getAllProducts();
//		model.addAttribute("products", products);
//		return "product";


		
	}

	// new is what will appear in the URL in the browsers
	@RequestMapping(path = "/new", method = RequestMethod.GET)
	public String newProduct(Model model) {

		ProductDTO productDTO = new ProductDTO();
		model.addAttribute("product", productDTO);

		// This's the file name to be created
		return "new_product";
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute(name="product") Product product,
			@RequestParam("fileImage") MultipartFile multipartFile ) throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		product.setImage(fileName);
		Product savedProduct = productService.addProduct(product);
		String uploadDir = "./product-images/" + savedProduct.getId();
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
		
		

		return "redirect:/product-page";
	}

	@RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
	public String getProduct(@PathVariable(name = "id") long id, Model model) {

		ProductDTO product = productService.getProduct(id);
		model.addAttribute("product", product);

		return "edit_product";
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable(name = "id") long id) {
		productService.deleteProduct(id);

		return "redirect:/product-page";
	}
	
	@GetMapping("/page/{pageNumber}")
	public String findPaginated(@PathVariable (value ="pageNumber") int pageNumber, Model model) {
		
		int pageSize = 9;
		
		Page<ProductDTO> page = productService.findPaginated(pageNumber, pageSize);
		
		List<ProductDTO> products = page.getContent();
		
		model.addAttribute("currentPage", pageNumber);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("products", products);
		return "product-page";
	}
	
	@RequestMapping(path="/purchase", method = RequestMethod.GET)
	public String thankYou() throws Exception {
		
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
	        EmailServiceImpl email = (EmailServiceImpl) context.getBean("emailServiceImpl");
	        String senderEmailId = "abwab.kheyr@gmail.com";
	        String receiverEmailId = "abwab.kheyr@gmail.com";
	        String subject = "Ecommerce Website Alert";
	        String message = "Thank you for shopping with us today?";
	        email.sendEmail(senderEmailId, receiverEmailId, subject, message);
		
	        return "purchase";
	}

}

