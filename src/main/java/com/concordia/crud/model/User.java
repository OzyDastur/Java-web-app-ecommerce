
package com.concordia.crud.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User Entity
 *
 * @author Alexis
 *
 */

@Entity
@Table(name = "user")
public class User {

	private long id;
	private String firstName;
	private String lastName;
	private String password;
	private String mobile;
	private String email;
	private String profile;
	private String lastLogin;

	private List<Order> orders = new ArrayList<Order>();
	private List<Cart> carts = new ArrayList<Cart>();

	public User() {

	}

	public User(String firstName, String lastName, String password, String mobile, String email, String profile,
			String lastLogin) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.mobile = mobile;
		this.email = email;
		this.profile = profile;
		this.lastLogin = lastLogin;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "firstname")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastname")
	public String getLastName() {
		return lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	@Column(name = "profile")
	public String getUserProfile() {
		return profile;
	}

	public void setUserProfile(String profile) {
		this.profile = profile;
	}

	@Column(name = "lastlogin")
	public String getUserLastLogin() {
		return lastLogin;
	}

	public void setUserLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * @return the orders
	 */
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	public List<Order> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	/**
	 * @return the carts
	 */
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	public List<Cart> getCarts() {
		return carts;
	}

	/**
	 * @param carts the carts to set
	 */
	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstName + ", lastname=" + lastName + ", password=" + password
				+ ", mobile=" + mobile + ", email=" + email + ", profile=" + profile + ", lastLogin=" + lastLogin + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastLogin == null) ? 0 : lastLogin.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastLogin == null) {
			if (other.lastLogin != null)
				return false;
		} else if (!lastLogin.equals(other.lastLogin))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		return true;
	}

}