package com.taven.app.javabase.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * JAVA的排序工具类：
 * Arrays.sort(arrs);
 * Collections.sort(uList);
 * 
 * @author Taven.Li
 *
 */
public class ComparableDemo {

	public static void main(String[] args) {
		List<UserDTO> uList = new ArrayList<ComparableDemo.UserDTO>();
		uList.add(new ComparableDemo().new UserDTO(1));
		uList.add(new ComparableDemo().new UserDTO(3));
		uList.add(new ComparableDemo().new UserDTO(2));
		
		//方式1：类实现Comparable接口
		Collections.sort(uList);
		
		//方式2：类无须实现Comparable接口
		Collections.sort(uList, new Comparator<ComparableDemo.UserDTO>() {
			@Override
			public int compare(UserDTO o1, UserDTO o2) {
				//小于-1、等于0, 大于1
				return o1.getAge() < o2.getAge() ? -1 : o1.getAge() == o2.getAge() ? 0 : 1;
			}
			
		});
		
		//数组反转
		Collections.reverse(uList);
		
	}
	
	public class UserDTO implements Comparable<UserDTO>{

		private int age;
		private String name;
		
		public UserDTO(int age){
			this.age = age;
			this.name = "boy_"+age;
		}
		/* 
		 * 
		 */
		@Override
		public int compareTo(UserDTO o) {
			//小于-1、等于0, 大于1
			return this.age < o.getAge() ? -1 : this.age == o.getAge() ? 0 : 1;
			
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
		
	}
}
