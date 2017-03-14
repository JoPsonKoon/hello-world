package org.testLambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestConverter {
	public static void main(String[] args) {
		Optional< String > fullName = Optional.ofNullable( null );
		System.out.println( "Full Name is set? " + fullName.isPresent() );       
		System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
		System.out.println( fullName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
		
		System.out.println("===================================================================");
		Optional< String > firstName = Optional.of( "Tom" );
		System.out.println( "First Name is set? " + firstName.isPresent() );       
		System.out.println( "First Name: " + firstName.orElseGet( () -> "[none]" ) );
		System.out.println( firstName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );

		List<String> list = new ArrayList<>();  
		list.add("alpASDFha");  
		list.add("betaASDF");  
		//转化为小写
		list = list.stream().map(String::toLowerCase).collect(Collectors.toCollection(ArrayList::new));//注意发生的变化  
		//大写
		list = list.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));//注意发生的变化  
	    System.out.println(list); 
	    
	    System.out.println("ADFAF".toLowerCase());
	    
	}
}
