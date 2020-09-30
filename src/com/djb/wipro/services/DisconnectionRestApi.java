package com.djb.wipro.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.djb.wipro.dao.DisconnectionAndReopenDao;
import com.djb.wipro.exception.AllSQLException;
import com.djb.wipro.exception.InvalidKnoException;
import com.djb.wipro.exception.RecordNotFoundException;
import com.djb.wipro.impl.DisconnectionAndReopenImpl;
import com.djb.wipro.model.BillDetails;
import com.djb.wipro.model.BillingDetails;
import com.djb.wipro.model.ProofOfIdentity;
import com.djb.wipro.model.TemporaryDisconnection;
import com.djb.wipro.model.UserDetails;
import com.google.gson.Gson;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataParam;



@Path("/disconnectionWS")
public class DisconnectionRestApi {
	
private static final String SAVE_FOLDER = "d://tmp/";


@Path("/temporaryDisconnection")
@POST
//@Produces(MediaType.APPLICATION_JSON)
@Consumes({MediaType.MULTIPART_FORM_DATA})


public Response submitAndPreviewRecords(@FormDataParam("temporaryDisconnection")FormDataBodyPart jsonPart,
		@FormDataParam("file") FormDataContentDisposition fileInputDetails,
		@FormDataParam("file") InputStream fileInputString) throws FileNotFoundException
		{
	//jsonPart.setMediaType(MediaType.APPLICATION_JSON_TYPE);
	//TemporaryDisconnection emp = jsonPart.getValueAs(TemporaryDisconnection.class);
	String requestJson=jsonPart.getValue();
	Gson gson = new Gson(); 
	TemporaryDisconnection temporaryDisconnection = gson.fromJson(requestJson, TemporaryDisconnection.class);
	
	  System.out.println(",,,,,,,,,,,,,,,,,"+ temporaryDisconnection.getReasonForDisconnection());

	NumberFormat myFormat = NumberFormat.getInstance();
    myFormat.setGroupingUsed(true);
	String fileLocation = SAVE_FOLDER + fileInputDetails.getFileName();
	OutputStream out = new FileOutputStream(new File(fileLocation));
	byte[] buffer = new byte[1024];
	int bytes = 0;
	long file_size = 0; 
	try {
		while ((bytes = fileInputString.read(buffer)) != -1) {
		    out.write(buffer, 0, bytes);
		    file_size += bytes;
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	try {
		out.flush();
		out.close();
	} catch (IOException e) {
		
		e.printStackTrace();
	}  
   
    String status = "File has been uploaded to:" + fileLocation 
	         + ", size: " + myFormat.format(file_size) + " bytes";
   
	return Response.status(200).entity(status).build();
}

@Path("/version")
@GET
@Produces(MediaType.APPLICATION_JSON)
public Response returnVersion() {
	String version="2.0";
	return Response.status(200).entity(version).build();
}

@Path("/checkKno/{kno}")
@GET
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response checkKnoWithDetails(@PathParam("kno")String kno) throws RecordNotFoundException, AllSQLException{
	//validate kno 
	if(kno!=null&& kno!=""){
		
		DisconnectionAndReopenDao disconnectionAndReopenDao=new DisconnectionAndReopenImpl();
		
		String isValidKno=disconnectionAndReopenDao.checkKnoValidate(kno);
		
		if("VALID".equalsIgnoreCase(isValidKno)){
			
		UserDetails userDetails=disconnectionAndReopenDao.fetchCustomerData(kno);
		
		List<ProofOfIdentity> proofOfIdentityList = disconnectionAndReopenDao.proofOfIdentityList();
		
		if(proofOfIdentityList.size()>0){
			userDetails.setProofOfIdentityList(proofOfIdentityList);
			return Response.status(200).entity(userDetails).build();
			
		}else{
			throw new AllSQLException("Data Base exception");
		}
		
		}else{
			
			throw new InvalidKnoException("Kno is not valid please check kno");
			
		}
	}
	
	return Response.status(200).entity("Please Enter Kno").build();
}

}
