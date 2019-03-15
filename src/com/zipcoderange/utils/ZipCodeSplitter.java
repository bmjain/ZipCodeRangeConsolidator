package com.zipcoderange.utils;

import java.util.LinkedList;

import java.util.List;

import com.zipcoderange.models.ZipCode;

/*
 * 
 * Author: Bhavesh Jain
 * 
 */
public class ZipCodeSplitter {
	
	private String zipCodes;
	
	public ZipCodeSplitter(String zipCodes) {
		
		this.zipCodes = zipCodes;
	}
	
	public List<ZipCode> splitZipCode() {
		
		ZipCodeValidator zipCodeValidator = new ZipCodeValidator();
		//Split ZipCode ranges by Spaces to get each range as a different String
		String[] zipCodeRanges = this.zipCodes.split(" ");
		//Declare a List to store each ZipCode in a list
		List<ZipCode> zipCodeList = new LinkedList<ZipCode>();
		//Add ZipCode to the list after the Validation Check
		for(String zipCode : zipCodeRanges) {
			zipCodeList.add(zipCodeValidator.checkZipCodeValidity(bracketReplacerAndSplitter(zipCode)));
		}
		return zipCodeList;
	}
	
	//Method to replace brackets and also splitting the ZipCode into an Array of Strings
	public String[] bracketReplacerAndSplitter(String zipCodeRange) {
		return zipCodeRange.replaceAll("\\[|\\]", "").split(",");
	}

}
