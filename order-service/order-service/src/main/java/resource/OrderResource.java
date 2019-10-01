package resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import model.Order;

@RestController
@RequestMapping("/rest/order")
public class OrderResource {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/{username}")
	public List<String> getOrder(@PathVariable("username") final String userName)
	{
		
		ResponseEntity<List<String>> orderResponse = restTemplate.exchange("http://db-service/rest/db/" +userName, HttpMethod.GET, null, 
				new ParameterizedTypeReference<List<String>>(){});
		
		List<String> orders=orderResponse.getBody();
		return orders;
		
	}
}
