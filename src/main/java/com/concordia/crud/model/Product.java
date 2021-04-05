package com.concordia.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="product")
public class Product {
	
	
	private long id;
	private String name;
	private double price;
	private String image;
	
	public Product() {
		
	}
	
	public Product(String image, String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public void setId(long id) {
		this.id = id;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	public long getId() {
		return id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="price")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Column(length=45)
	 
	public String getImage() {
		return image;
	}
	

	public void setImage(String image) {
		this.image = image;
	}
	
	@Transient
	public String getImageImagePath() {
		if(image == null ) return null;
		
		return "/product-images/" + id + "/" + image;
	}




//	
//    @Transient
//    public String getImageImagePath1() {
//        if(image == null ) return null;
//       
//        return "/product-images/" + id + "/" + image;
//    }

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + "]";
	}	

}

