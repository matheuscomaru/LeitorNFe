package com.comaru.leitornfe.model;

public class ImpostoProduto {

	Icms icms = new Icms();
	Ipi ipi = new Ipi();

	public Icms getIcms() {
		return icms;
	}

	public void setIcms(Icms icms) {
		this.icms = icms;
	}

	public Ipi getIpi() {
		return ipi;
	}

	public void setIpi(Ipi ipi) {
		this.ipi = ipi;
	}

}
