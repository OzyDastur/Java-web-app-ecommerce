package com.concordia.crud.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Product Reviews
 *
 * @author Alexis
 *
 */

@Entity
@Table(name = "productreview")
public class ProductReview {

	private long id;
	private Integer parentId;
	private String title;
	private Integer rating;
	private Integer published;
	private Date createdAt;
	private Date publishedAt;

	private Product product;

	public ProductReview() {

	}

	public ProductReview( Integer parentId, String title, Integer rating, Integer published,
			Date createdAt, Date publishedAt) {
		super();
		this.parentId = parentId;
		this.title = title;
		this.rating = rating;
		this.published = published;
		this.createdAt = createdAt;
		this.publishedAt = publishedAt;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "productreview_id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "parentid")
	public int getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "rating")
	public int getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Column(name = "published")
	public int getPublished() {
		return published;
	}

	public void setPublished(Integer published) {
		this.published = published;
	}

	@Column(name = "createdAt")
	public Date getUserCreated() {
		return createdAt;
	}

	public void setUserCreated(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "publishedAt")
	public Date getPublishedDate() {
		return publishedAt;
	}

	public void setPublishedDate(Date publishedAt) {
		this.publishedAt = publishedAt;
	}

	/**
	 * @return the product
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductReview [id=" + id + ", parentId=" + parentId + ", title=" + title
				+ ", rating=" + rating + ", published=" + published + ", createdAt=" + createdAt + ", publishedAt="
				+ publishedAt + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
		result = prime * result + ((published == null) ? 0 : published.hashCode());
		result = prime * result + ((publishedAt == null) ? 0 : publishedAt.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
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
		ProductReview other = (ProductReview) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (id != other.id)
			return false;
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		if (published == null) {
			if (other.published != null)
				return false;
		} else if (!published.equals(other.published))
			return false;
		if (publishedAt == null) {
			if (other.publishedAt != null)
				return false;
		} else if (!publishedAt.equals(other.publishedAt))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
