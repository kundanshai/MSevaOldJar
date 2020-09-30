package com.djb.wipro.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.djb.wipro.dao.DisconnectionAndReopenDao;
import com.djb.wipro.exception.InvalidKnoException;
import com.djb.wipro.impl.DisconnectionAndReopenImpl;
import com.djb.wipro.model.BillDetails;
import com.djb.wipro.model.BillingDetails;

@Path("/ussdWSApi")
public class USSDServicesApi {
	@Path("/ussd/{kno}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)

	public Response getAccessStatus(@PathParam("kno")String kno){
		List<BillDetails> billingList=new ArrayList<BillDetails>();
		BillingDetails billingDetails=new BillingDetails();
		DisconnectionAndReopenDao disconnectionAndReopenDao=new DisconnectionAndReopenImpl();
        String isValidKno=disconnectionAndReopenDao.checkKnoValidate(kno);
		
		if("VALID".equalsIgnoreCase(isValidKno)){
			
			  billingList=disconnectionAndReopenDao.getLatestBillDetails(kno);
			  billingDetails.setBillingList(billingList);
			
		}else{	
			throw new InvalidKnoException("Kno is not valid please check kno");	
		}
		return Response.status(200).entity(billingDetails).build();

	}
}
