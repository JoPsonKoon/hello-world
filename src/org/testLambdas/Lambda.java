package org.testLambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Lambda {
	// 定义变量
	private String firstName = "", lastName = "", job = "", gender = "";

	public static void main(String[] args) {
		String[] players = { "Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer",
				"Andy Murray", "Tomas Berdych", "Juan Martin Del Potro", "Richard Gasquet", "John Isner" };

		List<String> names = Arrays.asList(players);
		// 简单循环
		names.forEach((n) -> System.out.println(n + "; "));

		// 1.2使用 lambda expression
		new Thread(() -> System.out.println("Hello world !")).start();

		// 2.1使用匿名内部类
		Runnable race2 = () -> System.out.println("Hello world !");
		race2.run();
		// 排序
		System.out.println("排序=========升");
		Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));
		for (String string : players) {
			System.out.println(string);
		}
		System.out.println("排序=========降");
		Arrays.sort(players, (String s1, String s2) -> (s2.compareTo(s1)));
		for (String string : players) {
			System.out.println(string);
		}

		// 计算 count, min, max, sum, and average for numbers
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

		System.out.println("List中最大的数字 : " + stats.getMax());
		System.out.println("List中最小的数字 : " + stats.getMin());
		System.out.println("所有数字的总和   : " + stats.getSum());
		System.out.println("所有数字的平均值 : " + stats.getAverage());
	}

	//
	
}
