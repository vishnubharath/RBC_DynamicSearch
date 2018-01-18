package com.vbj.rbc.parent.service.model;

import org.springframework.http.HttpStatus;

public class ParentDetailsResponse {

	HttpStatus status;
	String immediateParent;
	String ultimateParent;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getImmediateParent() {
		return immediateParent;
	}

	public void setImmediateParent(String immediateParent) {
		this.immediateParent = immediateParent;
	}

	public String getUltimateParent() {
		return ultimateParent;
	}

	public void setUltimateParent(String ultimateParent) {
		this.ultimateParent = ultimateParent;
	}
	
	@Override
	public String toString() {
		return "immediate parent : " + immediateParent + " | ultimate parent : " + ultimateParent;
	}

}
