package com.boeing.microservice;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ConsumerController {
	@Autowired
    private RestTemplate rest;
	
	
	
	@RequestMapping(value="/product", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "getBackupMethod")
	public Integer product(@RequestParam(value="x", required=true) Integer x, @RequestParam(value="y", required=true) Integer y) {
		System.out.println("/product called.......................................");
		URI uri = UriComponentsBuilder.fromUriString("//cb-demo-producer/multiply")
									  .queryParam("x", x)
									  .queryParam("y", y)
									  .build()
									  .toUri();
		
		Integer response = rest.getForObject(uri, Integer.class);
		return response;
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String welcome(){
		return "cb-demo-consumer application via Service Registry service";
	}
	
	public Integer getBackupMethod(Integer x, Integer y) {
		return -999;
	}
    
}
