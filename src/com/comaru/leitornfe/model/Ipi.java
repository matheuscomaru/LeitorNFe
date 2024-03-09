package com.comaru.leitornfe.model;

public class Ipi {

	private String CNPJProd;
	private String qSelo;
	private String cEnq;
	IpiTrib ipiTrib = new IpiTrib();

	public String getCNPJProd() {
		return CNPJProd;
	}

	public void setCNPJProd(String cNPJProd) {
		CNPJProd = cNPJProd;
	}

	public String getqSelo() {
		return qSelo;
	}

	public void setqSelo(String qSelo) {
		this.qSelo = qSelo;
	}

	public String getcEnq() {
		return cEnq;
	}

	public void setcEnq(String cEnq) {
		this.cEnq = cEnq;
	}

	public IpiTrib getIpiTrib() {
		return ipiTrib;
	}

	public void setIpiTrib(IpiTrib ipiTrib) {
		this.ipiTrib = ipiTrib;
	}

}
