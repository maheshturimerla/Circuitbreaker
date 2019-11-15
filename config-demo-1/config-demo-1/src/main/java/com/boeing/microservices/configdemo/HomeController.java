package com.boeing.microservices.configdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Autowired
	private Model model;
	
	@RequestMapping(value = "/common-msg",method=RequestMethod.GET)
	public String commonMsg() {
		return model.getCommonMsg();
	}
	
	@RequestMapping(value = "/env-msg",method=RequestMethod.GET)
	public String envMsg() {
		return model.getEnvMsg();
	}
	
	@RequestMapping(value = "/encrypted-msg",method=RequestMethod.GET)
	public String encryptedMsg() {
		return model.getEncryptedMsg();
	}
	
	@RequestMapping(value = "/refresh",method=RequestMethod.POST)
	public String postValue(){
		return "refresh application";
	}
}
