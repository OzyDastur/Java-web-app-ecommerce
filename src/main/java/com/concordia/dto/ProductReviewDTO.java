package com.concordia.dto;

import java.io.Serializable;
import java.sql.Date;


/**
 * Account Data Transfer Object to display information to front-end and to interact with back end.
 *
 * @author Alexis
 *
 */

public class ProductReviewDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private Integer productId;
	private Integer parentId;
	private String title;
	private Integer rating;
	private Integer published;
	private Date createdAt;
	private Date publishedAt;

	public ProductReviewDTO () {
		
	}

	public ProductReviewDTO(Integer productId, Integer parentId, String title, Integer rating, Integer published, Date createdAt, Date publishedAt) {
		super();
		this.productId = productId;
		this.parentId = parentId;
		this.title = title;
		this.rating = rating;
		this.published = published;
		this.createdAt = createdAt;
		this.publishedAt = publishedAt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public int getPublished() {
		return published;
	}

	public void setPublished(int published) {
		this.published = published;
	}
	
	public Date getCreatedDate() {
		return createdAt;
	}

	public void setCreatedDate(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Date getPublishedDate() {
		return publishedAt;
	}

	public void setPublished(Date publishedAt) {
		this.publishedAt = publishedAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((published == null) ? 0 : published.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((publishedAt == null) ? 0 : publishedAt.hashCode());
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
		ProductReviewDTO other = (ProductReviewDTO) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (publishedAt == null) {
			if (other.publishedAt != null)
				return false;
		} else if (!publishedAt.equals(other.publishedAt))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (published == null) {
			if (other.published != null)
				return false;
		} else if (!published.equals(other.published))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductReviewDTO [id=" + id + ", productId=" + productId + ", parentId=" + parentId + ", title=" + title + ", rating=" + rating + ", published=" + published + ", createdAt=" + createdAt + ", publishedAt=" + publishedAt + "]";
	}
}
