package com.citiustech.task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.citiustech.task2.exceptions.InvalidSeatNumberException;
import com.citiustech.task2.exceptions.SeatsNotAvailableException;
import com.citiustech.task2.exceptions.UnknownShowException;

public class ShowManagerImpl implements ShowInterface{

	@Override
	public List<Show> populate() throws IOException,FileNotFoundException {
		File file = new File("C:\\Users\\BiswadeepB\\Documents\\workspaces\\DesignPatterns\\src\\main\\java\\com\\citiustech\\task2\\ShowDetails.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String allInputTextLines = br.lines().collect(Collectors.joining());
		List<Show> showList = new ArrayList<>();
		String[] showDetails =allInputTextLines.split("&<>");
		for(int i=0;i<showDetails.length;i++) {
			Show show=new Show();
			String eachShowDetail=showDetails[i];
			String[] showDetail=eachShowDetail.split(",");
			show.setShowName(showDetail[0]);
			show.setShowTime(showDetail[1]);
			show.setSeatsAvailable(Integer.parseInt(showDetail[2]));
			showList.add(show);
		}
		return showList;
	}

	@Override
	public void bookShow(List<Show> showList, String showName, String show_time, int noOfSeats)
			throws InvalidSeatNumberException, SeatsNotAvailableException, UnknownShowException {
		DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("d/MM/yyyy hh:mm:ss a");
		LocalDateTime inputTime = LocalDateTime.parse(show_time, dateTimeFormat);
		boolean isBookingSuccessful =false;
		boolean isShowNameCorrect=false;
		boolean isCorrectTimeForRespectiveShow=false;
		for(Show show:showList) {
			if(show.getShowName().equalsIgnoreCase(showName)) {
				isShowNameCorrect=true;
			}
			if(show.getShowName().equalsIgnoreCase(showName)
					&& LocalDateTime.parse(show.getShowTime(), dateTimeFormat).isEqual(inputTime)
					&& show.getSeatsAvailable()>=noOfSeats) {
				System.out.println("Booking successful");
				isBookingSuccessful =true;
				isCorrectTimeForRespectiveShow=true;
			}
			if(isBookingSuccessful) break;
			if(show.getShowName().equalsIgnoreCase(showName)&& LocalDateTime.parse(show.getShowTime(), dateTimeFormat).isEqual(inputTime)) {
				isCorrectTimeForRespectiveShow=true;
			}
			if(show.getShowName().equalsIgnoreCase(showName)
					&& LocalDateTime.parse(show.getShowTime(), dateTimeFormat).isEqual(inputTime)
					&& show.getSeatsAvailable()<noOfSeats) {
				throw new SeatsNotAvailableException("Please check the number of seats available and try again");
			}
		}
		if(!isShowNameCorrect) {
			throw new UnknownShowException("Please check the show name and try again");
		}
		if(isShowNameCorrect && !isCorrectTimeForRespectiveShow) {
			throw new InvalidSeatNumberException("Please check the time for the show and try again");
		}
		if(!isBookingSuccessful) {
			System.out.println("Unable to book");
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\BiswadeepB\\Documents\\workspaces\\DesignPatterns\\src\\main\\java\\com\\citiustech\\task2\\ShowDetails.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String allInputTextLines = br.lines().collect(Collectors.joining());
		List<Show> showList = new ArrayList<>();
		String[] showDetails =allInputTextLines.split("&<>");
		for(int i=0;i<showDetails.length;i++) {
			Show show=new Show();
			String eachShowDetail=showDetails[i];
			String[] showDetail=eachShowDetail.split(",");
			show.setShowName(showDetail[0]);
			show.setShowTime(showDetail[1]);
			show.setSeatsAvailable(Integer.parseInt(showDetail[2]));
			showList.add(show);
		}
		showList.stream().forEach(System.out::println);
		
		
		System.out.println("Time check");
		String show_time="04/08/2022 08:00:00 PM";
		DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("d/MM/yyyy hh:mm:ss a");
		LocalDateTime inputTime = LocalDateTime.parse(show_time, formatter_1);
		System.out.println(inputTime);
	}
	
}
