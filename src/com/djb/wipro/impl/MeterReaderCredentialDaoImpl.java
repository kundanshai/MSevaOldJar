/*package com.djb.wipro.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jettison.json.JSONObject;

import com.djb.wipro.dao.MeterReaderCredentialDao;
import com.djb.wipro.model.BillRoundDetails;
import com.djb.wipro.model.WebServiceUserDetails;
import com.djb.wipro.util.AppLog;
import com.djb.wipro.util.DBConnector;

public class MeterReaderCredentialDaoImpl implements MeterReaderCredentialDao {

	
	@Override
	public WebServiceUserDetails getCredentials(JSONObject jsonObject) {
		//AppLog.begin(sessionDetails);
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Statement statement = null;
		
		WebServiceUserDetails webServiceUserDetails =new WebServiceUserDetails();
		try {
			String empId=(String)jsonObject.get("empId");
			String password=(String)jsonObject.get("password");
			String query="SELECT U.USER_ID, M.EMP_ID, U.USER_PASSWORD FROM DJB_WEB_SERVICE_USERS U, DJB_MTR_RDR M WHERE U.USER_ID = M.HHD_ID AND U.EFF_FROM_DATE <= SYSDATE AND (U.EFF_TO_DATE >= SYSDATE OR U.EFF_TO_DATE IS NULL) AND U.USER_PASSWORD ="+"'"+password+"'" + "AND  M.EMP_ID ="+"'"+empId+"'";
			conn = DBConnector.getConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery(query);
			AppLog.begin("credential query to fetch records "+query);
				while (rs.next()) {
					webServiceUserDetails.setHhdID(rs.getString("USER_ID"));
					webServiceUserDetails.setId(rs.getString("EMP_ID"));
					webServiceUserDetails.setPassword(rs.getString("USER_PASSWORD"));
				}
			
		} catch (SQLException e) {
			AppLog.error(e);
		} catch (IOException e) {
			AppLog.error(e);
		} catch (Exception e) {
			AppLog.error(e);
		} finally {
			try {
				
				DBConnector.closeConnection(conn, ps, rs);
			} catch (Exception e) {
				AppLog.error(e);
			}
		}
		AppLog.info("getCredentials method execute");
		return webServiceUserDetails;

	}

	@Override
	public List<BillRoundDetails> getBillRoundDetails() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Statement statement = null;
		List<BillRoundDetails> billRoundDetailsList=new ArrayList<BillRoundDetails>();
		try{
			String query="SELECT BILL_ROUND_ID,BILL_WIN_STAT_ID,START_DATE,END_DATE,BILL_WIN_FLG from CM_BILL_WINDOW where BILL_WIN_STAT_ID='10'";
			conn = DBConnector.getConnection();
			statement = conn.createStatement();
			rs = statement.executeQuery(query);
				
			while (rs.next()) {
				BillRoundDetails billRoundDetails=new BillRoundDetails();
				billRoundDetails.setBillRoundId(rs.getString("BILL_ROUND_ID"));
				billRoundDetails.setBillWinflag(rs.getString("BILL_WIN_FLG"));
				billRoundDetails.setBillWinStatId(rs.getString("BILL_WIN_STAT_ID"));
				billRoundDetails.setEndDate(rs.getString("BILL_ROUND_ID"));
				billRoundDetails.setStartDate(rs.getString("START_DATE"));
				billRoundDetailsList.add(billRoundDetails);
			}
			AppLog.begin("Bill Round Details fetch records "+query);
		} catch (SQLException e) {
			AppLog.error(e);
		} catch (IOException e) {
			AppLog.error(e);
		} catch (Exception e) {
			AppLog.error(e);
		} finally {
			try {
				
				DBConnector.closeConnection(conn, ps, rs);
			} catch (Exception e) {
				AppLog.error(e);
			}
		}
		return billRoundDetailsList;
		
	}

}
*/