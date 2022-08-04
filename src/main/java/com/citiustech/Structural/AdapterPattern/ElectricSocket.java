package com.citiustech.Structural.AdapterPattern;


public class ElectricSocket {

	public ElectricVolt getVolt(){
		return new ElectricVolt(120);
	}
}
