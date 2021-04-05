//package com.concordia.crud.dto;
//
//import java.io.Serializable;
//
//public class UserDTO implements Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private long id;
//	private String firstName;
//	private String lastName;
//	private String mobile;
//	private String email;
//	private String password;
//	private String profile;
//	private String lastLogin;
//
//	public UserDTO() {
//
//	}
//
//	public UserDTO(String firstName, String lastName, String mobile, String email, String password, String profile,
//			String lastLogin) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.mobile = mobile;
//		this.email = email;
//		this.password = password;
//		this.profile = profile;
//		this.lastLogin = lastLogin;
//	}
//
//
//
//	/**
//	 * @return the id
//	 */
//	public long getId() {
//		return id;
//	}
//
//	/**
//	 * @param id the id to set
//	 */
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	/**
//	 * @return the firstName
//	 */
//	public String getFirstName() {
//		return firstName;
//	}
//
//	/**
//	 * @param firstName the firstName to set
//	 */
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	/**
//	 * @return the lastName
//	 */
//	public String getLastName() {
//		return lastName;
//	}
//
//	/**
//	 * @param lastName the lastName to set
//	 */
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	/**
//	 * @return the mobile
//	 */
//	public String getMobile() {
//		return mobile;
//	}
//
//	/**
//	 * @param mobile the mobile to set
//	 */
//	public void setMobile(String mobile) {
//		this.mobile = mobile;
//	}
//
//	/**
//	 * @return the email
//	 */
//	public String getEmail() {
//		return email;
//	}
//
//	/**
//	 * @param email the email to set
//	 */
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	/**
//	 * @return the password
//	 */
//	public String getPassword() {
//		return password;
//	}
//
//	/**
//	 * @param password the password to set
//	 */
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	/**
//	 * @return the profile
//	 */
//	public String getProfile() {
//		return profile;
//	}
//
//	/**
//	 * @param profile the profile to set
//	 */
//	public void setProfile(String profile) {
//		this.profile = profile;
//	}
//
//	/**
//	 * @return the lastLogin
//	 */
//	public String getLastLogin() {
//		return lastLogin;
//	}
//
//	/**
//	 * @param lastLogin the lastLogin to set
//	 */
//	public void setLastLogin(String lastLogin) {
//		this.lastLogin = lastLogin;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((email == null) ? 0 : email.hashCode());
//		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
//		result = prime * result + (int) (id ^ (id >>> 32));
//		result = prime * result + ((lastLogin == null) ? 0 : lastLogin.hashCode());
//		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
//		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
//		result = prime * result + ((password == null) ? 0 : password.hashCode());
//		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		UserDTO other = (UserDTO) obj;
//		if (email == null) {
//			if (other.email != null)
//				return false;
//		} else if (!email.equals(other.email))
//			return false;
//		if (firstName == null) {
//			if (other.firstName != null)
//				return false;
//		} else if (!firstName.equals(other.firstName))
//			return false;
//		if (id != other.id)
//			return false;
//		if (lastLogin == null) {
//			if (other.lastLogin != null)
//				return false;
//		} else if (!lastLogin.equals(other.lastLogin))
//			return false;
//		if (lastName == null) {
//			if (other.lastName != null)
//				return false;
//		} else if (!lastName.equals(other.lastName))
//			return false;
//		if (mobile == null) {
//			if (other.mobile != null)
//				return false;
//		} else if (!mobile.equals(other.mobile))
//			return false;
//		if (password == null) {
//			if (other.password != null)
//				return false;
//		} else if (!password.equals(other.password))
//			return false;
//		if (profile == null) {
//			if (other.profile != null)
//				return false;
//		} else if (!profile.equals(other.profile))
//			return false;
//		return true;
//	}
//
//	@Override
//	public String toString() {
//		return "UserDTO [id=" + id + ", firstname=" + firstName + ", lastname=" + lastName + ", mobile=" + mobile
//				+ ", email=" + email + ", password=" + password + ", profile=" + profile + ", lastLogin=" + lastLogin
//				+ "]";
//	}
//
//}
