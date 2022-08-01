package com.citiustech.task;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CandidateStreamingOperations {

	public static void main(String[] args) {
				
				List<Candidate> listOfCandidates = InterviewRepository.getCandidateList();
				
				
				List<Candidate> candidates = listOfCandidates.stream().filter(candidate->candidate.getCity().equalsIgnoreCase("Pune")).collect(Collectors.toList());
				System.out.println("List of Pune Candidates:");
				if(candidates!=null && !candidates.isEmpty()) {
					for(Candidate cand:candidates) {
						System.out.println(cand);
					}
				}
				System.out.println();
				
				
				//list city and count of candidates per city
				Map<String, Long> mapCandidatePerCity=listOfCandidates.stream().collect(Collectors.groupingBy(Candidate::getCity,Collectors.counting()));
				System.out.println("Candidate count per city");
				if(mapCandidatePerCity!=null && !mapCandidatePerCity.isEmpty()) {
					Iterator<Map.Entry<String, Long>> iterator = mapCandidatePerCity.entrySet().iterator();
					while(iterator.hasNext()) {
						Map.Entry<String, Long> entry = iterator.next();
				        System.out.println(entry.getKey() + ":" + entry.getValue());
					}
				}
				
				System.out.println();
				

				//list technical expertise and count of candidates
				Map<String, Long> mapCandidateByTechnicalExpertise=listOfCandidates.stream().collect(Collectors.groupingBy(Candidate::getTechnicalExpertise,Collectors.counting()));
				System.out.println("Candidate count by Technical Expertise");
				if(mapCandidateByTechnicalExpertise!=null && !mapCandidateByTechnicalExpertise.isEmpty()) {
					Iterator<Map.Entry<String, Long>> iterator = mapCandidateByTechnicalExpertise.entrySet().iterator();
					while(iterator.hasNext()) {
						Map.Entry<String, Long> entry = iterator.next();
				        System.out.println(entry.getKey() + ":" + entry.getValue());
					}
				}
				System.out.println();
				
				//list fresher candidates
				
				List<Candidate> fresherCandidates = listOfCandidates.stream().filter(candidate->candidate.getYearsOfExperience()==0).collect(Collectors.toList());
				System.out.println("Fresher Candidate list");
				if(fresherCandidates!=null && !fresherCandidates.isEmpty()) {
					for(Candidate fresher:fresherCandidates) {
						System.out.println(fresher);
					}
				}
				System.out.println();
				
				//listing candidates with highest experience
				System.out.println("Sorted List of Candidates by Experience");
				listOfCandidates.stream().sorted(Comparator.comparingInt(Candidate::getYearsOfExperience)).forEach(System.out::println);
				System.out.println();
				

				//sort the candidates by city name
				printLine();
				System.out.println("Sorted List of Candidates by City Name");
				listOfCandidates.stream().sorted(Comparator.comparing(Candidate::getCity)).forEach(System.out::println);
			}

			private static void printLine() {
				// TODO Auto-generated method stub
				System.out.println("======================================================");
			}

}
