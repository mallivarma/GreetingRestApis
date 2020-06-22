package com.pailee.solutions.greet.utils;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GreetErrorMessage {

	 private String errorMessage;
	 private String errorMessageKey;
	 private String href;
	
	 
	public GreetErrorMessage() {
		super();
	}


	public GreetErrorMessage(String errorMessage, String errorMessageKey, String href) {
		super();
		this.errorMessage = errorMessage;
		this.errorMessageKey = errorMessageKey;
		this.href = href;
	}
	
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorMessageKey() {
		return errorMessageKey;
	}
	public void setErrorMessageKey(String errorMessageKey) {
		this.errorMessageKey = errorMessageKey;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	    
}
