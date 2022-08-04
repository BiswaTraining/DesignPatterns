package com.citiustech.task2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.citiustech.task2.exceptions.InvalidSeatNumberException;
import com.citiustech.task2.exceptions.SeatsNotAvailableException;
import com.citiustech.task2.exceptions.UnknownShowException;

public class ShowBookingSystem {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<Show> list=new ArrayList<Show>();
		
		ShowManagerImpl dmi=new ShowManagerImpl();
		list=dmi.populate();
		System.out.println("SHOWS ARE AS FOLLOWS::");
		list.stream().forEach(System.out::println);

		try {
			dmi.bookShow(list, "Sahi re Sahi", "04/08/2022 08:00:00 PM", 3);
		}catch(InvalidSeatNumberException inv) {
			System.out.println(inv.getMessage());
		}catch(UnknownShowException unk) {
			System.out.println(unk.getMessage());
		}catch(SeatsNotAvailableException seat){
			System.out.println(seat.getMessage());
		}	catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
