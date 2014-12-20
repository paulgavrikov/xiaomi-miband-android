package com.motioncoding.debugging;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class L {

	public static enum LogType {
		CLASS, CLASS_AND_METHOD, CLASS_AND_METHOD_AND_LINE, CLASS_AND_LINE
	}
	
	private static LogType mType = LogType.CLASS_AND_METHOD;
	
	
	public static void toast(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}
	
	public static void setLogType(LogType type) {
		mType = type;
	}
	
	public static void e(String msg) {
		Log.e(getTag(), msg);
	}
	
	public static void i(String msg) {
		Log.i(getTag(), msg);
	}
	
	public static void d(String msg) {
		Log.d(getTag(), msg);
	}
	
	public static void v(String msg) {
		Log.v(getTag(), msg);
	}
	
	public static void w(String msg) {
		Log.w(getTag(), msg);
	}
	
	public static void wtf(String msg) {
		Log.wtf(getTag(), msg);
	}
	
	private static String getTag() {
		StackTraceElement[] s = Thread.currentThread().getStackTrace();
		switch (mType) {
		case CLASS:
			return s[4].getClassName();
		case CLASS_AND_LINE:
			return s[4].getClassName()+":"+s[4].getLineNumber();
		case CLASS_AND_METHOD:
			return s[4].getClassName()+"."+s[4].getMethodName();
		case CLASS_AND_METHOD_AND_LINE:
			return s[4].getClassName()+"."+s[4].getMethodName()+":"+s[4].getLineNumber();
		default:
			break;
		}
		return null;
	}
}

