package com.vbj.rbc.parent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vbj.rbc.parent.exception.ChildNotFoundException;
import com.vbj.rbc.parent.model.ParentMapping;
import com.vbj.rbc.parent.repository.ParentRepository;
import com.vbj.rbc.parent.service.ParentDAO;

@Repository
public class ParentDAOImpl implements ParentDAO {

	@Autowired
	ParentRepository parentRepository;

	@Override
	public void saveParentDetails(String child, String parent) {

		ParentMapping pinfo = new ParentMapping();
		pinfo.setChildid(child);
		pinfo.setParentid(parent);
		parentRepository.save(pinfo);

	}

	@Override
	public Iterable<ParentMapping> listAllParentDetails() {

		Iterable<ParentMapping> pmlist = parentRepository.findAll();
		return pmlist;

	}

	@Override
	public ParentMapping getParentInfo(String child)  {
		ParentMapping pm = parentRepository.findImmediateParent(child);
		return pm;
	}

	@Override
	public ParentMapping getOneChildInfo(String child) throws ChildNotFoundException {

		List<ParentMapping> pm = parentRepository.findChildren(child);
		if (pm.size() == 0)
			throw new ChildNotFoundException();

		return pm.get(0);
	}

	@Override
	public long getParentCount(String id) {
		return parentRepository.countBychildid(id);
	}

	@Override
	public long getChildCount(String id) {
		return parentRepository.countByparentid(id);
	}

	

}
