package org.testService.service;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
* @author JoPson E-mail:jopson@sina.com
*/
@WebService
public class TestService {
	int count=0;
	public String getName(){
		System.out.println(++count);
		return "JoPson koon";
	}
}
