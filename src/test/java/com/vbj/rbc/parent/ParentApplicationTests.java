package com.vbj.rbc.parent;

import static com.vbj.rbc.parent.ParentTestUtils.createRequestParentDetails;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.vbj.rbc.parent.model.ParentMapping;
import com.vbj.rbc.parent.service.model.HttpResponse;
import com.vbj.rbc.parent.service.model.ParentDetailsResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ParentApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void healthCheck() {
		String body = this.restTemplate.getForObject("/parentDetailServiceTest", String.class);
		assertThat(body).isEqualTo(HttpStatus.OK.name());

	}

	
	// Adding Test Data
	@Test
	public void savetestData() {
;
		HttpStatus status = this.restTemplate.postForObject("/saveparentdetails", createRequestParentDetails("2","1"), HttpStatus.class);
		assertThat(status).isEqualTo(HttpStatus.OK);

		status = this.restTemplate.postForObject("/saveparentdetails", createRequestParentDetails("3","2"), HttpStatus.class);
		assertThat(status).isEqualTo(HttpStatus.OK);

		status = this.restTemplate.postForObject("/saveparentdetails", createRequestParentDetails("4","3"), HttpStatus.class);
		assertThat(status).isEqualTo(HttpStatus.OK);		
		
		status = this.restTemplate.postForObject("/saveparentdetails", createRequestParentDetails("5","4"), HttpStatus.class);
		assertThat(status).isEqualTo(HttpStatus.OK);

	}
	

	// Listing Test Data Information
	@Test
	public void listalltestData() {

		HttpResponse resp = this.restTemplate.getForObject("/listallparentdetails", HttpResponse.class);

		List<ParentMapping> pmlist = resp.getResults().get("results");

		System.out.println("\nList of Test data :");
		for (ParentMapping pm : pmlist) {
			System.out.println("child : " + pm.getChildid() + " parent : " + pm.getParentid());
		}
		
		assertThat(resp.getStatus()).isEqualTo(HttpStatus.OK);

	}
	
	
	@Test
	public void findParentOfTest1() {

		
		String child = "500";
		System.out.println("\nParent Info of child " + child + ":");
		
		ParentDetailsResponse parentDetailsResponse = this.restTemplate.getForObject("/findparentinfo?child="+child, ParentDetailsResponse.class);
		
		System.out.println(parentDetailsResponse);		
		assertThat(parentDetailsResponse.getStatus()).isEqualTo(HttpStatus.NOT_FOUND);
		
	}
	
	@Test
	public void findParentOfTest2() {

		
		String child = "5";
		System.out.println("\nParent Info of child " + child + ":");
		
		ParentDetailsResponse parentDetailsResponse = this.restTemplate.getForObject("/findparentinfo?child="+child, ParentDetailsResponse.class);
		
		System.out.println(parentDetailsResponse);		
		assertThat(parentDetailsResponse.getStatus()).isEqualTo(HttpStatus.OK);
		
	}
	
	@Test
	public void findParentOfTest3() {

		
		String child = "2";
		System.out.println("\nParent Info of child " + child + ":");
		
		ParentDetailsResponse parentDetailsResponse = this.restTemplate.getForObject("/findparentinfo?child="+child, ParentDetailsResponse.class);
		
		System.out.println(parentDetailsResponse);		
		assertThat(parentDetailsResponse.getStatus()).isEqualTo(HttpStatus.OK);
		
	}
	
	@Test
	public void findParentOfTest4() {

		
		String child = "1";
		System.out.println("\nParent Info of child " + child + ":");
		
		ParentDetailsResponse parentDetailsResponse = this.restTemplate.getForObject("/findparentinfo?child="+child, ParentDetailsResponse.class);
		
		System.out.println(parentDetailsResponse);		
		assertThat(parentDetailsResponse.getStatus()).isEqualTo(HttpStatus.OK);
		
	}
	
	
}
