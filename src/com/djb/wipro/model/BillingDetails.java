/************************************************************************************************************
 * @(#) BillingDetails.java 1.0 19 May 2015
 * Copyright (c) Tata Consultancy Services Ltd.
 *
 *************************************************************************************************************/
package com.djb.wipro.model;

import java.util.List;


public class BillingDetails {
	
	List<BillDetails> billingList;

	public List<BillDetails> getBillingList() {
		return billingList;
	}

	public void setBillingList(List<BillDetails> billingList) {
		this.billingList = billingList;
	}
	
}
