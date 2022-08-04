package com.citiustech.Creational.singleton;

public class ThreadSafeSingleton {
	private static ThreadSafeSingleton threadSafe;
	
	private ThreadSafeSingleton() {}
	
	public static synchronized ThreadSafeSingleton getInstance() {
		if(threadSafe==null) {
			threadSafe=new ThreadSafeSingleton();
		}
		return threadSafe;
	}
	
	
	public static void main(String[] args) {
		ThreadSafeSingleton thread1 = ThreadSafeSingleton.getInstance();
		ThreadSafeSingleton thread2 = ThreadSafeSingleton.getInstance();
		System.out.println(thread1+" "+thread2);
		System.out.println(thread1.hashCode()+" "+thread2.hashCode());

	}

}
