package com.vbj.rbc.parent.service;

import java.util.List;

import com.vbj.rbc.parent.exception.ChildNotFoundException;
import com.vbj.rbc.parent.model.ParentMapping;

public interface ParentDataService {

	void saveParentInfo(String child, String parent);

	List<ParentMapping> listAllParentInfo();

	ParentMapping getImmediateParent(String child);

	ParentMapping getUltimateParent(String child) throws ChildNotFoundException;

	boolean idExist(String id);	

}
