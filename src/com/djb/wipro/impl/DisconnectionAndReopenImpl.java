package com.djb.wipro.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


import com.djb.wipro.dao.DisconnectionAndReopenDao;
import com.djb.wipro.exception.CCBServerErrorException;
import com.djb.wipro.model.BillDetails;
import com.djb.wipro.model.BillingDetails;
import com.djb.wipro.model.ConsumerBean;
import com.djb.wipro.model.ProofOfIdentity;
import com.djb.wipro.model.TemporaryDisconnection;
import com.djb.wipro.model.UserDetails;
import com.djb.wipro.util.AppLog;
import com.djb.wipro.util.DBConnector;
import com.djb.wipro.util.UtilityForAll;
import com.djb.wipro.util.XAIHTTPCall;



public class DisconnectionAndReopenImpl implements DisconnectionAndReopenDao {

	@Override
	public List<TemporaryDisconnection> listTemporaryDisconnection() {
		
		return null;
	}

	@Override
	public String checkKnoValidate(String kno) {
		
			AppLog.begin();
			StringBuffer xml = new StringBuffer(512);
			String xaiHTTPCallResponse;
			String status = "INVALID";
			try {
				xml.append("<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:cm='http://oracle.com/CM-CheckKNO.xsd'>");
				xml.append("<soapenv:Header />");
				xml.append("<soapenv:Body>");
				xml.append("<cm:CM-CheckKNO>");
				xml.append("<cm:KNO>" + kno + "</cm:KNO>");
				xml.append("<cm:Result>?</cm:Result>");
				xml.append("</cm:CM-CheckKNO>");
				xml.append("</soapenv:Body>");
				xml.append("</soapenv:Envelope>");
				AppLog.info("XAIHTTP Request xml::\n" + xml.toString());
				XAIHTTPCall xaiHTTPCall = new XAIHTTPCall();
				xaiHTTPCallResponse = xaiHTTPCall.callXAIServer(xml.toString());
				AppLog.info("XAIHTTP Call Response::\n" + xaiHTTPCallResponse);
				Document document = DocumentHelper.parseText(xaiHTTPCallResponse);
				Element root = document.getRootElement();
				for (Iterator i = root.elementIterator(); i.hasNext();) {
					Element element = (Element) i.next();
					for (Iterator i2 = element.elementIterator(); i2.hasNext();) {
						Element elementchild2 = (Element) i2.next();
						for (Iterator i3 = elementchild2.elementIterator(); i3
								.hasNext();) {
							Element elementchild3 = (Element) i3.next();
							status = elementchild3.getStringValue();
						}
					}
				}
			} catch (Exception e) {
				try {
					throw new CCBServerErrorException("CCb Server Down Or somethings went wrong in ccb !");
				} catch (CCBServerErrorException e1) {
					
					AppLog.error(e);
				}
				AppLog.error(e);
			}
			AppLog.end();
			return status;
	
	}

