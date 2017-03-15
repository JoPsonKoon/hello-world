package org.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 迭代器或者说游标
 * 
 * @author jopson
 *
 */
public class IteratorTest {
	public static void main(String[] args) {
		List<String> a = new ArrayList<String>();
		a.add("1");
		a.add("2");
		
		a.forEach(c -> System.out.println("原：" + c));
		
		Iterator<String> it = a.iterator();
		while (it.hasNext()) {
			if ("1".equals(it.next())) {
				it.remove();
			}
		}
		
		a.forEach(c -> System.out.println("改：" + c));
		
		/************************************************/
		List<Temp> list = new ArrayList<Temp>();
		Temp temp = new Temp();
		temp.setId("123");
		temp.setName("Guan");

		Temp temp2 = new Temp();
		temp2.setId("456");
		temp2.setName("jin");

		list.add(temp);
		list.add(temp2);
		list.forEach(c -> System.out.println("原：" + c.getId() + "\t" + c.getName()));

		Iterator<Temp> iterator = list.iterator();
		while (iterator.hasNext()) {
			if ("123".equals(iterator.next().getId())) {
				iterator.remove();
			}
		}

		list.forEach(c -> System.out.println("改：" + c.getId() + "\t" + c.getName()));

	}
}

class Temp {
	private String id;

	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
