package com.comaru.leitornfe.model;

public class Destinatario {

	private String CNPJ;
	private String xNome;
	private int indIEDest;
	private String IE;
	private String email;
	EnderDest enderDest = new EnderDest();

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getxNome() {
		return xNome;
	}

	public void setxNome(String xNome) {
		this.xNome = xNome;
	}

	public int getIndIEDest() {
		return indIEDest;
	}

	public void setIndIEDest(int indIEDest) {
		this.indIEDest = indIEDest;
	}

	public String getIE() {
		return IE;
	}

	public void setIE(String iE) {
		IE = iE;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EnderDest getEnderDest() {
		return enderDest;
	}

	public void setEnderDest(EnderDest enderDest) {
		this.enderDest = enderDest;
	}

}
