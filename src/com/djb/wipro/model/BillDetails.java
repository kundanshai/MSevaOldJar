package com.djb.wipro.model;

import java.util.List;

/**
 * <p>
 * Class for Bill Details. It contains all the details to be sent or receive
 * after bill is generated. It contains fields {@link #adj}, {@link #arr},
 * {@link #billAmtLpsc}, {@link #billDt},{@link #billId}, {@link #billPeriod},
 * {@link #cat}, {@link #cmrDt}, {@link #cmrStatus}, {@link #cons},
 * {@link #curBillAmt}, {@link #dueDt}, {@link #kno}, {@link #lpsc},
 * {@link #pmrDate}, {@link #pmrStatus}, {@link #totBillAmt}{@link #status},
 * {@link #msg}.
 * </p>
 * 
 * @author Matiur Rahman(Tata Consultancy Services)
 * @since 26-06-2013
 * 
 */
public class BillDetails {
	/**
	 * Adjustment Amount.
	 */
	private String adj;

	/**
	 * Arrears Amount.
	 */
	private String arr;
	/**
	 * Bill Amount LPSC.
	 */
	private String billAmtLpsc;
	/**
	 * Bill date of bill
	 */
	private String billDt;
	/**
	 * Bill Id of the bill.
	 */
	private String billId;

	/**
	 * Bill Period.
	 */
	private String billPeriod;
	/**
	 * Category of Consumer
	 */
	private String cat;

	/**
	 * Current Meter Read date
	 */
	private String cmrDt;

	/**
	 * Current Meter Read and Status.
	 */
	private String cmrStatus;

	/**
	 * Consumption.
	 */
	private String cons;

	/**
	 * Current Bill Amount.
	 */
	private String curBillAmt;

	/**
	 * Due date of bill
	 */
	private String dueDt;

	/**
	 * Consumer No(Account ID).
	 */
	private String kno;

	/**
	 * LPSC Amount.
	 */
	private String lpsc;

	/**
	 * Message to be sent.
	 */
	private String msg;

	/**
	 * Meter Read Id
	 */
	private String mtrRdId;
	/**
	 * Previous Meter Read Date.
	 */
	private String pmrDate;
	/**
	 * Previous Meter Read and Status.
	 */
	private String pmrStatus;
	/**
	 * Status of the transaction which may be SUCCESS,FAIL,ERROR,EXCEPTION
	 */
	private String status;
	/**
	 * Total Bill Amount
	 */
	private String totBillAmt;
	
	public BillDetails() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param msg
	 * @param status
	 */
	public BillDetails(String msg, String status) {
		this.msg = msg;
		this.status = status;
	}
	/**
	 * @return the adj
	 */
	public String getAdj() {
		return adj;
	}
	/**
	 * @return the arr
	 */
	public String getArr() {
		return arr;
	}

	/**
	 * @return the billAmtLpsc
	 */
	public String getBillAmtLpsc() {
		return billAmtLpsc;
	}

	/**
	 * @return the billDt
	 */
	public String getBillDt() {
		return billDt;
	}

	/**
	 * @return the billId
	 */
	public String getBillId() {
		return billId;
	}

	/**
	 * @return the billPeriod
	 */
	public String getBillPeriod() {
		return billPeriod;
	}

	/**
	 * @return the cat
	 */
	public String getCat() {
		return cat;
	}

	/**
	 * @return the cmrDt
	 */
	public String getCmrDt() {
		return cmrDt;
	}

	/**
	 * @return the cmrStatus
	 */
	public String getCmrStatus() {
		return cmrStatus;
	}

	/**
	 * @return the cons
	 */
	public String getCons() {
		return cons;
	}

	/**
	 * @return the curBillAmt
	 */
	public String getCurBillAmt() {
		return curBillAmt;
	}

	/**
	 * @return the dueDt
	 */
	public String getDueDt() {
		return dueDt;
	}

	/**
	 * @return the kno
	 */
	public String getKno() {
		return kno;
	}

