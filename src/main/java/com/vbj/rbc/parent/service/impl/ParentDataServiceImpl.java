package com.vbj.rbc.parent.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vbj.rbc.parent.exception.ChildNotFoundException;
import com.vbj.rbc.parent.model.ParentMapping;
import com.vbj.rbc.parent.service.ParentDAO;
import com.vbj.rbc.parent.service.ParentDataService;

@Service
public class ParentDataServiceImpl implements ParentDataService {

	@Autowired
	ParentDAO parentDataService;

	@Override
	@Transactional
	public void saveParentInfo(String child, String parent) {
		parentDataService.saveParentDetails(child, parent);
	}

	@Override
	public List<ParentMapping> listAllParentInfo() {
		List<ParentMapping> target = new ArrayList<>();
		parentDataService.listAllParentDetails().forEach(target::add);
		return target;
	}

	@Override
	public ParentMapping getImmediateParent(String child) {

		ParentMapping parentMapping = parentDataService.getParentInfo(child);

		return parentMapping;
	}

	@Override
	public ParentMapping getUltimateParent(String child) throws ChildNotFoundException {

		ParentMapping parentMapping = parentDataService.getParentInfo(child);

		if (parentMapping != null) {
			return this.getUltimateParent(parentMapping.getParentid());

		} else {
			return parentDataService.getOneChildInfo(child);
		}
	}

	@Override
	public boolean idExist(String id)  {
		
		if(parentDataService.getChildCount(id) == 0 && parentDataService.getParentCount(id) == 0)
			return false;		
		
		return true;
	}

}
