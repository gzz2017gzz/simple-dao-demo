package com.gzz.config;

/**
 * 数据源上下文：ThreadLocal 持有当前数据源 key
 */
public final class DataSourceHolder {

	private static final ThreadLocal<String> CONTEXT = new ThreadLocal<>();

	public static void set(String key) {
		CONTEXT.set(key);
	}

	public static String get() {
		return CONTEXT.get();
	}

	public static void clear() {
		CONTEXT.remove();
	}
}