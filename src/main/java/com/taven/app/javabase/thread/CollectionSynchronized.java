package com.taven.app.javabase.thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionSynchronized {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args)
	{
		/**
		 * Collections 中提供了多个 synchronizedXxx 方法，可以将指定集合包装成线程安全的集合
		 * 
		 * 另外还提供了不可变集合的方法
		 * 
		 * emptyXxx() 反悔一个空的，不可变集合对象
		 * singletonXxx() 返回一个只有一个元素的不可变集合对象
		 * unmodifiableXxx() 返回指定集合对象的不可变视图
		 * 
		 */

		//下面程序创建了四个同步的集合对象
		Collection c = Collections.synchronizedCollection(new ArrayList());

		List list = Collections.synchronizedList(new ArrayList());

		Set s = Collections.synchronizedSet(new HashSet());

		Map m = Collections.synchronizedMap(new HashMap());

	}

}
