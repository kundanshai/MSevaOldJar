package com.djb.wipro.dao;

import java.util.List;

import com.djb.wipro.model.BillDetails;
import com.djb.wipro.model.ProofOfIdentity;
import com.djb.wipro.model.TemporaryDisconnection;
import com.djb.wipro.model.UserDetails;


public interface DisconnectionAndReopenDao {
	
  public List<TemporaryDisconnection> listTemporaryDisconnection();
  
  public String checkKnoValidate(String kno);
  
  public UserDetails fetchCustomerData(String kno);
  
  public List<ProofOfIdentity> proofOfIdentityList();
  
  public String getAccessStatus(String kno,String chDisconnect);
  
  public List<BillDetails> getLatestBillDetails(String kno);
}
