package com.concordia.crud.dto;

import java.io.Serializable;

import javax.persistence.Transient;

public class ProductDTO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private double price;
	private String image;

	public ProductDTO() {

	}

	public ProductDTO(String image, String name, Double price) {
		super();
		this.name = name;
		this.price = price;
		this.image = image;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the productName
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param productname the productName to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the productPrice
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param productprice the productPrice to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	@Transient
	public String getImageImagePath() {
		if (image == null)
			return null;

		return "/product-images/" + id + "/" + image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDTO other = (ProductDTO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}
