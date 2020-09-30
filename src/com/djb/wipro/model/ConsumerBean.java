/************************************************************************************************************
 * @(#) ConsumerBean.java  
 * 
 *
 *************************************************************************************************************/
package com.djb.wipro.model;

/**
 * <p>
 * Bean class for consumer containing all the attributes for consumer
 * </p>
 *
 */
public class ConsumerBean {

	private String kNO;
	public String premiseID;
	public String Name;

	/**
	 * @return
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * @return
	 */
	public String getPremiseID() {
		return premiseID;
	}

	/**
	 * @param premiseID
	 */
	public void setPremiseID(String premiseID) {
		this.premiseID = premiseID;
	}

	/**
	 * @return
	 */
	public String getkNO() {
		return kNO;
	}

	/**
	 * @param kNO
	 */
	public void setkNO(String kNO) {
		this.kNO = kNO;
	}

	/**
	 * @return
	 */
	public String getPremiseId() {
		return premiseId;
	}

	/**
	 * @param premiseId
	 */
	public void setPremiseId(String premiseId) {
		this.premiseId = premiseId;
	}

	/**
	 * @return
	 */
	public String getSaType() {
		return saType;
	}

	/**
	 * @param saType
	 */
	public void setSaType(String saType) {
		this.saType = saType;
	}

	private String premiseId;
	private String saType;
	private String personID;

	/**
	 * @return
	 */
	public String getPersonID() {
		return personID;
	}

	/**
	 * @param personID
	 */
	public void setPersonID(String personID) {
		this.personID = personID;
	}

	public String ServiceAgreement;

	/**
	 * @return
	 */
	public String getServiceAgreement() {
		return ServiceAgreement;
	}

	/**
	 * @param serviceAgreement
	 */
	public void setServiceAgreement(String serviceAgreement) {
		ServiceAgreement = serviceAgreement;
	}

	/**
	 * @return
	 */
	public String getAccountNameInfo() {
		return AccountNameInfo;
	}

	/**
	 * @param accountNameInfo
	 */
	public void setAccountNameInfo(String accountNameInfo) {
		AccountNameInfo = accountNameInfo;
	}

	/**
	 * @return
	 */
	public String getPremiseInfo() {
		return PremiseInfo;
	}

	/**
	 * @param premiseInfo
	 */
	public void setPremiseInfo(String premiseInfo) {
		PremiseInfo = premiseInfo;
	}

	/**
	 * @return
	 */
	public String getSAType() {
		return SAType;
	}

	/**
	 * @param sAType
	 */
	public void setSAType(String sAType) {
		SAType = sAType;
	}

	public String AccountNameInfo;
	public String PremiseInfo;
	public String SAType;

	/**
	 * @return
	 */
	public String getEmailid() {
		return Emailid;
	}

	/**
	 * @param emailid
	 */
	public void setEmailid(String emailid) {
		Emailid = emailid;
	}

	/**
	 * @return
	 */
	public String getUid() {
		return Uid;
	}

	/**
	 * @param uid
	 */
	public void setUid(String uid) {
		Uid = uid;
	}

	/**
	 * @return
	 */
	public String getPhone() {
		return Phone;
	}

	/**
	 * @param phone
	 */
	public void setPhone(String phone) {
		Phone = phone;
	}

	/**
	 * @return
	 */
	public String getHouseNo() {
		return HouseNo;
	}

	/**
	 * @param houseNo
	 */
	public void setHouseNo(String houseNo) {
		HouseNo = houseNo;
	}

	/**
	 * @return
	 */
	public String getPhaseNo() {
		return PhaseNo;
	}

	/**
	 * @param phaseNo
	 */
	public void setPhaseNo(String phaseNo) {
		PhaseNo = phaseNo;
	}

	/**
	 * @return
	 */
	public String getBlockNo() {
		return BlockNo;
	}

	/**
	 * @param blockNo
	 */
	public void setBlockNo(String blockNo) {
		BlockNo = blockNo;
	}

	/**
	 * @return
	 */
	public String getSociety() {
		return Society;
	}

	/**
	 * @param society
	 */
	public void setSociety(String society) {
		Society = society;
	}

