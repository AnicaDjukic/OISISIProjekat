package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

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
		boolean suc = false;		
		
		DateTimeFormatter dtf;
		LocalDate d = null;
		String[] parts = str.split("\\.");
		
		for(int i = 0; i < GlobalConstants.regExDatePoss.length; i++) {
			try {
				dtf = DateTimeFormatter.ofPattern(GlobalConstants.regExDatePoss[i]);
				d = LocalDate.parse(str, dtf);
				System.out.println(parts.length);
				suc = true;
				break;
			}catch(Exception ex) {
				suc = false;
			}
			if(suc)
				break;
		}
		
		if(suc)
			if(d.getYear() < 1920)
				suc = false;
		
		if(suc) {
			switch(parts[1]) {
			case "1" :
			case "3" :
			case "5" :
			case "7" :
			case "8" :
			case "10" :
			case "12" : {
				if(Integer.parseInt(parts[0]) <= 0 || Integer.parseInt(parts[0]) >= 32)
					suc = false;
				break;
			}
			case "4" :
			case "6" :
			case "9" :
			case "11" :{
				if(Integer.parseInt(parts[0]) <= 0 || Integer.parseInt(parts[0]) >= 31)
					suc = false;
				break;
			}
			case "2" :{
				if(d.getYear() % 4 == 0) {
					if(Integer.parseInt(parts[0]) <= 0 || Integer.parseInt(parts[0]) >= 29)
						suc = false;
				}else {
					if(Integer.parseInt(parts[0]) <= 0 || Integer.parseInt(parts[0]) >= 28)
						suc = false;
				}
				break;
			}	
			}
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
		if(str.matches(regEx) && isValidYear(str.substring(str.length()-4)))
			return true;
		return false;
		
	}
	
	public static boolean isValidYear(String str) {
		String regEx = GlobalConstants.regGodUpisa;
		if(!str.matches(regEx))
			return false;
		int year = Integer.parseInt(str);
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		if(2000 <= year && year <= thisYear)
			return true;
		return false;
	}
}
