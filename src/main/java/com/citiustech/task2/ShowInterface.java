package com.citiustech.task2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.citiustech.task2.exceptions.InvalidSeatNumberException;
import com.citiustech.task2.exceptions.SeatsNotAvailableException;
import com.citiustech.task2.exceptions.UnknownShowException;

public interface ShowInterface {
	public List<Show> populate() throws FileNotFoundException, IOException;
	public void bookShow(List<Show> showList, String showName,String show_time, int noOfSeats) throws InvalidSeatNumberException, SeatsNotAvailableException, UnknownShowException;
}
