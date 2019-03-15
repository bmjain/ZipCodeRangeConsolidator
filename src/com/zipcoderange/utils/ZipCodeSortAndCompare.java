package com.zipcoderange.utils;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.zipcoderange.models.ZipCode;

public class ZipCodeSortAndCompare {
	
	private List<ZipCode> zipCodeList;
	
	public ZipCodeSortAndCompare(List<ZipCode> zipCodeList) {
		this.zipCodeList = zipCodeList;
	}
	
	//Method to Sort the List of ZipCodes in Decreasing Order based on the Lower Bound
	public List<ZipCode> sortAndCompare() {
		Collections.sort(zipCodeList, new Comparator<ZipCode>() {
			public int compare(ZipCode zipCode1, ZipCode zipCode2)
			{
				return (zipCode1.getLowerBound() < zipCode2.getLowerBound()) ? 1 : -1;
			}
		});
		return zipCodeList;
	}
	

}
