package com.stepdefinition;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Sample {

	public static void main(String[] args) {
		// 2DWith header

		List<Map<String, String>> li = new LinkedList<Map<String, String>>();

		// inner map
		Map<String, String> mp = new LinkedHashMap<>();
		mp.put("Name", "Raja");
		mp.put("Age", "23");
		mp.put("Email", "Raja12@gmail.com");
		mp.put("id", "234");

		Map<String, String> mp1 = new LinkedHashMap<>();
		mp1.put("Name", "Gowtham");
		mp1.put("Age", "233");
		mp1.put("Email", "Gowtham234@gmail.com");
		mp1.put("id", "23467");

		// To add map values in to list
		li.add(mp);// 0
		li.add(mp1);// 1

		System.out.println(li.get(0).get("Email"));

	}
}
