package com.defyApps.myandroidsamples.utils;

import android.util.Log;

public class Utils {

	/**
	 * 
	 * @param tag
	 * @param msg
	 * @param priority
	 * @return
	 */
	public static void logMessage(String tag, String msg, int priority) {

		switch (priority) {
		case Log.DEBUG:
			Log.d(tag, msg);
			break;
		case Log.ERROR:
			Log.e(tag, msg);
			break;
		case Log.INFO:
			Log.i(tag, msg);
			break;
		case Log.VERBOSE:
			Log.v(tag, msg);
			break;
		case Log.WARN:
			Log.w(tag, msg);
			break;
		default:
			// Do not log any thing here
			break;
		}

	}
}
