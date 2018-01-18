package com.vbj.rbc.parent.service;

import com.vbj.rbc.parent.exception.ChildNotFoundException;
import com.vbj.rbc.parent.model.ParentMapping;

public interface ParentDAO {
	
	void saveParentDetails(String child, String parent);

	Iterable<ParentMapping> listAllParentDetails();

	ParentMapping getParentInfo(String child) ;

	ParentMapping getOneChildInfo(String child) throws ChildNotFoundException;
	
	long getParentCount(String id);
	
	long getChildCount(String id);
	
}
