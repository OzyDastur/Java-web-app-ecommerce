package com.concordia.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="admin")
public class Admin {
	
	
	private long id;
	private String name;
	private double price;
	private String image;
	
	public Admin() {
		
	}
	
	public Admin(String image, String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="admin_id")
	public long getId() {
		return id;
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
		
		return "/productAdmin-images/" + id + "/" + image;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + "]";
	}

	

}

