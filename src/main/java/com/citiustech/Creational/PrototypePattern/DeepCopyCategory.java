package com.citiustech.Creational.PrototypePattern;

public class DeepCopyCategory implements Cloneable{
	Integer id;
	String type;
	public DeepCopyCategory(Integer id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	
	 public Object clone() throws CloneNotSupportedException { 
		 return	super.clone();
	 }


	@Override
	public String toString() {
		return "DeepCopyCategory [id=" + id + ", type=" + type + "]";
	}
	 

}
