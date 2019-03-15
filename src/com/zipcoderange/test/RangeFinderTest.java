/**
 * 
 */
package com.zipcoderange.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;

import com.zipcoderange.models.ZipCode;
import com.zipcoderange.utils.ZipCodeRangeConsolidator;
import com.zipcoderange.utils.ZipCodeSortAndCompare;
import com.zipcoderange.utils.ZipCodeSplitter;

/**
 * @author Bhavesh Jain
 *
 */
public class RangeFinderTest {

	  @Test
	  public void RandomZipCodeRanges() {
	    ZipCodeData zipCodeData = new ZipCodeData();
	    String zipCodeRanges = zipCodeData.generateRandomData(50);
	    ZipCodeSplitter zipCodeSplitter = new ZipCodeSplitter(zipCodeRanges);
	    List<ZipCode> zipCodeList = zipCodeSplitter.splitZipCode();
	    assertTrue(zipCodeList.size() > 0);
	  }

	  @Test
	  public void overlappingZipCodeRanges() {
		ZipCodeData zipCodeData = new ZipCodeData();
	    String zipCodeRanges = zipCodeData.generateOverlappingData(5);
	    ZipCodeSplitter zipCodeSplitter = new ZipCodeSplitter(zipCodeRanges);
	    List<ZipCode> zipCodeList = zipCodeSplitter.splitZipCode();
	    ZipCodeSortAndCompare zipCodeSortAndCompare = new ZipCodeSortAndCompare(zipCodeList);
	    zipCodeList = zipCodeSortAndCompare.sortAndCompare();
	    ZipCodeRangeConsolidator zipCodeRangeConsolidator = new ZipCodeRangeConsolidator(zipCodeList);
	    zipCodeList = zipCodeRangeConsolidator.consolidateRanges();
	    assertTrue(zipCodeList.size() == 1);
	  }

	  @Test
	  public void checkIllegalArgumentException() {
	    try {
	      String zipCodeRanges = "[95825,92830] [95001,95004]";
	      ZipCodeSplitter zipCodeSplitter = new ZipCodeSplitter(zipCodeRanges);
		  zipCodeSplitter.splitZipCode();
	    } catch (IllegalArgumentException e) {
	      assertEquals("IllegalArgumentException", e.getClass().getSimpleName());
	    }
	  }

	  @Test
	  public void checkZipCodeRangeValidity() {
	    try {
	      String zipCodeRanges = "[92004,92002,92003] [92003,92004]";
	      ZipCodeSplitter zipCodeSplitter = new ZipCodeSplitter(zipCodeRanges);
		  zipCodeSplitter.splitZipCode();
	    } catch (IllegalArgumentException e) {
	      assertEquals("IllegalArgumentException", e.getClass().getSimpleName());
	    }
	  }

	  @Test
	  public void checkZipCodeBoundValidity() {
	    try {
	      String zipCodeRanges = "[95825,92822] [95001,95004]";
	      ZipCodeSplitter zipCodeSplitter = new ZipCodeSplitter(zipCodeRanges);
		  zipCodeSplitter.splitZipCode();
	    } catch (IllegalArgumentException e) {
	    	assertEquals("IllegalArgumentException", e.getClass().getSimpleName());
	    }
	  }
	  
	  @Test
	  public void checkZipCodeLengthValidity() {
	    try {
	      String zipCodeRanges = "[9582,92822] [95001,95004]";
	      ZipCodeSplitter zipCodeSplitter = new ZipCodeSplitter(zipCodeRanges);
		  zipCodeSplitter.splitZipCode();
	    } catch (IllegalArgumentException e) {
	    	assertEquals("IllegalArgumentException", e.getClass().getSimpleName());
	    }
	  }
	  
	  @Test
	  public void checkZipCodeHasBothValues() {
	    try {
	      String zipCodeRanges = "[92822] [95001,95004]";
	      ZipCodeSplitter zipCodeSplitter = new ZipCodeSplitter(zipCodeRanges);
		  zipCodeSplitter.splitZipCode();
	    } catch (IllegalArgumentException e) {
	    	assertEquals("IllegalArgumentException", e.getClass().getSimpleName());
	    }
	  }
}
