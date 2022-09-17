package com.timeconverter.services;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class TimeConverterService {
	String onceArrays[] = {"zero","one","two","three","four","five","six","seven","eight","nine","ten",
			"eleven","twelve","thirteen","forteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	String tensArrays[] = {"twenty","thirty","forty","fifty"};
	public String getCurrentTimeInWords(int hours,int minutes) {
		if(minutes==0){
			if(hours == 12) {
				return "it's midday.";
			} 	
		}
		StringBuffer returnValue= new StringBuffer("it's ");
		if(hours == 0){
			returnValue.append("midnight");
		}else if(hours < 20) {
			returnValue.append( onceArrays[hours]);
		}else if(hours <= 24) {
			returnValue.append( convertToWords(hours));
		}else {
			return "Hours values is invalid";
		}
		if(minutes == 0) {
			return returnValue.toString();
		}
		returnValue.append(" ");
		if(minutes < 20) {
			returnValue.append(onceArrays[minutes]);
		}else {
			returnValue.append(convertToWords(minutes));
		}
		if(hours == 0 && minutes != 0){
			returnValue.append(" minutes");
		}
		return returnValue.toString();
	}
	
	
	private String convertToWords(int value) {
		Assert.isTrue(value>=20, "Value should be equals or more then 20.");
		int[] valueSplitContainer = CalculateMinutes(value);
		System.out.println("valueSplitContainer : "+valueSplitContainer);
		Assert.isTrue(valueSplitContainer.length == 2, "Passed value must have 2 digit.");
		StringBuffer convertedString = new StringBuffer(tensArrays[valueSplitContainer[0]-2]);
		convertedString.append(" ").append(onceArrays[valueSplitContainer[1]]);		
		System.out.println("convertedString :"+convertedString);
		return convertedString.toString();		
	}
	
	private int[] CalculateMinutes(int value) {		
		int valueSplitContainer[] = new int[2]; 
		int i = valueSplitContainer.length;
		while(!(value==0)) {
			valueSplitContainer[--i] = value%10;
			value = value/10;			
		}
		return valueSplitContainer;
	}

}
