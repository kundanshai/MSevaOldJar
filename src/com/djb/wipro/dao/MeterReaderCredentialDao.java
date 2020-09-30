package com.djb.wipro.dao;

import java.util.List;

import org.codehaus.jettison.json.JSONObject;

import com.djb.wipro.model.BillRoundDetails;
import com.djb.wipro.model.WebServiceUserDetails;

public interface MeterReaderCredentialDao {

	public WebServiceUserDetails getCredentials(JSONObject jsonObject);
	
	public List<BillRoundDetails> getBillRoundDetails();
}
