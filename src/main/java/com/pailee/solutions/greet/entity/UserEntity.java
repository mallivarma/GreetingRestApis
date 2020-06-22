package com.pailee.solutions.greet.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity( name="Users")
public class UserEntity implements Serializable{

	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		@Id
	    @GeneratedValue
	    private long id;
	    private String userId;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String salt;
	    private String encryptedPassword;
	    private String token;
	    private String emailVerificationToken;
	    
	    @Column(nullable = false, columnDefinition = "boolean default false")
	    private Boolean emailVerificationStatus;
	    
	    
	    
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getSalt() {
			return salt;
		}
		public void setSalt(String salt) {
			this.salt = salt;
		}
		public String getEncryptedPassword() {
			return encryptedPassword;
		}
		public void setEncryptedPassword(String encryptedPassword) {
			this.encryptedPassword = encryptedPassword;
		}
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public String getEmailVerificationToken() {
			return emailVerificationToken;
		}
		public void setEmailVerificationToken(String emailVerificationToken) {
			this.emailVerificationToken = emailVerificationToken;
		}
		public Boolean getEmailVerificationStatus() {
			return emailVerificationStatus;
		}
		public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
			this.emailVerificationStatus = emailVerificationStatus;
		}
	
	    
	    
	    
}
