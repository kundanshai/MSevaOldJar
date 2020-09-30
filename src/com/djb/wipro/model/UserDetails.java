package com.djb.wipro.model;

import java.util.List;


public class UserDetails {
	
	ConsumerBean consumerBean;
	
	List<ProofOfIdentity> proofOfIdentityList;
	
	private String Page;

	private String Password;

	public String premiseId;

	private String SecPasswrd;
	
	private String type;
	
	String userGroup;

	private String UserName;

	private String ValidFlag;

	private String ZroLocation;
	
	private String reportVfsUser;

	public ConsumerBean getConsumerBean() {
		return consumerBean;
	}

	public void setConsumerBean(ConsumerBean consumerBean) {
		this.consumerBean = consumerBean;
	}

	public String getPage() {
		return Page;
	}

	public void setPage(String page) {
		Page = page;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getPremiseId() {
		return premiseId;
	}

	public void setPremiseId(String premiseId) {
		this.premiseId = premiseId;
	}

	public String getSecPasswrd() {
		return SecPasswrd;
	}

	public void setSecPasswrd(String secPasswrd) {
		SecPasswrd = secPasswrd;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getValidFlag() {
		return ValidFlag;
	}

	public void setValidFlag(String validFlag) {
		ValidFlag = validFlag;
	}

	public String getZroLocation() {
		return ZroLocation;
	}

	public void setZroLocation(String zroLocation) {
		ZroLocation = zroLocation;
	}

	public String getReportVfsUser() {
		return reportVfsUser;
	}

	public void setReportVfsUser(String reportVfsUser) {
		this.reportVfsUser = reportVfsUser;
	}

	public List<ProofOfIdentity> getProofOfIdentityList() {
		return proofOfIdentityList;
	}

	public void setProofOfIdentityList(List<ProofOfIdentity> proofOfIdentityList) {
		this.proofOfIdentityList = proofOfIdentityList;
	}
	
}
