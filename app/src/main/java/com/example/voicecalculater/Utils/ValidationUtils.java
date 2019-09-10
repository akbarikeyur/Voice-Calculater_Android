package com.example.voicecalculater.Utils;

public class ValidationUtils {
	
	static String REGEX_CALCULATE_VALUES = "^[0-9x\\/\\-+]+$";
	
	 public static boolean calculateValue(String string)
	{
		return string.matches(REGEX_CALCULATE_VALUES);
	}
}
