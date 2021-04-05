package com.concordia.crud.dto;

import java.io.Serializable;
import java.sql.Date;

public class ProductReviewDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private int productId;
	private int parentId;
	private String title;
	private int rating;
	private int published;
	private Date createdAt;
	private Date publishedAt;

	public ProductReviewDTO() {

	}

	public ProductReviewDTO(int productId, int parentId, String title, int rating, int published, Date createdAt,
			Date publishedAt) {
		super();
		this.productId = productId;
		this.parentId = parentId;
		this.title = title;
		this.rating = rating;
		this.published = published;
		this.createdAt = createdAt;
		this.publishedAt = publishedAt;
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
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the parentId
	 */
	public int getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * @return the published
	 */
	public int getPublished() {
		return published;
	}

	/**
	 * @param published the published to set
	 */
	public void setPublished(int published) {
		this.published = published;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the publishedAt
	 */
	public Date getPublishedAt() {
		return publishedAt;
	}

	/**
	 * @param publishedAt the publishedAt to set
	 */
	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}

	@Override
	public String toString() {
		return "ProductReviewDTO [id=" + id + ", productId=" + productId + ", parentId=" + parentId + ", title=" + title
				+ ", rating=" + rating + ", published=" + published + ", createdAt=" + createdAt + ", publishedAt="
				+ publishedAt + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + parentId;
		result = prime * result + productId;
		result = prime * result + published;
		result = prime * result + ((publishedAt == null) ? 0 : publishedAt.hashCode());
		result = prime * result + rating;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (id != other.id)
			return false;
		if (parentId != other.parentId)
			return false;
		if (productId != other.productId)
			return false;
		if (published != other.published)
			return false;
		if (publishedAt == null) {
			if (other.publishedAt != null)
				return false;
		} else if (!publishedAt.equals(other.publishedAt))
			return false;
		if (rating != other.rating)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
