package com.kaishengit.util;

import org.joda.time.DateTime;

public class AutoAgeSex {

	//�������֤�� ��ȡ������Ա�
	
	public static String getAge(String str) {
		
		String birth = str.substring(6,10);
		String y = DateTime.now().toString("yyyy");
		
		String ye = y.replace("-", "");
				
		int birthday = Integer.valueOf(birth);
		int year = Integer.valueOf(y);
		
		int age = year - birthday;
		return String.valueOf(age);
		
	}
	
	public static String getSex(String str) {
		
		Character ch = str.charAt(16);
		
		int sex = Integer.parseInt(ch.toString());
		
		if(sex%2 == 0) {
			return "Ů";
		} else {
			return "��";
		}
			
	}
	
	
	
}
