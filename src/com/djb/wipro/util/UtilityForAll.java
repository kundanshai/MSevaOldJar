package com.djb.wipro.util;

public class UtilityForAll {

	
	public static boolean isEmptyString(String inputString) {
		boolean isEmpty = true;
		try {
			if (null != inputString && !"".equals(inputString.trim())) {
				isEmpty = false;
			}
		} catch (Exception e) {
			// Ignoring Exception
		}
		return isEmpty;
	}
}
