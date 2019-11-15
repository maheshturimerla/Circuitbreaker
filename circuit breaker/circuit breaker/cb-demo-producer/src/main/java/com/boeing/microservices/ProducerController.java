/**
 * 
 */
package com.boeing.microservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProducerController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String welcome(){
		return "Welcome to producer application.";
	}
	
	@RequestMapping(value="/multiply", method = RequestMethod.GET)
	public Integer multiply(@RequestParam(value="x", required=true) Integer x, @RequestParam(value="y", required=true) Integer y) {
		return x*y;
	}

	
}
