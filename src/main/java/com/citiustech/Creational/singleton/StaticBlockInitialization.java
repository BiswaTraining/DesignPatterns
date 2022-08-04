package com.citiustech.Creational.singleton;

public class StaticBlockInitialization {
	private static StaticBlockInitialization s;
	
	private StaticBlockInitialization(){}
	
	static{
        try{
            s = new StaticBlockInitialization();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

	public static  StaticBlockInitialization getInstance() {
		return s;
	}

	public static void main(String[] args) {
		StaticBlockInitialization s1=StaticBlockInitialization.getInstance();
		StaticBlockInitialization s2=StaticBlockInitialization.getInstance();
		System.out.println(s1+"  "+s2);
		System.out.println(s1.hashCode()+"  "+s2.hashCode());


	}

}
