package com.concordia.dto;

import java.io.Serializable;
import java.sql.Date;


/**
 * Account Data Transfer Object to display information to front-end and to interact with back end.
 *
 * @author Alexis
 *
 */

public class OrderItemDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private Integer productId;
	private Integer orderId;
	private Float price;
	private Integer quantity;
	private String sku;
	private Date createdAt;
	private Date updatedAt;

	public OrderItemDTO () {
		
	}

	public OrderItemDTO(Integer productId, Integer orderId, Float price, Integer quantity, String sku, Date createdAt, Date updatedAt) {
		super();
		this.productId = productId;
		this.orderId = orderId;
		this.price = price;
		this.quantity = quantity;
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
	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
		OrderItemDTO other = (OrderItemDTO) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
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
		return "OrderItemDTO [id=" + id + ", productId=" + productId + ", orderId=" + orderId + ", price=" + price + ", quantity=" + quantity + ", sku=" + sku + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt +"]";
	}
}
