package com.dd.o2o.util;

import javax.servlet.http.HttpServletRequest;

public class HttpServletRequestUtil {
	public static int getInt(HttpServletRequest request, String key) {
		try {
			return Integer.decode(request.getParameter(key));
		} catch (Exception e) {
			return -1;
		}
	}

	public static Long getLong(HttpServletRequest request, String key) {
		try {
			return Long.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return (long) -1;
		}
	}

	public static Double getDouble(HttpServletRequest request, String key) {
		try {
			return Double.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return -1d;
		}
	}

	public static boolean getBoolean(HttpServletRequest request, String key) {
		try {
			return Boolean.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return false;
		}
	}

	public static String getString(HttpServletRequest request, String key) {
		try {
			String result = request.getParameter(key);
			if (result != null) {
				result.trim();
			}
			if ("".equals(result)) {
				return null;
			}
			return result;
		} catch (Exception e) {
			return null;
		}
	}
}
