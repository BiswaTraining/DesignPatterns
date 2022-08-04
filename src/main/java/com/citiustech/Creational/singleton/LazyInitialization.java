package com.citiustech.Creational.singleton;
/*The above implementation works fine in case of the single-threaded environment
 *  but when it comes to multithreaded systems, 
 *  it can cause issues if multiple threads are inside the if condition at the same time.
 *  It will destroy the singleton pattern and both threads will get the different
 *  instances of the singleton class.*/ 
public class LazyInitialization {
	private static LazyInitialization lazy=null;
	private LazyInitialization() {};
	
	public static LazyInitialization getInstance() {
		if(lazy==null) {
			lazy= new LazyInitialization();
		}
		return lazy;
	}
	public static void main(String[] args) {
		LazyInitialization lazy1 = LazyInitialization.getInstance();
		LazyInitialization lazy2 = LazyInitialization.getInstance();
		System.out.println(lazy1+" "+lazy2);
		System.out.println(lazy1.hashCode()+" "+lazy2.hashCode());

	}

}
