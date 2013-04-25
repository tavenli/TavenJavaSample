package com.taven.app.javabase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ForEach {

	public static void main(String[] args) {
		//请注意：
		//使用foreach循环迭代数组元素时，并不能改变数组元素的值（因为foreach循环时，循环中的变量是一个临时变量，对其赋值没有任何意义）

		Set<String> strings = new HashSet<String>();
		strings.add("taven");

		//方式1
		for (String str : strings) {
			str = "taven.li";
			System.out.println(str);
		}

		//方式2
		for (Iterator<String> strs = strings.iterator(); strs.hasNext();) {
			String str = strs.next();
			//这里输出的还是 taven ，而不会是 taven.li
			System.out.println(str);
		}

		//方式3
		while (strings.iterator().hasNext()) {

			String str = strings.iterator().next();
			System.out.println(str);

		}

		Map<String, Object> maps = new HashMap<String, Object>();

		//方式4
		for (Entry<String, Object> entry : maps.entrySet()) {

			System.out.println(entry.getKey());
			System.out.println(entry.getValue());

		}

		//方式5
		for (String key : maps.keySet()) {

			System.out.println("keys:" + key + " value:" + maps.get(key));

		}

	}
}