	private String Emailid;
	private String Uid;
	private String Phone;

	private String HouseNo;
	private String PhaseNo;
	private String BlockNo;
	private String Society;

	/**
	 * @return
	 */
	public String getZone() {
		return Zone;
	}

	/**
	 * @param zone
	 */
	public void setZone(String zone) {
		Zone = zone;
	}

	/**
	 * @return
	 */
	public String getPostal() {
		return Postal;
	}

	/**
	 * @param postal
	 */
	public void setPostal(String postal) {
		Postal = postal;
	}

	/**
	 * @return
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return
	 */
	public String getJJColony() {
		return JJColony;
	}

	/**
	 * @param jJColony
	 */
	public void setJJColony(String jJColony) {
		JJColony = jJColony;
	}

	/**
	 * @return
	 */
	public String getSubarea() {
		return subarea;
	}

	/**
	 * @param subarea
	 */
	public void setSubarea(String subarea) {
		this.subarea = subarea;
	}

	private String Zone;
	private String Postal;
	private String area;
	private String JJColony;
	private String subarea;

	/**
	 * @return
	 */
	public String getBillHouseNo() {
		return BillHouseNo;
	}

	/**
	 * @param billHouseNo
	 */
	public void setBillHouseNo(String billHouseNo) {
		BillHouseNo = billHouseNo;
	}

	/**
	 * @return
	 */
	public String getBillPhaseNo() {
		return BillPhaseNo;
	}

	/**
	 * @param billPhaseNo
	 */
	public void setBillPhaseNo(String billPhaseNo) {
		BillPhaseNo = billPhaseNo;
	}

	/**
	 * @return
	 */
	public String getBillBlockNo() {
		return BillBlockNo;
	}

	/**
	 * @param billBlockNo
	 */
	public void setBillBlockNo(String billBlockNo) {
		BillBlockNo = billBlockNo;
	}

	/**
	 * @return
	 */
	public String getBillSociety() {
		return BillSociety;
	}

	/**
	 * @param billSociety
	 */
	public void setBillSociety(String billSociety) {
		BillSociety = billSociety;
	}

	/**
	 * @return
	 */
	public String getBillJJColony() {
		return BillJJColony;
	}

	/**
	 * @param billJJColony
	 */
	public void setBillJJColony(String billJJColony) {
		BillJJColony = billJJColony;
	}

	/**
	 * @return
	 */
	public String getBillZone() {
		return BillZone;
	}

	/**
	 * @param billZone
	 */
	public void setBillZone(String billZone) {
		BillZone = billZone;
	}

	/**
	 * @return
	 */
	public String getBillSubarea() {
		return BillSubarea;
	}

	/**
	 * @param billSubarea
	 */
	public void setBillSubarea(String billSubarea) {
		BillSubarea = billSubarea;
	}

	/**
	 * @return
	 */
	public String getBillPostal() {
		return BillPostal;
	}

	/**
	 * @param billPostal
	 */
	public void setBillPostal(String billPostal) {
		BillPostal = billPostal;
	}

	private String BillHouseNo;
	private String BillPhaseNo;
	private String BillBlockNo;
	private String BillSociety;
	private String BillJJColony;
	private String BillZone;
	private String BillSubarea;
	private String BillPostal;
	private String BillArea;

	/**
	 * @return
	 */
	public String getBillArea() {
		return BillArea;
	}

	/**
	 * @param billArea
	 */
	public void setBillArea(String billArea) {
		BillArea = billArea;
	}

	private String LandLine;

	/**
	 * @return
	 */
	public String getLandLine() {
		return LandLine;
	}

	/**
	 * @param landLine
	 */
	public void setLandLine(String landLine) {
		LandLine = landLine;
	}
	private String street;

	/**
	 * @return
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	private String village;

	/**
	 * @return
	 */
	public String getVillage() {
		return village;
	}

	/**
	 * @param village
	 */
	public void setVillage(String village) {
		this.village = village;
	}
	/**
	 * @return
	 */
	public String getSubcolony() {
		return subcolony;
	}

