package org;

public class Test {
	public static void main(final String[] args) {
		Integer a = 127;
		Integer b = 127;
		System.out.println(a == b);
		
		StringBuffer buffer =new StringBuffer("123");
		//反转
		buffer.reverse();
		System.out.println(buffer.toString());
		
		buffer.replace(0, 1, "卧槽");
		System.out.println(buffer.toString());
		
		System.out.println(buffer.toString().replace("1", "尼玛"));
		
		
	}
}
