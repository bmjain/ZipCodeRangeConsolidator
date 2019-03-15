package com.zipcoderange.test;

import java.util.Random;

public class ZipCodeData {

	private static Integer max = 99999;
	private static Integer min = 10000;
	private static Random r=new Random();

	/*
	 * Function to Generate Random Data of ZipCode Ranges
	 */
	public String generateRandomData(int noOfZipCodeRanges) {
		String zipCodeRange = "";
		for (int i = 0; i < noOfZipCodeRanges; i++) {
			int lowerBound = r.nextInt((max - min) + 1) + min;
			int upperBound = r.nextInt((max - lowerBound) + 1) + lowerBound;
			zipCodeRange += "[" + lowerBound + "," + upperBound + "] ";
		}
		return zipCodeRange;
	}

	/*
	 * Function to Generate Overlapping Data of ZipCode Ranges
	 */
	public String generateOverlappingData(int noOfZipCodeRanges) {
		String zipCodeRange = "";
		for (int i = 0; i < noOfZipCodeRanges; i++) {
			int lowerBound = r.nextInt((max - min) + 1) + min;
			int upperBound = r.nextInt((max - lowerBound) + 1) + lowerBound;
			zipCodeRange += "[" + (lowerBound - 6) + "," + upperBound + "] ";
		}
		return zipCodeRange;
	}

}