	@Override
	public UserDetails fetchCustomerData(String kno)  {
		AppLog.begin();		
		
		String xml = new StringBuffer(512).append("<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:cm='http://oracle.com/CM_RetrieveConsumerDetails.xsd'>"+
				  "<soapenv:Header/>"+
				  " <soapenv:Body>"+
				  "    <cm:CM_RetrieveConsumerDetails>"+
				  "       <cm:accountId>"+kno+"</cm:accountId>"+
				  "       <!--Optional:-->"+
				  "       <cm:per_id></cm:per_id>"+
				  "       <!--Optional:-->"+
				  "       <cm:emailid></cm:emailid>"+
				  "       <!--Optional:-->"+
				  "       <cm:entityname></cm:entityname>"+
				  "       <!--Optional:-->"+
				  "       <cm:uid></cm:uid>"+
				  "       <!--Optional:-->"+
				  "       <cm:mobile></cm:mobile>"+
				  "       <!--Optional:-->"+
				  "       <cm:landLine></cm:landLine>"+
				  "       <!--Optional:-->"+
				  "       <cm:prem_id></cm:prem_id>"+
				  "       <!--Optional:-->"+
				  "       <cm:houseNo></cm:houseNo>"+
				  "       <!--Optional:-->"+
				  "       <cm:societyNo></cm:societyNo>"+
				  "       <!--Optional:-->"+
				  "       <cm:RoadNoAndName></cm:RoadNoAndName>"+
				  "       <!--Optional:-->"+
				  "       <cm:village></cm:village>"+
				  "       <!--Optional:-->"+
				  "       <cm:SubColony></cm:SubColony>"+
				  "       <!--Optional:-->"+
				  "       <cm:SubLocality1></cm:SubLocality1>"+
				  "       <!--Optional:-->"+
				  "       <cm:SubLocality2></cm:SubLocality2>"+
				  "       <!--Optional:-->"+
				  "       <cm:khasraNo></cm:khasraNo>"+
				  "       <!--Optional:-->"+
				  "       <cm:SubLocality></cm:SubLocality>"+
				  "       <!--Optional:-->"+
				  "       <cm:Locality></cm:Locality>"+
				  "       <!--Optional:-->"+
				  "       <cm:JJRcolony></cm:JJRcolony>"+
				  "       <!--Optional:-->"+
				  "       <cm:Pincode></cm:Pincode>"+
				  "       <!--Optional:-->"+
				  "       <cm:BillHouseNo></cm:BillHouseNo>"+
				  "       <!--Optional:-->"+
				  "       <cm:BillsocietyNo></cm:BillsocietyNo>"+
				  "       <!--Optional:-->"+
				  "       <cm:BillRoadNoAndName></cm:BillRoadNoAndName>"+
				  "       <!--Optional:-->"+
				  "       <cm:Billvillage></cm:Billvillage>"+
				  "       <!--Optional:-->"+
				  "       <cm:BillSubColony></cm:BillSubColony>"+
				  "       <!--Optional:-->"+
				  "       <cm:BillSubLocality1></cm:BillSubLocality1>"+
				  "       <!--Optional:-->"+
				  "       <cm:BillSubLocality2></cm:BillSubLocality2>"+
				  "       <!--Optional:-->"+
				  "       <cm:BillkhasraNo></cm:BillkhasraNo>"+
				  "       <!--Optional:-->"+
				  "       <cm:BillSubLocality></cm:BillSubLocality>"+
				  "       <!--Optional:-->"+
				  "        <cm:BillLocality></cm:BillLocality>"+
				  "       <!--Optional:-->"+
				  "       <cm:BillJJRcolony></cm:BillJJRcolony>"+
				  "       <!--Optional:-->"+
				  "       <cm:BillPincode></cm:BillPincode>" +
				  "		<!--Optional:-->"+
				  "		<cm:ServiceAgreementType></cm:ServiceAgreementType>" +
				  " 	<!--Optional:-->"+
				  "		<cm:MAILADDRCHCK></cm:MAILADDRCHCK>"+
				  "    </cm:CM_RetrieveConsumerDetails>"+
				  " </soapenv:Body>"+
				 "</soapenv:Envelope>").toString();
		
		AppLog.info("Request XML::"+xml.toString());
		 
		 UserDetails userDetails =new UserDetails();
		 String xaiHTTPCallResponse;
		 
			try {
				ConsumerBean  consumerBean = new ConsumerBean ();
			    XAIHTTPCall httpCall = new XAIHTTPCall();
			    xaiHTTPCallResponse = httpCall.callXAIServer(xml.toString());
			    AppLog.info("http Response::"+xaiHTTPCallResponse);
			    Document document = DocumentHelper.parseText(xaiHTTPCallResponse);
			    StringBuffer output=new StringBuffer("");
			    Element root = document.getRootElement();
			   
			    for ( Iterator i = root.elementIterator(); i.hasNext(); ) {
			    	
			        Element element = (Element) i.next();
			        for ( Iterator i2 = element.elementIterator(); i2.hasNext(); ) {
			        	
			        	Element elementchild2 = (Element) i2.next();
			        	
			        	for ( Iterator i3 = elementchild2.elementIterator(); i3.hasNext(); ) {
			            	Element elementchild3 = (Element) i3.next();
			            
			            	if(elementchild3.getName().equalsIgnoreCase("per_id"))
			            		consumerBean.setPersonID(elementchild3.getStringValue());
			            	if(elementchild3.getName().equalsIgnoreCase("emailid"))
			            		consumerBean.setEmailid(elementchild3.getStringValue());
			            	if(elementchild3.getName().equalsIgnoreCase("entityname"))
			            		consumerBean.setName(elementchild3.getStringValue());
			            	if(elementchild3.getName().equalsIgnoreCase("uid"))
			            		consumerBean.setUid(elementchild3.getStringValue());
			            	if(elementchild3.getName().equalsIgnoreCase("mobile"))
			            		consumerBean.setPhone(elementchild3.getStringValue());
			            	if(elementchild3.getName().equalsIgnoreCase("landLine"))
			            		consumerBean.setLandLine(elementchild3.getStringValue());
			            	if(elementchild3.getName().equalsIgnoreCase("prem_id"))
			            		consumerBean.setPremiseID(elementchild3.getStringValue());
			            	if(elementchild3.getName().equalsIgnoreCase("houseNo"))
			            		consumerBean.setHouseNo(elementchild3.getStringValue());
			            	if(elementchild3.getName().equalsIgnoreCase("SubColony"))
			            		consumerBean.setSubcolony(elementchild3.getStringValue());
			            	if(elementchild3.getName().equalsIgnoreCase("SubLocality1"))
			            		consumerBean.setSubLocality1(elementchild3.getStringValue());
			            	
			            	if(elementchild3.getName().equalsIgnoreCase("SubLocality2"))
			            		consumerBean.setSubLocality2(elementchild3.getStringValue());
			            	
			            	if(elementchild3.getName().equalsIgnoreCase("societyNo"))
			            		consumerBean.setSociety(elementchild3.getStringValue());

			            	if(elementchild3.getName().equalsIgnoreCase("RoadNoAndName"))
			            		consumerBean.setStreet(elementchild3.getStringValue());
			            	if(elementchild3.getName().equalsIgnoreCase("village"))
			            		consumerBean.setVillage(elementchild3.getStringValue());

			            	if(elementchild3.getName().equalsIgnoreCase("khasraNo"))
			            		consumerBean.setKhasra(elementchild3.getStringValue());
			            	if(elementchild3.getName().equalsIgnoreCase("SubLocality"))
			            		consumerBean.setSubLocality(elementchild3.getStringValue());
			         
			            	if(elementchild3.getName().equalsIgnoreCase("Locality"))
			            		consumerBean.setLocality(elementchild3.getStringValue());

			            	if(elementchild3.getName().equalsIgnoreCase("Pincode"))
			            		consumerBean.setPostal(elementchild3.getStringValue());
			            	
			            	if(elementchild3.getName().equalsIgnoreCase("JJRcolony")){
			            		
			            		consumerBean.setJJColony(elementchild3.getStringValue());
			            		if (consumerBean.getJJColony().equalsIgnoreCase("Y"))
			            			consumerBean.setJJColony("true");
			            		if (consumerBean.getJJColony().equalsIgnoreCase("N"))
			            			consumerBean.setJJColony("false");
			            		
			            	}
			            	
			            	if(elementchild3.getName().equalsIgnoreCase("BillHouseNo"))
			            		consumerBean.setBillHouseNo(elementchild3.getStringValue());
			            	
			            	if(elementchild3.getName().equalsIgnoreCase("BillRoadNoAndName"))
			            		consumerBean.setBillStreet(elementchild3.getStringValue());
			            	
			            	if(elementchild3.getName().equalsIgnoreCase("Billvillage"))
			            		consumerBean.setBillVillage(elementchild3.getStringValue());
			            	
			            	if(elementchild3.getName().equalsIgnoreCase("BillsocietyNo"))
			            		consumerBean.setBillSociety(elementchild3.getStringValue());
	
			            	if(elementchild3.getName().equalsIgnoreCase("BillLocality"))
			            		consumerBean.setBillLocality(elementchild3.getStringValue());
			            	if(elementchild3.getName().equalsIgnoreCase("SubColony"))
			            		consumerBean.setBillSubColony(elementchild3.getStringValue());
			            	if(elementchild3.getName().equalsIgnoreCase("BillPincode"))
			              		consumerBean.setBillPincode(elementchild3.getStringValue());
			            	if(elementchild3.getName().equalsIgnoreCase("BillSubLocality"))
			              		consumerBean.setBillSubLocality(elementchild3.getStringValue());
			            	if(elementchild3.getName().equalsIgnoreCase("BillkhasraNo"))
			              		consumerBean.setBillkhasra(elementchild3.getStringValue());
			            	if(elementchild3.getName().equalsIgnoreCase("BillSubLocality2"))
			              		consumerBean.setBillSubLocality2(elementchild3.getStringValue());
			            	if(elementchild3.getName().equalsIgnoreCase("BillSubLocality1"))
			              		consumerBean.setBillSubLocality1(elementchild3.getStringValue());

			            	if(elementchild3.getName().equalsIgnoreCase("ServiceAgreementType"))
			              		consumerBean.setServiceAgreementType(elementchild3.getStringValue());
			            
			            	
			            	if(elementchild3.getName().equalsIgnoreCase("BillJJRcolony")){
			            		consumerBean.setBillJJColony(elementchild3.getStringValue());
			            		
			            		if (consumerBean.getBillJJColony().equalsIgnoreCase("Y"))
			            			consumerBean.setBillJJColony("true");
			            		if (consumerBean.getBillJJColony().equalsIgnoreCase("N"))
			            			consumerBean.setBillJJColony("false");
			            	}
			         
			            }
			        	
			        }
			     
			    }
			    userDetails.setConsumerBean(consumerBean);
			  
			} catch (Exception e) {
			    ///errorMsg = "Caught exception: " + e.getMessage();
				try {
					throw new CCBServerErrorException("CCb Server Down Or somethings went wrong in ccb !");
				} catch (CCBServerErrorException e1) {
					 AppLog.error(e);
				}
				
			    AppLog.error(e);
			    
			}
			AppLog.end();
			
		return userDetails;
	}

