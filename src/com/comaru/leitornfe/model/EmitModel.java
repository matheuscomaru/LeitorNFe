package com.comaru.leitornfe.model;

public class EmitModel {

	private String CNPJ, xNome, xFant, IE, CRT;
	private String CNAE;
	private String IM;
	private EnderEmit enderEmit = new EnderEmit();

	public String getCNAE() {
		return CNAE;
	}

	public void setCNAE(String cNAE) {
		CNAE = cNAE;
	}

	public String getIM() {
		return IM;
	}

	public void setIM(String iM) {
		IM = iM;
	}

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

	public String getxFant() {
		return xFant;
	}

	public void setxFant(String xFant) {
		this.xFant = xFant;
	}

	public String getIE() {
		return IE;
	}

	public void setIE(String iE) {
		IE = iE;
	}

	public String getCRT() {
		return CRT;
	}

	public void setCRT(String cRT) {
		CRT = cRT;
	}

	public EnderEmit getEnderEmit() {
		return enderEmit;
	}

	public void setEnderEmit(EnderEmit enderEmit) {
		this.enderEmit = enderEmit;
	}

}