	/**
	 * @param subcolony
	 */
	public void setSubcolony(String subcolony) {
		this.subcolony = subcolony;
	}

	/**
	 * @return
	 */
	public String getSubLocality1() {
		return subLocality1;
	}

	/**
	 * @param subLocality1
	 */
	public void setSubLocality1(String subLocality1) {
		this.subLocality1 = subLocality1;
	}

	/**
	 * @return
	 */
	public String getSubLocality2() {
		return subLocality2;
	}

	/**
	 * @param subLocality2
	 */
	public void setSubLocality2(String subLocality2) {
		this.subLocality2 = subLocality2;
	}

	/**
	 * @return
	 */
	public String getKhasra() {
		return khasra;
	}

	/**
	 * @param khasra
	 */
	public void setKhasra(String khasra) {
		this.khasra = khasra;
	}

	/**
	 * @return
	 */
	public String getSubLocality() {
		return subLocality;
	}

	/**
	 * @param subLocality
	 */
	public void setSubLocality(String subLocality) {
		this.subLocality = subLocality;
	}

	/**
	 * @return
	 */
	public String getLocality() {
		return locality;
	}

	/**
	 * @param locality
	 */
	public void setLocality(String locality) {
		this.locality = locality;
	}

	private String subcolony;
	private String subLocality1;
	private String subLocality2;
	private String khasra;
	private String subLocality;
	private String locality;
	
	
	/**
	 * @return
	 */
	public String getBillLocality() {
		return billLocality;
	}

	/**
	 * @param billLocality
	 */
	public void setBillLocality(String billLocality) {
		this.billLocality = billLocality;
	}

	/**
	 * @return
	 */
	public String getBillSubColony() {
		return billSubColony;
	}

	/**
	 * @param billSubColony
	 */
	public void setBillSubColony(String billSubColony) {
		this.billSubColony = billSubColony;
	}

	/**
	 * @return
	 */
	public String getBillPincode() {
		return billPincode;
	}

	/**
	 * @param billPincode
	 */
	public void setBillPincode(String billPincode) {
		this.billPincode = billPincode;
	}

	/**
	 * @return
	 */
	public String getBillSubLocality() {
		return billSubLocality;
	}

	/**
	 * @param billSubLocality
	 */
	public void setBillSubLocality(String billSubLocality) {
		this.billSubLocality = billSubLocality;
	}

	/**
	 * @return
	 */
	public String getBillkhasra() {
		return billkhasra;
	}

	/**
	 * @param billkhasra
	 */
	public void setBillkhasra(String billkhasra) {
		this.billkhasra = billkhasra;
	}

	/**
	 * @return
	 */
	public String getBillSubLocality2() {
		return billSubLocality2;
	}

	/**
	 * @param billSubLocality2
	 */
	public void setBillSubLocality2(String billSubLocality2) {
		this.billSubLocality2 = billSubLocality2;
	}

	/**
	 * @return
	 */
	public String getBillSubLocality1() {
		return billSubLocality1;
	}

	/**
	 * @param billSubLocality1
	 */
	public void setBillSubLocality1(String billSubLocality1) {
		this.billSubLocality1 = billSubLocality1;
	}

	/**
	 * @return
	 */
	public String getBillStreet() {
		return billStreet;
	}

	/**
	 * @param billStreet
	 */
	public void setBillStreet(String billStreet) {
		this.billStreet = billStreet;
	}

	/**
	 * @return
	 */
	public String getBillVillage() {
		return billVillage;
	}

	/**
	 * @param billVillage
	 */
	public void setBillVillage(String billVillage) {
		this.billVillage = billVillage;
	}

	private String serviceAgreementType;
	/**
	 * @return
	 */
	public String getServiceAgreementType() {
		return serviceAgreementType;
	}

	/**
	 * @param serviceAgreementType
	 */
	public void setServiceAgreementType(String serviceAgreementType) {
		this.serviceAgreementType = serviceAgreementType;
	}

	private String billLocality;
	private String billSubColony;
	private String billPincode;
	private String billSubLocality;
	private String billkhasra;
	private String billSubLocality2;
	private String billSubLocality1;
	private String billStreet;
	private String billVillage;

}
