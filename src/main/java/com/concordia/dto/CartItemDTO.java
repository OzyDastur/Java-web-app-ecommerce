package com.concordia.dto;

import java.io.Serializable;
import java.sql.Date;


/**
 * Account Data Transfer Object to display information to front-end and to interact with back end.
 *
 * @author Alexis
 *
 */

public class CartItemDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private Float price;
	private Float discount;
	private Integer quantity;
	private Integer active;
	private String sku;
	private Date createdAt;
	private Date updatedAt;

	public CartItemDTO () {
		
	}

	public CartItemDTO(Float price, Float discount, Integer quantity, Integer active, String sku, Date createdAt, Date updatedAt) {
		super();
		this.price = price;
		this.discount = discount;
		this.quantity = quantity;
		this.active = active;
		this.sku = sku;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public Date getCreatedDate() {
		return createdAt;
	}

	public void setCreatedDate(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Date getUpdatedDate() {
		return updatedAt;
	}

	public void setUpdatedDate(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
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
		CartItemDTO other = (CartItemDTO) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CartItemDTO [id=" + id + ", price=" + price + ", discount=" + discount + ", quantity=" + quantity + ", active=" + active + ", sku=" + sku + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt +"]";
	}
}
