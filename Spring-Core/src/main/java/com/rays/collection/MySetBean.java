package com.rays.collection;

import java.util.Map;
import java.util.Set;

public class MySetBean {
	
	private Set<String> set;
	private Map<String, Object> map ;
	
	
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	public void displayData() {
		System.out.println("Set elements: " + set);
		System.out.println("Map entries: " + map);
	}


}
