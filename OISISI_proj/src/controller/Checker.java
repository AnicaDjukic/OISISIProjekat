package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Checker {
	
	public static boolean isNameOrSurename(String str) {
		str = str.toLowerCase();
		String regEx = "[a-z]+";
		if(str.matches(regEx))
			return true;
		return false;
	}
	
	public static boolean isValidDate(String str) {
		SimpleDateFormat dateValidaterCol = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dateValidaterDot = new SimpleDateFormat("dd.MM.yyyy");
		boolean suc = false;
		try {
	    	 dateValidaterCol.parse(str);
	         suc = true;
	     }
	     catch(ParseException e){
	          suc = false;
	     }
		
		try {
			dateValidaterDot.parse(str);
	         suc = true;
	     }
	     catch(ParseException e){
	          suc = false;
	     }
		
		return suc;
	}
	
	public static boolean isValidAdrress(String str) {
		str = str.toLowerCase();
		String regEx = "([a-z]+[\\s])+[1-9][0-9]{0,2}";
		
		if(str.matches(regEx))
			return true;
		return false;
	}
	
	public static boolean isValidNumber(String str) {
		String regEx = "[0-9]+";
		
		if(str.matches(regEx))
			return true;
		return false;
	}
	
	public static boolean isValidEmail(String str) {
		str = str.toLowerCase();
		String regEx = ".+@.+";
		if(str.matches(regEx))
			return true;
		return false;
	}
	
	public static boolean isValidTitOrMaj(String str) {
		str = str.toLowerCase();
		String regEx = "[a-z]+([\\s][a-z]+)*";
		if(str.matches(regEx))
			return true;
		return false;
	}
}
