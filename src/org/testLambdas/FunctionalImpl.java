package org.testLambdas;



public class FunctionalImpl implements Functional {

	@Override
	public void method() {
		this.defaultMethod();
	}
	public static void main(String[] args) {
		Functional functional=FunctionalImpl :: new;
		//Functional functional=new FunctionalImpl();
		functional.defaultMethod();
	}
}
