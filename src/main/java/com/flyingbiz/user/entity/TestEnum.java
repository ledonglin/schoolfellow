package com.flyingbiz.user.entity;

public class TestEnum {

	
	public static void main(String args[]) {
		
		
		System.out.println(HoldType.FOREVER);
		System.out.println("永久".equals(HoldType.FOREVER));
		System.out.println("永久".equals(HoldType.FOREVER.toString()));
	}
	
}
