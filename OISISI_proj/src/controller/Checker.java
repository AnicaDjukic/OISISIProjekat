package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import model.GlobalConstants;

public class Checker {
	
	public static boolean isNameOrSurename(String str) {
		str = str.toLowerCase();
		String regEx = GlobalConstants.regExNameOrSurename;
		if(str.matches(regEx))
			return true;
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public static boolean isValidDate(String str) {
		Date d;
		SimpleDateFormat dateValidaterCol = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dateValidaterDot = new SimpleDateFormat("dd.MM.yyyy");
		boolean suc = false;
		try {
	    	 d = dateValidaterCol.parse(str);
	    	 if(d.after(new Date(0,0,1)))                        //Pošto je po novim kalendarima pa se na godinu doda 1900
	    		 suc = true;
	     }
	     catch(ParseException e){
	          suc = false;
	     }
		
		try {
			d = dateValidaterDot.parse(str);
			if(d.after(new Date(0,0,1)))
				suc = true;
	     }
	     catch(ParseException e){
	          suc = false;
	     }
		
		return suc;
	}
	
	public static boolean isValidAdrress(String str) {
		str = str.toLowerCase();
		String regEx = GlobalConstants.regExAddress;
		
		if(str.matches(regEx))
			return true;
		return false;
	}
	
	public static boolean isValidNumber(String str, int isLicKart) {
		String regEx = GlobalConstants.regExNumber;
		
		if(isLicKart == 0)
			if(str.matches(regEx) && (str.length() >= 6 && str.length() <= 10))
				return true;
		if(isLicKart == 1)
			if(str.matches(regEx) && str.length() == 9)
				return true;
			
		return false;
	}
	
	public static boolean isValidEmail(String str) {
		str = str.toLowerCase();
		String regEx = GlobalConstants.regExEmail;
		if(str.matches(regEx))
			return true;
		return false;
	}
	
	public static boolean isValidTitOrMaj(String str) {
		str = str.toLowerCase();
		String regEx = GlobalConstants.regExTitOrMaj;
		if(str.matches(regEx))
			return true;
		return false;
	}
	
	public static boolean isValidIndex(String str) {
		String regEx = GlobalConstants.regExBrIndexa;
		if(str.matches(regEx))
			return true;
		return false;
		
	}
	
	public static boolean isValidYear(String str) {
		String regEx = GlobalConstants.regGodUpisa;
		if(!str.matches(regEx))
			return false;
		int year = Integer.parseInt(str);
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		if(1990 <= year && year <= thisYear)
			return true;
		return false;
	}
}
