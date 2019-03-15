package com.zipcoderange.models;
/*
 * Author:Bhavesh Jain
 */
public class ZipCode {
	
	/*
	 * Model to get & set ZipCode Lower Bound and Upper Bound
	 */
	
	private int lowerBound;
	private int upperBound;
	
	
	public ZipCode(int lowerBound,int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	
	public Integer getLowerBound() {
		return lowerBound;
	}
	
	public void setLowerBound(Integer lowerBound) {
		this.lowerBound = lowerBound;
	}
	
	public Integer getUpperBound() {
		return upperBound;
	}
	
	public void setUpperBound(Integer upperBound) {
		this.upperBound = upperBound;
	}
	
	

}
