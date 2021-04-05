package com.concordia.dto;

import java.io.Serializable;



public class AdminDTO implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private double price;
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
	public String getAdminName() {
		return name;
	}

	/**
	 * @param productname the productName to set
	 */
	public void setAdminName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the productPrice
	 */
	public Double getAdminPrice() {
		return price;
	}

	/**
	 * @param productprice the productPrice to set
	 */
	public void setAdminPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		AdminDTO other = (AdminDTO) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AdminDTO [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}
