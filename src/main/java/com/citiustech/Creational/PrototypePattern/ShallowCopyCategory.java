package com.citiustech.Creational.PrototypePattern;

public class ShallowCopyCategory {
	Integer id;
	String type;
	public ShallowCopyCategory(Integer id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	@Override
	public String toString() {
		return "ShallowCopyCategory [id=" + id + ", type=" + type + "]";
	}
	
}
