package org.testService;

import org.testService.client.TestService;
import org.testService.client.TestServiceService;

public class TestClient {
	public static void main(String[] args) {
		TestService tService=new TestServiceService().getTestServicePort();
		System.out.println(tService.getName());
	}
}
