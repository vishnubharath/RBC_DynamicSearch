package com.vbj.rbc.parent.service.model;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.vbj.rbc.parent.model.ParentMapping;

public class HttpResponse {

	HttpStatus status;
	Map<String, List<ParentMapping>> results;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Map<String, List<ParentMapping>> getResults() {
		return results;
	}

	public void setResults(Map<String, List<ParentMapping>> results) {
		this.results = results;
	}


}
