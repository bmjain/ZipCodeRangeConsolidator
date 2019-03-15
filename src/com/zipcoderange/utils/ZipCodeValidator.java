package com.zipcoderange.utils;

import com.zipcoderange.models.ZipCode;

public class ZipCodeValidator {

	public ZipCode checkZipCodeValidity(String[] zipCodeBounds) {
		// check if it contains both lower bound and upper bound
		if (zipCodeBounds.length != 2)
			throw new IllegalArgumentException("The zipCode entered does not contain upper bounds and lower bounds");
		Integer lowerBound = convertToString(zipCodeBounds[0]);
		Integer upperBound = convertToString(zipCodeBounds[1]);
		ZipCode zipCode = null;
		if (checkBoundValidity(lowerBound, upperBound) && checkZipCodeLength(zipCodeBounds[0], zipCodeBounds[1]))
			zipCode = new ZipCode(lowerBound, upperBound);
		else
			throw new IllegalArgumentException("The zipCode Bounds are not valid");
		return zipCode;
	}

	//Method to check if the Upper Bound of ZipCode is greater than Lower Bound
	public Boolean checkBoundValidity(Integer lowerbound, Integer upperbound) {
		return upperbound >= lowerbound ? true : false;
	}

	public Integer convertToString(String zipCode) {
		return Integer.parseInt(zipCode);
	}

	//Method to check if the ZipCode is 5 digit in Length
	public Boolean checkZipCodeLength(String lowerBound, String upperBound) {
		return lowerBound.length() == 5 && upperBound.length() == 5;
	}

}
