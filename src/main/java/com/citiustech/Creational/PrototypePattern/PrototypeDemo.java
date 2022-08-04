package com.citiustech.Creational.PrototypePattern;

public class PrototypeDemo {

	public static void main(String[] args) throws CloneNotSupportedException{
		DeepCopyProduct p1=new DeepCopyProduct(1,"box",70.00,999.00,new DeepCopyCategory(101,"large"));
		System.out.println("Before  deep clone:"+p1.hashCode());
		DeepCopyProduct p2=p1.clone();
		System.out.println("After deep clone:"+p2.hashCode());
		
		System.out.println();
		System.out.println("Prototype Pattern by shallow clone");
		ShallowCopyProduct s1=new ShallowCopyProduct(1,"box",70.00,999.00,new ShallowCopyCategory(101,"large"));
		System.out.println("Before  shallow clone:"+s1.hashCode());
		ShallowCopyProduct s2=s1.clone();
		System.out.println("After shallow clone:"+s2.hashCode());
		

	}

}
