package org.testLambdas;

@FunctionalInterface
public interface Functional {
	void method();
	default void defaultMethod(){
		System.out.println("你调用了:defaultMethod方法");
	}
}
