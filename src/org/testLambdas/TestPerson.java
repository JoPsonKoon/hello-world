package org.testLambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import sun.print.resources.serviceui;

public class TestPerson {
	public static void main(String[] args) {
		List<Person> javaProgrammers = new ArrayList<Person>() {
			{
				add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
				add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
				add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
				add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
				add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
				add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
				add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
				add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
				add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
				add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
			}
		};

		List<Person> phpProgrammers = new ArrayList<Person>() {
			{
				add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
				add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
				add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
				add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
				add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
				add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
				add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
				add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
				add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
				add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
			}
		};
		System.out.println();System.out.println("程序员所有姓名:");
		javaProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));  
		phpProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
		System.out.println();System.out.println("给程序员加薪 5% :");  
		Consumer<Person> giveRaise = e -> e.setSalary(e.getSalary() / 100 * 5 + e.getSalary());  
		javaProgrammers.forEach(giveRaise);  
		phpProgrammers.forEach(giveRaise);
		javaProgrammers.forEach(g->System.out.println(g.getFirstName()+":"+g.getSalary()));  
		phpProgrammers.forEach(g->System.out.println(g.getFirstName()+":"+g.getSalary())); 
		
		System.out.println();System.out.println("下面是月薪超过 $1,400 的PHP程序员:");
		phpProgrammers.stream()  
		          .filter((p) -> (p.getSalary() > 1400)) //过滤 
		          .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName())); 
		
		// 定义 filters  
		Predicate<Person> ageFilter    = p -> p.getAge() > 25;  
		Predicate<Person> salaryFilter = p -> p.getSalary() > 1400;  
		Predicate<Person> genderFilter = p -> "female".equals(p.getGender());  
		  
		System.out.println();System.out.println("下面是年龄大于 24岁且月薪在$1,400以上的女PHP程序员:");  
		phpProgrammers.stream()  
		          .filter(ageFilter)  
		          .filter(salaryFilter)  
		          .filter(genderFilter)  
		          .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));  
		  
		// 重用filters  
		System.out.println();System.out.println("年龄大于 24岁的女性 Java programmers:");  
		javaProgrammers.stream()  
		          .filter(ageFilter)  
		          .filter(genderFilter)  
		          .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName())); 
		
		System.out.println();System.out.println("最前面的3个 Java programmers:");  
		javaProgrammers.stream()  
		          .limit(3)  
		          .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));  
		  
		  
		System.out.println();System.out.println("最前面的3个女性 Java programmers:");  
		javaProgrammers.stream()  
		          .filter(genderFilter)  
		          .limit(3)  
		          .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));  
		
		System.out.println();System.out.println("工资最低的 Java programmer:");  
		Person pers = javaProgrammers  
		          .stream()  
		          .min((p1, p2) -> (p1.getSalary() - p2.getSalary()))  
		          .get()  ;
		  
		System.out.printf("Name: %s %s; Salary: $%,d.", pers.getFirstName(), pers.getLastName(), pers.getSalary());  
		  
		System.out.println();System.out.println("工资最高的 Java programmer:");  
		Person person = javaProgrammers  
		          .stream()  
		          .max((p, p2) -> (p.getSalary() - p2.getSalary()))  
		          .get();  
		  
		System.out.printf("Name: %s %s; Salary: $%,d.", person.getFirstName(), person.getLastName(), person.getSalary());
		
		//打印所有Java程序员姓名,年龄
		javaProgrammers.forEach(p->System.out.println("姓名:"+p.getFirstName()+",年龄:"+p.getAge()));
		
		
	}
	
}
