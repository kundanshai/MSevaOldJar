
package com.djb.wipro.model;

import java.util.List;


public class WebServiceUserDetails {
	
	private String authKey;
	private String hhdID;
	private String id;
	private String src;
    private String password;
    
    public List<BillRoundDetails> billRoundDetailsList;
    
	public String getAuthKey() {
		return authKey;
	}

	
	public String getHhdID() {
		return hhdID;
	}

	public String getId() {
		return id;
	}
	public String getSrc() {
		return src;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public void setHhdID(String hhdID) {
		this.hhdID = hhdID;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public void setSrc(String src) {
		this.src = src;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public List<BillRoundDetails> getBillRoundDetailsList() {
		return billRoundDetailsList;
	}


	public void setBillRoundDetailsList(List<BillRoundDetails> billRoundDetailsList) {
		this.billRoundDetailsList = billRoundDetailsList;
	}

}
