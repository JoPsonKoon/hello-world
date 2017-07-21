package org;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CalendarTest {
	public static void main(String[] args){

        SimpleDateFormat 格式=new SimpleDateFormat("y年M月d日 E H时m分s秒",Locale.CHINA);
        Calendar 日历=Calendar.getInstance(Locale.CHINA);
        日历.setFirstDayOfWeek(Calendar.MONDAY);
        //当前时间，貌似多余，其实是为了所有可能的系统一致
        日历.setTimeInMillis(System.currentTimeMillis());
        System.out.println("当前时间:"+格式.format(日历.getTime()));
        日历.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        System.out.println("周一时间:"+格式.format(日历.getTime()));
        日历.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        System.out.println("周一时间:"+格式.format(日历.getTime()));
    }
}
