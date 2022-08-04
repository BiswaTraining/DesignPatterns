package com.citiustech.task2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@FunctionalInterface
interface Shows{ 
	public void displayAllShows() throws FileNotFoundException, IOException; 
}


public class ShowImpl implements Shows{

	@Override
	public void displayAllShows() throws FileNotFoundException, IOException {
		ShowManagerImpl displayAllShows=new ShowManagerImpl();
		List<Show> shows=displayAllShows.populate();
		System.out.println("SHOWS ARE AS FOLLOWS::");
		shows.stream().forEach(System.out::println);
	}
	
}
