package com.djb.wipro.util;

import org.codehaus.jettison.json.JSONObject;

public class QueryContants {
	
	public static String getMtrRdrLoginCredentials(JSONObject jsonObject) {
		AppLog.begin();
		StringBuffer querySB = new StringBuffer();
		querySB
				.append("SELECT U.USER_ID, M.EMP_ID, U.USER_PASSWORD FROM DJB_WEB_SERVICE_USERS U, DJB_MTR_RDR M");
		querySB.append(" WHERE U.USER_ID = M.HHD_ID");
		querySB.append(" AND U.EFF_FROM_DATE <= SYSDATE");
		querySB
				.append(" AND (U.EFF_TO_DATE >= SYSDATE OR U.EFF_TO_DATE IS NULL)");
		querySB.append(" AND U.USER_ID = ?");

		querySB.append(" AND  M.EMP_ID = ?");
		
		AppLog.end();
		return querySB.toString();
	}	
}
