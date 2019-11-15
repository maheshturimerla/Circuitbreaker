package com.boeing.microservices.configdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.properties.ConfigurationProperties;

//@ConfigurationProperties
@RefreshScope
@Configuration
public class Model {
	@Value("${app.common.msg}")
	private String commonMsg;
	
	@Value("${app.env.msg}")
	private String envMsg;

	private String encryptedMsg;

	public String getCommonMsg() {
		return commonMsg;
	}

	public void setCommonMsg(String commonMsg) {
		this.commonMsg = commonMsg;
	}

	public String getEnvMsg() {
		return envMsg;
	}

	public void setEnvMsg(String envMsg) {
		this.envMsg = envMsg;
	}

	public String getEncryptedMsg() {
		return encryptedMsg;
	}

	public void setEncryptedMsg(String encryptedMsg) {
		this.encryptedMsg = encryptedMsg;
	}
}
