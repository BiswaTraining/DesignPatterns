package com.citiustech.Creational.singleton;

public class EagerInitialization {
	private static EagerInitialization eager=new EagerInitialization();
	
	private EagerInitialization() {}
	
	public static EagerInitialization getInstance() {
		return eager;
	}
	
	public static void main(String[] args) {
				EagerInitialization s1=EagerInitialization.getInstance();
				EagerInitialization s2=EagerInitialization.getInstance();
				System.out.println(s1+"  "+s2);
				System.out.println(s1.hashCode()+"  "+s2.hashCode());
	}
}
