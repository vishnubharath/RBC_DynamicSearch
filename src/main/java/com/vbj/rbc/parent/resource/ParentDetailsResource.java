package com.vbj.rbc.parent.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vbj.rbc.parent.exception.ChildNotFoundException;
import com.vbj.rbc.parent.model.ParentMapping;
import com.vbj.rbc.parent.service.ParentDataService;
import com.vbj.rbc.parent.service.model.HttpResponse;
import com.vbj.rbc.parent.service.model.ParentDetailsResponse;


@RestController
public class ParentDetailsResource {


	@Autowired
	private ParentDataService parentDataService;

	@GET
	@RequestMapping("/parentDetailServiceTest")
	public String getParentServiceHealth() {
		return "OK"; 
	}
	
	@POST
	@RequestMapping(value = "/saveparentdetails")
	public HttpStatus saveParentDetails(@RequestParam("child") String child, @RequestParam("parent") String parent) {	
		
		parentDataService.saveParentInfo(child,parent);
		return HttpStatus.OK;
	}

	@GET
	@RequestMapping(value = "/listallparentdetails")
	public HttpResponse listAllParentDetails() {	
		
		HttpResponse resp = new HttpResponse();
		Map<String, List<ParentMapping>> results = new HashMap<String, List<ParentMapping>>();
		
		List<ParentMapping> allDetails = parentDataService.listAllParentInfo();
		
		results.put("results",allDetails);
		
		resp.setResults(results);
		resp.setStatus(HttpStatus.OK);
		
		return resp;
	}
	
	@GET
	@RequestMapping(value = "/findparentinfo")
	public ParentDetailsResponse getParentDetails(@QueryParam("child") String child) {	
		
		ParentDetailsResponse parentResponse = new ParentDetailsResponse();
		
		if(!parentDataService.idExist(child)){
			
			parentResponse.setImmediateParent("No data found"); 
			parentResponse.setUltimateParent("No data found");
			
			parentResponse.setStatus(HttpStatus.NOT_FOUND);
			return parentResponse;
		}
		
		
		ParentMapping immediatParentMapping = parentDataService.getImmediateParent(child);
		
		ParentMapping ultimateParentMapping = null;
		parentResponse.setImmediateParent(immediatParentMapping ==null ? null : immediatParentMapping.getParentid());
		if(immediatParentMapping != null) {
			
			try {
				ultimateParentMapping = parentDataService.getUltimateParent(child);
			} catch (ChildNotFoundException e) {
				ultimateParentMapping = null; // Not used for data analysis at this point (marking the ultimate parent as null) 
			}
		}
		
		parentResponse.setUltimateParent(ultimateParentMapping ==null ? null : ultimateParentMapping.getParentid());
		
		parentResponse.setStatus(HttpStatus.OK);
		return parentResponse;
	}
}