	@Override
	public List<ProofOfIdentity> proofOfIdentityList() {
		     AppLog.begin();
		     
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				Statement statement = null;
				List<ProofOfIdentity> proofOfIdentityList =new ArrayList<ProofOfIdentity>();
				try {
					
					String query=" SELECT DOC_VALUE, DOC_TEXT FROM DOC_ATTCH_LIST WHERE TYPE_OF_DOC='DPOI' AND ACTV_FLG='Y' ORDER BY DOC_TEXT ";
					conn = DBConnector.getConnection();
					statement = conn.createStatement();
					rs = statement.executeQuery(query);
				
					AppLog.info("query to fetch records proofOfIdentitylist "+query);
					
						while (rs.next()) {
							ProofOfIdentity proofOfIdentity =new ProofOfIdentity();
							proofOfIdentity.setDocText(rs.getString("DOC_VALUE"));
							proofOfIdentity.setDocValue(rs.getString("DOC_TEXT"));
							proofOfIdentityList.add(proofOfIdentity);
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
				AppLog.info("getproofOfIdentityList method end");
				
				return proofOfIdentityList;

	}

	@Override
	public String getAccessStatus(String kno, String chDisconnect) {
		AppLog.begin();
		StringBuffer xml = new StringBuffer(512);
		String flag = "false";
		String httpResponse = null;
		
			xml.append(
					"<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:cm='http://oracle.com/CM_ValidatingPendingCaseAgainstKNO.xsd'>"
							+ "<soapenv:Header/>"
							+ "<soapenv:Body>"
							+ "<cm:CM_ValidatingPendingCaseAgainstKNO>"
							+ " <!--Optional:-->"
							+ "<cm:zone>CM_VAL_PENDC</cm:zone>"
							+ " <!--Optional:-->"
							+ "<cm:accountId>"
							+ kno
							+ "</cm:accountId>"
							+ " <!--Optional:-->"
							+ " <cm:caseType>"
							+ chDisconnect
							+ "</cm:caseType>"
							+ " <!--Zero or more repetitions:-->"
							+ "<cm:results>"
							+ " <!--Optional:-->"
							+ "<cm:caseId>?</cm:caseId>"
							+ " </cm:results>"
							+ " </cm:CM_ValidatingPendingCaseAgainstKNO>"
							+ "</soapenv:Body>" + "</soapenv:Envelope>").toString();
			
			AppLog.info("Request XML::"+xml.toString());
			
			/*try {
				XAIHTTPCall httpCall = new XAIHTTPCall();
				httpResponse = httpCall.callXAIServer(httpRequest);
				AppLog.info(null, "Checking for http Response....validate..."
						+ httpResponse);
				Document document = DocumentHelper.parseText(httpResponse);
				Element root = document.getRootElement();
				for (Iterator i = root.elementIterator(); i.hasNext();) {
					Element element = (Element) i.next();
					for (Iterator i2 = element.elementIterator(); i2.hasNext();) {
						Element elementchild2 = (Element) i2.next();
						AppLog.info(null, "*******Name1..."
								+ elementchild2.getName() + ":");
						AppLog.info(null, "******Value1..."
								+ elementchild2.getStringValue());
						for (Iterator i3 = elementchild2.elementIterator(); i3
								.hasNext();) {
							Element elementchild3 = (Element) i3.next();
							AppLog.info(null, "*******Name2..."
									+ elementchild3.getName() + ":");
							AppLog.info(null, "******Value2..."
									+ elementchild3.getStringValue());
							for (Iterator i4 = elementchild3.elementIterator(); i4
									.hasNext();) {
								Element elementchild4 = (Element) i4.next();
								AppLog.info(null, "*******Name3..."
										+ elementchild4.getName() + ":");
								AppLog.info(null, "******Value3..."
										+ elementchild4.getStringValue());
								if (elementchild4.getName().equalsIgnoreCase(
										"caseId")) {
									flag = "true";
									AppLog.info(null, "Found Case ID----for all 3");
									break;
								}
							}
						}
					}
				}
				//dataVO.setFlag(flag);
				AppLog.info("httpRequest:"+httpRequest+"\n httpResponse:"+httpResponse+"\n Pending Case Flag:"+dataVO.getFlag());

			} catch (Exception e) {
				log.severe("The type is " + e.getClass().getName()
						+ " and the message is " + e.getMessage());
			}*/
		return httpResponse;
 }

	@Override
	
		public List<BillDetails> getLatestBillDetails(String kno) 
		{
			
			List<BillDetails> billDetailsList = null;
			String httpResponse = null;
			StringBuffer xmlSB = new StringBuffer(512);
			xmlSB.append("<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:cm='http://oracle.com/CM_RetrieveLatestBillDetails.xsd'>");
			xmlSB.append("<soapenv:Header />");
			xmlSB.append("<soapenv:Body>");
			xmlSB.append("<cm:CM_RetrieveLatestBillDetails>");
			xmlSB.append("<!-- Optional:-->");
			xmlSB.append("<cm:zone>CM_LTBILLDTL</cm:zone>");
			xmlSB.append("<cm:accountId>");
			xmlSB.append(kno);
			xmlSB.append("</cm:accountId>");
			xmlSB.append("<!-- Zero or more repetitions:-->");
			xmlSB.append("<cm:results>");
			xmlSB.append("<!-- Optional:-->");
			xmlSB.append("<cm:BillId>?</cm:BillId>");
			xmlSB.append("<!-- Optional:-->");
			xmlSB.append("<cm:BillDate>?</cm:BillDate>");
			xmlSB.append("<!-- Optional:-->");
			xmlSB.append("<cm:DueDate>?</cm:DueDate>");
			xmlSB.append("<!-- Optional:-->");
			xmlSB.append("<cm:BillCharges>?</cm:BillCharges>");
			xmlSB.append("<!-- Optional:-->");
			xmlSB.append("<cm:Balance>?</cm:Balance>");
			xmlSB.append("</cm:results>");
			xmlSB.append("</cm:CM_RetrieveLatestBillDetails>");
			xmlSB.append("</soapenv:Body>");
			xmlSB.append("</soapenv:Envelope>");
			String requestXml = xmlSB.toString();
			XAIHTTPCall xaiHTTPCall;
			try {
				xaiHTTPCall = new XAIHTTPCall();
				httpResponse = xaiHTTPCall.callXAIServer(requestXml.toString());
				AppLog.info("XAIHTTP Call Response::\n" + requestXml);
			   } catch (MalformedURLException e) {
				AppLog.error(e);
			   } catch (Exception e) {
				AppLog.error(e);
			  }
			try {
				billDetailsList = parseBillDetails(httpResponse);
			} catch (DocumentException e) {
				AppLog.error(e);
			}

			return billDetailsList;

		
	}
	private List<BillDetails> parseBillDetails(String responseXml) throws DocumentException {
		
		BillDetails billDetails = null;
		List<BillDetails> billDetailsList = null;
		
			Document document = DocumentHelper.parseText(responseXml);
			Element root = document.getRootElement();
			billDetailsList = new ArrayList<BillDetails>();
			for (Iterator<?> i = root.elementIterator(); i.hasNext();) {
				Element element = (Element) i.next();
				for (Iterator<?> i2 = element.elementIterator(); i2.hasNext();) {
					Element elementchild2 = (Element) i2.next();
					for (Iterator<?> i3 = elementchild2.elementIterator(); i3
							.hasNext();) {
						Element elementchild3 = (Element) i3.next();
						if ("results".equalsIgnoreCase(elementchild3.getName())) {
							billDetails = new BillDetails();
							for (Iterator<?> i4 = elementchild3
									.elementIterator(); i4.hasNext();) {
								Element elementchild4 = (Element) i4.next();

								if ("BillId".equalsIgnoreCase(elementchild4
										.getName())
										) {
									billDetails.setBillId(elementchild4
											.getStringValue());
								}
								if ("BillDate".equalsIgnoreCase(elementchild4.getName()))
										 {
									billDetails.setBillDt(elementchild4
											.getStringValue());
								}
								if ("DueDate".equalsIgnoreCase(elementchild4
										.getName())
										&& !UtilityForAll
												.isEmptyString(elementchild4
														.getStringValue())) {
									billDetails.setDueDt(elementchild4
											.getStringValue());
								}
								if ("BillCharges"
										.equalsIgnoreCase(elementchild4
												.getName())
										&& !UtilityForAll
												.isEmptyString(elementchild4
														.getStringValue())) {
									billDetails.setTotBillAmt(elementchild4
											.getStringValue());
								}
								if ("Balance".equalsIgnoreCase(elementchild4
										.getName())
										&& !UtilityForAll
												.isEmptyString(elementchild4
														.getStringValue())) {
									billDetails.setArr(elementchild4
											.getStringValue());
								}
							}
							billDetailsList.add(billDetails);
						}
					}
				}
			}
		return billDetailsList;
	}
}
