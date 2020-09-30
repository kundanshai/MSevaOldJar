package com.djb.wipro.model;

public class BillRoundDetails {
	
	private String billRoundId;
	private String billWinStatId;
	private String startDate;
	private String endDate;
	private String billWinflag;
	public String getBillRoundId() {
		return billRoundId;
	}
	public void setBillRoundId(String billRoundId) {
		this.billRoundId = billRoundId;
	}
	public String getBillWinStatId() {
		return billWinStatId;
	}
	public void setBillWinStatId(String billWinStatId) {
		this.billWinStatId = billWinStatId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getBillWinflag() {
		return billWinflag;
	}
	public void setBillWinflag(String billWinflag) {
		this.billWinflag = billWinflag;
	}
	
}
