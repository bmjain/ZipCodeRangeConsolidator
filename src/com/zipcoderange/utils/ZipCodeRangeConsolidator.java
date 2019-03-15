package com.zipcoderange.utils;

import java.util.LinkedList;
import java.util.List;

import com.zipcoderange.models.ZipCode;

public class ZipCodeRangeConsolidator {

	private List<ZipCode> zipCodeList;
	private List<ZipCode> consolidatedZipCodeList = new LinkedList<ZipCode>();

	public ZipCodeRangeConsolidator(List<ZipCode> zipCodeList) {
		this.zipCodeList = zipCodeList;
	}

	public List<ZipCode> consolidateRanges() {
		//Index to be used to store values in final Array
		int lastElementIndex = 0;
		for (int i = 0; i < this.zipCodeList.size(); i++) {
			
			/*
			 * Check if it is not the starting index
			 * and check if the ZipCode overlaps with the previous one
			 */
			if (lastElementIndex != 0 && this.zipCodeList.get(i).getUpperBound() >= this.zipCodeList
					.get(lastElementIndex - 1).getLowerBound()) {
				
				while (lastElementIndex != 0 && this.zipCodeList.get(i).getUpperBound() >= this.zipCodeList
						.get(lastElementIndex - 1).getLowerBound()) {
					/*
					 * Merge Ranges from previous and current ZipCode
					 */
					this.zipCodeList.get(lastElementIndex - 1)
							.setUpperBound(Math.max(this.zipCodeList.get(lastElementIndex - 1).getUpperBound(),
									this.zipCodeList.get(i).getUpperBound()));
					this.zipCodeList.get(lastElementIndex - 1)
							.setLowerBound(Math.min(this.zipCodeList.get(lastElementIndex - 1).getLowerBound(),
									this.zipCodeList.get(i).getLowerBound()));
					lastElementIndex--;
				}
			} else {
				/*
				 * If it does not overlap, then add it to the result
				 */
				this.zipCodeList.add(lastElementIndex, this.zipCodeList.get(i));
			}
			lastElementIndex++;
		}
		return getResult(lastElementIndex);

	}
	
	//Method to return only those values in the list until Index 
	public List<ZipCode> getResult(int index) {
		for (int i = 0; i < index; i++)
			this.consolidatedZipCodeList.add(this.zipCodeList.get(i));
		return this.consolidatedZipCodeList;
	}

}
