package com.zipcoderange.controller;

/*
 * Author: Bhavesh Jain
 */

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.zipcoderange.models.ZipCode;
import com.zipcoderange.utils.ZipCodeRangeConsolidator;
import com.zipcoderange.utils.ZipCodeSortAndCompare;
import com.zipcoderange.utils.ZipCodeSplitter;

public class RangeFinder {

	public static void main(String[] args) {
	
		//Get Zipcode Range from Command Line Arguments using Scanner class
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String containing the Zipcode Ranges.");
		String zipCodes = sc.nextLine();
		/*
		 * ZipCode Splitter splits the ZipCode ranges and validates Bound
		 * and also checks length of the ZipCode and also checks if it
		 * contains lower bound and upper bound or not
		 */
		ZipCodeSplitter zipCodeSplitter = new ZipCodeSplitter(zipCodes);
		List<ZipCode> zipCodeList = zipCodeSplitter.splitZipCode();
		/*
		 * Sort and Compare sorts the List of Zip code ranges in Decreasing order
		 * by comparing their lower bounds
		 */
		ZipCodeSortAndCompare zipCodeSortAndCompare = new ZipCodeSortAndCompare(zipCodeList);
		zipCodeList = zipCodeSortAndCompare.sortAndCompare();
		/*
		 * ZipCodeConsolidator merges the overlapping & sorted ZipCode 
		 * and gives us the final result
		 */
		ZipCodeRangeConsolidator zipCodeRangeConsolidator = new ZipCodeRangeConsolidator(zipCodeList);
		zipCodeList = zipCodeRangeConsolidator.consolidateRanges();
		/*
		 * Since the Order of ZipCode is in decreasing order.
		 * We need to reverse and then print the List
		 * 
		 */
		Collections.reverse(zipCodeList);
		printZipCode(zipCodeList);
		sc.close();
	}
	
	//Method to print the ZipCode as Ranges
	public static void printZipCode(List<ZipCode> zip) {
		
		for(ZipCode z : zip) {
			System.out.println("["+z.getLowerBound() + ","+ z.getUpperBound()+"]");
		}
		
	}

}
