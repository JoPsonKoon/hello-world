package org.localdate;

import java.time.LocalDate;

/**
 * @author jopson
 * @Description TODO () 
 */
public class JDK8_LocalDate {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		// 获取上个月的时间
		date = date.minusMonths(1);
		System.out.println(date);
	}
}


//====================================LocalDate函数==================================
//getYear()    int    获取当前日期的年份
//getMonth()    Month    获取当前日期的月份对象
//getMonthValue()    int    获取当前日期是第几月
//getDayOfWeek()    DayOfWeek    表示该对象表示的日期是星期几
//getDayOfMonth()    int    表示该对象表示的日期是这个月第几天
//getDayOfYear()    int    表示该对象表示的日期是今年第几天
//withYear(int year)    LocalDate    修改当前对象的年份
//withMonth(int month)    LocalDate    修改当前对象的月份
//withDayOfMonth(int dayOfMonth)    LocalDate    修改当前对象在当月的日期
//isLeapYear()    boolean    是否是闰年
//lengthOfMonth()    int    这个月有多少天
//lengthOfYear()    int    该对象表示的年份有多少天（365或者366）
//plusYears(long yearsToAdd)    LocalDate    当前对象增加指定的年份数
//plusMonths(long monthsToAdd)    LocalDate    当前对象增加指定的月份数
//plusWeeks(long weeksToAdd)    LocalDate    当前对象增加指定的周数
//plusDays(long daysToAdd)    LocalDate    当前对象增加指定的天数
//minusYears(long yearsToSubtract)    LocalDate    当前对象减去指定的年数
//minusMonths(long monthsToSubtract)    LocalDate    当前对象减去注定的月数
//minusWeeks(long weeksToSubtract)    LocalDate    当前对象减去指定的周数
//minusDays(long daysToSubtract)    LocalDate    当前对象减去指定的天数
//compareTo(ChronoLocalDate other)    int    比较当前对象和other对象在时间上的大小，返回值如果为正，则当前对象时间较晚，
//isBefore(ChronoLocalDate other)    boolean    比较当前对象日期是否在other对象日期之前
//isAfter(ChronoLocalDate other)    boolean    比较当前对象日期是否在other对象日期之后
//isEqual(ChronoLocalDate other)    boolean    比较两个日期对象是否相等
