package org.testService;

import javax.xml.ws.Endpoint;

import org.testService.service.TestService;

public class Start {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9001/service/TestService", new TestService());
		System.out.println("service success!");
		//wsimport -s D:\\Project\\Test\\src -p org.testService.client -keep http://localhost:9001/service/TestService?wsdl
		//	wsimport 指令
		//  -s 地址
		// 	-p 包名
		//	-keep  service地址?wsdl
	}
	
}
