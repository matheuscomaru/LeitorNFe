package com.comaru.leitornfe.model;

public class ImpostoProduto {

	private Icms icms = new Icms();
	private Ipi ipi = new Ipi();
	private Pis pis = new Pis();
	private Cofins cofins = new Cofins();

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

	public Pis getPis() {
		return pis;
	}

	public void setPis(Pis pis) {
		this.pis = pis;
	}

	public Cofins getCofins() {
		return cofins;
	}

	public void setCofins(Cofins cofins) {
		this.cofins = cofins;
	}

}
