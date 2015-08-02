package org.xsl781.utils;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressLint("SimpleDateFormat")
public class TimeUtils {
	/*public static PrettyTime prettyTime=new PrettyTime();

	public static String getDate(Date date) {
	  SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");
	  return format.format(date);
	}

	public static String millisecs2DateString(long timestamp) {
	  long gap=System.currentTimeMillis()-timestamp;
	  if(gap<1000*60*60*24){
	    return prettyTime.format(new Date(timestamp));
	  }else{
	    return getDate(new Date(timestamp));
	  }
	}*/
	private static SimpleDateFormat sf = new SimpleDateFormat("yyMMddHHmmss");

	public static boolean haveTimeGap(long lastTime, long time) {
		int gap = 1000 * 60 * 10;//10 mins
		return time - lastTime > gap;
	}

	public static String getDateStr() {
		return sf.format(new Date());
	}

	public static long getPassTime(long beforeTime) {
		return System.currentTimeMillis() - beforeTime;
	}

	public static int currentSecs() {
		int l;
		l = (int) (new Date().getTime() / 1000);
		return l;
	}
}
