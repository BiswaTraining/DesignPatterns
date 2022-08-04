package com.citiustech.Creational.PrototypePattern;

public class DeepCopyProduct implements Cloneable{
	Integer id;
	String name;
	Double price;
	Double qty;
	DeepCopyCategory category;
	
	public DeepCopyProduct(Integer id, String name, Double price, Double qty, DeepCopyCategory category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.category = category;
	}
	
	public DeepCopyProduct clone() throws CloneNotSupportedException {
		DeepCopyProduct p=(DeepCopyProduct)super.clone();
		p.category=(DeepCopyCategory)category.clone();
		return  p;
		 
		 
	}

	
	@Override
	public String toString() {
		return "DeepCopyProduct [id=" + id + ", name=" + name + ", price=" + price + ", qty=" + qty + ", category="
				+ category + "]";
	}

}
