package com.citiustech.Structural.AdapterPattern;


public interface ElectricSocketAdapter {

	public ElectricVolt get120Volt();
		
	public ElectricVolt get12Volt();
	
	public ElectricVolt get3Volt();
}
