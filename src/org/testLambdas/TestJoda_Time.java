package org.testLambdas;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class TestJoda_Time {
	public static void main(String[] args) throws ScriptException {
		List <Integer> l1=new ArrayList<Integer>();
		  l1.add(1);l1.add(2);l1.add(3);
		  l1.add(4);l1.add(5);l1.add(6);
		  List <Integer> l2=new ArrayList<Integer>();
		  l2.add(4);l2.add(5);l2.add(6);
		  l2.add(7);l2.add(8);l2.add(9);
		  
		  Set<Integer> s=new TreeSet(l1);
		  for(Integer i:l2){
		   //当添加不成功的时候 说明s中已经存在该对象，直接remove掉该对象即可
		   if(!s.add(i)) s.remove(i);
		  }
		  System.out.println(s);

		/*final Clock clock = Clock.systemUTC();
		System.out.println(clock.instant());
		System.out.println(clock.millis());

		final LocalDate date=LocalDate.now();
		final LocalDate dateFromClock =LocalDate.now(clock);
		System.out.println(date);
		System.out.println(dateFromClock);
		
		final LocalTime time=LocalTime.now();
		final LocalTime timeFromClock=LocalTime.now(clock);
		System.out.println(time);
		System.out.println(timeFromClock);
		
		final ZonedDateTime zonedDateTime=ZonedDateTime.now();
		final ZonedDateTime zonedDateTimeFromClock=ZonedDateTime.now(clock);
		final ZonedDateTime zonedDateTimeFromZoone=zonedDateTime.now(ZoneId.of("America/Los_Angeles"));
		System.out.println(zonedDateTime);
		System.out.println(zonedDateTimeFromClock);
		System.out.println(zonedDateTimeFromZoone);
		
		// Get duration between two dates
		final LocalDateTime from = LocalDateTime.of( 2014, Month.APRIL, 16, 0, 0, 0 );
		final LocalDateTime to = LocalDateTime.of( 2015, Month.APRIL, 16, 23, 59, 59 );
		 
		final Duration duration = Duration.between( from, to );
		System.out.println( "Duration in days: " + duration.toDays() );
		System.out.println( "Duration in hours: " + duration.toHours() );
		
		
		//Nashorn，一个新的JavaScript引擎随着Java 8一起公诸于世，它允许在JVM上开发运行某些JavaScript应用。Nashorn就是javax.script.ScriptEngine的另一种实现，并且它们俩遵循相同的规则，允许Java与JavaScript相互调用。
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName( "JavaScript" );
		System.out.println( engine.getClass().getName() );
		System.out.println( "Result:" + engine.eval( 
				"function f(a) { return a; };  f(1) + 1;" ) );*/

	}
}
