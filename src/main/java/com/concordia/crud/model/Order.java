package com.concordia.crud.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Order Entity
 *
 * @author Alexis
 *
 */

@Entity
@Table(name = "orders")
public class Order {

	private long id;
	private String firstname;
	private String middlename;
	private String lastname;
	private String mobile;
	private String email;
	private String city;
	private String province;
	private String country;
	private Date createdAt;
	private Date updatedAt;
	private Integer status;
	private Float total;
	private Float tax;

	private User user;
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	public Order() {

	}

	public Order(String firstname, String middlename, String lastname, String mobile, String email, String city,
			String province, String country, Date createdAt, Date updatedAt, Integer status, Float total, Float tax) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.mobile = mobile;
		this.email = email;
		this.city = city;
		this.province = province;
		this.country = country;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status = status;
		this.total = total;
		this.tax = tax;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "firstname")
	public String getName() {
		return firstname;
	}

	public void setName(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "middlename")
	public String getMiddleName() {
		return middlename;
	}

	public void setMiddleName(String middlename) {
		this.middlename = middlename;
	}

	@Column(name = "lastname")
	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "mobile")
	public String getMobileNumber() {
		return mobile;
	}

	public void setMobileNumber(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "email")
	public String getEmailAddress() {
		return email;
	}

	public void setEmailAddress(String email) {
		this.email = email;
	}

	@Column(name = "city")
	public String getUserCity() {
		return city;
	}

	public void setUserCity(String city) {
		this.city = city;
	}

	@Column(name = "province")
	public String getUserProvince() {
		return province;
	}

	public void setUserProvince(String province) {
		this.province = province;
	}

	@Column(name = "country")
	public String getUserCountry() {
		return country;
	}

	public void setUserCountry(String country) {
		this.country = country;
	}

	@Column(name = "created_at")
	public Date getUserCreated() {
		return createdAt;
	}

	public void setUserCreated(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "updated_at")
	public Date getUserUpdated() {
		return updatedAt;
	}

	public void setUserUpdated(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Column(name = "order_status")
	public Integer getUserStatus() {
		return status;
	}

	public void setUserStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "order_total")
	public Float getUserTotal() {
		return total;
	}

	public void setUserTotal(Float total) {
		this.total = total;
	}

	@Column(name = "order_tax")
	public Float getUserTax() {
		return tax;
	}

	public void setUserTax(Float tax) {
		this.tax = tax;
	}

	/**
	 * @return the user
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the orderItems
	 */
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * @param orderItems the orderItems to set
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", mobile=" + mobile
				+ ", email=" + email + ", city=" + city + ", province=" + province + ", country=" + country
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", status=" + status + ", total=" + total
				+ ", tax=" + tax + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((middlename == null) ? 0 : middlename.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tax == null) ? 0 : tax.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
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
		Order other = (Order) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id != other.id)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (middlename == null) {
			if (other.middlename != null)
				return false;
		} else if (!middlename.equals(other.middlename))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tax == null) {
			if (other.tax != null)
				return false;
		} else if (!tax.equals(other.tax))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		return true;
	}

}
