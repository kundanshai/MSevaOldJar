/*package com.djb.wipro.services;

import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.djb.wipro.dao.MeterReaderCredentialDao;
import com.djb.wipro.impl.MeterReaderCredentialDaoImpl;
import com.djb.wipro.model.BillRoundDetails;
import com.djb.wipro.model.WebServiceUserDetails;

@Path("/mtrRdrCredentialWS")
public class MtrRdrCredentialRestWS {
	@Path("/accessCredential")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response validateUserCredential(JSONObject jsonObject, @Context HttpHeaders httpHeaders) throws JSONException{
		
		String empId=(String)jsonObject.get("empId");
		String password=(String)jsonObject.get("password");
		
		String usernameAndPassword = empId + ":" + password;
		//Base64.Encoder encoder = Base64.getEncoder();  
	    //String authorizationHeaderValue = "Basic " + java.util.Base64.getEncoder().encodeToString(usernameAndPassword.getBytes());
	    
		//WebServiceUserDetails webServiceUserDetails=new WebServiceUserDetails();
		 String cacheControl = httpHeaders.getRequestHeader("Cache-Control").get(0);
	        System.out.println("Cache-Control: "+cacheControl);
	        *//** get list of all header parameters from request **//*
	        Set<String> headerKeys = httpHeaders.getRequestHeaders().keySet();
	        for(String header:headerKeys){
	           // System.out.println(header+":"+httpHeaders.getRequestHeader(header).get(0));
	        }
		MeterReaderCredentialDao meterReaderCredentialDao = new MeterReaderCredentialDaoImpl();
		WebServiceUserDetails webServiceUserDetails=meterReaderCredentialDao.getCredentials(jsonObject);
		List<BillRoundDetails> billRoundList = meterReaderCredentialDao.getBillRoundDetails();
		webServiceUserDetails.setBillRoundDetailsList(billRoundList);
		if(webServiceUserDetails!=null && webServiceUserDetails.getPassword()!=null){
			return Response.status(200).entity(webServiceUserDetails).build();
		}else{
			jsonObject.put("false", "User not Authorized");
			return Response.status(400).entity(jsonObject).build();
		}
		
	}
}
*/