package org;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class ReflectTest implements Serializable{
	public static void main(String[] args) throws Exception {
		Class<?> class1 = null;
		Class<?> class2 = null;
		Class<?> class3 = null;
		class1 = Class.forName("org.ReflectTest");
		class2 = new ReflectTest().getClass();
		class3 = ReflectTest.class;
		System.out.println("类名1：" + class1.getName());
		System.out.println("类名2：" + class2.getName());
		System.out.println("类名3：" + class3.getName());

		Class<?> parentClass = class1.getSuperclass();
		System.out.println("class1的父类：" + parentClass.getName());

		// 获取所有的接口
		Class<?> ints[] = class1.getInterfaces();
		for (int i = 0; i < ints.length; i++) {
			System.out.println((i + 1) + ":" + ints[i].getName());
		}
		Field[] fields = class1.getDeclaredFields();
		System.out.println(fields);
		
		 Method method = class1.getMethod("show",String.class);
		 System.out.println(method);
		
	}
	public void show (String aaa){
		System.out.println("show()");
	}
}
