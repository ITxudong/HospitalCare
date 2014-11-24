package com.kaishengit.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kaishengit.pojo.Patient;

public class Circulate {

	
	@SuppressWarnings("rawtypes")
	public static List getNames(List<Patient> list) {
		List<Map> maps = new ArrayList<Map>();
		for(Patient p : list) {
			Map<String ,Object> map = new HashMap<String ,Object>();
			map.put("value", p.getName());
			maps.add(map);
		}
		return maps;
	}
	
}
