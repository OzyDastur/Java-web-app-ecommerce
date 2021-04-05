package com.concordia.crud.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class AdminConfiguration implements WebMvcConfigurer  {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		Path productUploadDir = Paths.get("./productAdmin-images");
		String productUploadPath = productUploadDir.toFile().getAbsolutePath();		
		registry.addResourceHandler("/productAdmin-images/**").addResourceLocations("file:/"+productUploadPath + "/");
	}

}
