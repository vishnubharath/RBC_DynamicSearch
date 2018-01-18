package com.vbj.rbc.parent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vbj.rbc.parent.model.ParentMapping;

public interface ParentRepository extends CrudRepository<ParentMapping, Long>{
	
	@Query("select u from ParentMapping u where u.childid = :childid")
	ParentMapping findImmediateParent(@Param("childid") String childid);
	
	@Query("select u from ParentMapping u where u.childid = :childid")
	List<ParentMapping> findImmediateParentList(@Param("childid") String childid);
	
	@Query("select u from ParentMapping u where u.parentid = :parentid")
	List<ParentMapping> findChildren(@Param("parentid") String parentid);
	
	@Query("select u from ParentMapping u where u.parentid = :parentid or u.childid = :childid")
	List<ParentMapping> findid(@Param("parentid") String parentid, @Param("childid") String childid);
	
	 long countByparentid(String parentid);
	 
	 long countBychildid(String childid);

}
