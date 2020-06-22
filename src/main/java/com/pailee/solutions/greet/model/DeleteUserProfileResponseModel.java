package com.pailee.solutions.greet.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.pailee.solutions.greet.utils.DeleteRequestOperation;
import com.pailee.solutions.greet.utils.DeleteResponseStatus;

@XmlRootElement
public class DeleteUserProfileResponseModel {

	private DeleteRequestOperation deleteRequestOperation;
	private DeleteResponseStatus deleteResponseStatus;
	
	
	public DeleteRequestOperation getDeleteRequestOperation() {
		return deleteRequestOperation;
	}
	public void setDeleteRequestOperation(DeleteRequestOperation deleteRequestOperation) {
		this.deleteRequestOperation = deleteRequestOperation;
	}
	public DeleteResponseStatus getDeleteResponseStatus() {
		return deleteResponseStatus;
	}
	public void setDeleteResponseStatus(DeleteResponseStatus deleteResponseStatus) {
		this.deleteResponseStatus = deleteResponseStatus;
	}
}