	/**
	 * @return the lpsc
	 */
	public String getLpsc() {
		return lpsc;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @return the mtrRdId
	 */
	public String getMtrRdId() {
		return mtrRdId;
	}

	/**
	 * @return the pmrDate
	 */
	public String getPmrDate() {
		return pmrDate;
	}

	/**
	 * @return the pmrStatus
	 */
	public String getPmrStatus() {
		return pmrStatus;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the totBillAmt
	 */
	public String getTotBillAmt() {
		return totBillAmt;
	}

	/**
	 * @param adj
	 *            the adj to set
	 */
	public void setAdj(String adj) {
		this.adj = adj;
	}

	/**
	 * @param arr
	 *            the arr to set
	 */
	public void setArr(String arr) {
		this.arr = arr;
	}

	/**
	 * @param billAmtLpsc
	 *            the billAmtLpsc to set
	 */
	public void setBillAmtLpsc(String billAmtLpsc) {
		this.billAmtLpsc = billAmtLpsc;
	}

	/**
	 * @param billDt
	 *            the billDt to set
	 */
	public void setBillDt(String billDt) {
		this.billDt = billDt;
	}

	/**
	 * @param billId
	 *            the billId to set
	 */
	public void setBillId(String billId) {
		this.billId = billId;
	}

	/**
	 * @param billPeriod
	 *            the billPeriod to set
	 */
	public void setBillPeriod(String billPeriod) {
		this.billPeriod = billPeriod;
	}

	/**
	 * @param cat
	 *            the cat to set
	 */
	public void setCat(String cat) {
		this.cat = cat;
	}

	/**
	 * @param cmrDt
	 *            the cmrDt to set
	 */
	public void setCmrDt(String cmrDt) {
		this.cmrDt = cmrDt;
	}

	/**
	 * @param cmrStatus
	 *            the cmrStatus to set
	 */
	public void setCmrStatus(String cmrStatus) {
		this.cmrStatus = cmrStatus;
	}

	/**
	 * @param cons
	 *            the cons to set
	 */
	public void setCons(String cons) {
		this.cons = cons;
	}

	/**
	 * @param curBillAmt
	 *            the curBillAmt to set
	 */
	public void setCurBillAmt(String curBillAmt) {
		this.curBillAmt = curBillAmt;
	}

	/**
	 * @param dueDt
	 *            the dueDt to set
	 */
	public void setDueDt(String dueDt) {
		this.dueDt = dueDt;
	}

	/**
	 * @param kno
	 *            the kno to set
	 */
	public void setKno(String kno) {
		this.kno = kno;
	}

	/**
	 * @param lpsc
	 *            the lpsc to set
	 */
	public void setLpsc(String lpsc) {
		this.lpsc = lpsc;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @param mtrRdId the mtrRdId to set
	 */
	public void setMtrRdId(String mtrRdId) {
		this.mtrRdId = mtrRdId;
	}

	/**
	 * @param pmrDate
	 *            the pmrDate to set
	 */
	public void setPmrDate(String pmrDate) {
		this.pmrDate = pmrDate;
	}

	/**
	 * @param pmrStatus
	 *            the pmrStatus to set
	 */
	public void setPmrStatus(String pmrStatus) {
		this.pmrStatus = pmrStatus;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param totBillAmt
	 *            the totBillAmt to set
	 */
	public void setTotBillAmt(String totBillAmt) {
		this.totBillAmt = totBillAmt;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BillDetails [");
		if (adj != null) {
			builder.append("adj=");
			builder.append(adj);
			builder.append(", ");
		}
		if (arr != null) {
			builder.append("arr=");
			builder.append(arr);
			builder.append(", ");
		}
		if (billAmtLpsc != null) {
			builder.append("billAmtLpsc=");
			builder.append(billAmtLpsc);
			builder.append(", ");
		}
		if (billDt != null) {
			builder.append("billDt=");
			builder.append(billDt);
			builder.append(", ");
		}
		if (billId != null) {
			builder.append("billId=");
			builder.append(billId);
			builder.append(", ");
		}
		if (billPeriod != null) {
			builder.append("billPeriod=");
			builder.append(billPeriod);
			builder.append(", ");
		}
		if (cat != null) {
			builder.append("cat=");
			builder.append(cat);
			builder.append(", ");
		}
		if (cmrDt != null) {
			builder.append("cmrDt=");
			builder.append(cmrDt);
			builder.append(", ");
		}
		if (cmrStatus != null) {
			builder.append("cmrStatus=");
			builder.append(cmrStatus);
			builder.append(", ");
		}
		if (cons != null) {
			builder.append("cons=");
			builder.append(cons);
			builder.append(", ");
		}
		if (curBillAmt != null) {
			builder.append("curBillAmt=");
			builder.append(curBillAmt);
			builder.append(", ");
		}
		if (dueDt != null) {
			builder.append("dueDt=");
			builder.append(dueDt);
			builder.append(", ");
		}
		if (kno != null) {
			builder.append("kno=");
			builder.append(kno);
			builder.append(", ");
		}
		if (lpsc != null) {
			builder.append("lpsc=");
			builder.append(lpsc);
			builder.append(", ");
		}
		if (msg != null) {
			builder.append("msg=");
			builder.append(msg);
			builder.append(", ");
		}
		if (mtrRdId != null) {
			builder.append("mtrRdId=");
			builder.append(mtrRdId);
			builder.append(", ");
		}
		if (pmrDate != null) {
			builder.append("pmrDate=");
			builder.append(pmrDate);
			builder.append(", ");
		}
		if (pmrStatus != null) {
			builder.append("pmrStatus=");
			builder.append(pmrStatus);
			builder.append(", ");
		}
		if (status != null) {
			builder.append("status=");
			builder.append(status);
			builder.append(", ");
		}
		if (totBillAmt != null) {
			builder.append("totBillAmt=");
			builder.append(totBillAmt);
		}
		builder.append("]");
		return builder.toString();
	}

}
