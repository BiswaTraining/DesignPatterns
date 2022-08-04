package com.citiustech.Creational.PrototypePattern;

public class ShallowCopyProduct implements Cloneable{
	Integer id;
	String name;
	Double price;
	Double qty;
	ShallowCopyCategory category;
	
	public ShallowCopyProduct(Integer id, String name, Double price, Double qty, ShallowCopyCategory category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.category = category;
	}
	
	public ShallowCopyProduct clone() throws CloneNotSupportedException {
		ShallowCopyProduct p=(ShallowCopyProduct)super.clone();
		return  p;
		 
		 
	}

	@Override
	public String toString() {
		return "ShallowCopyProduct [id=" + id + ", name=" + name + ", price=" + price + ", qty=" + qty + ", category="
				+ category + "]";
	}
}
