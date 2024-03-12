package com.comaru.leitornfe.model;

import java.util.ArrayList;

public class NFeModel {

	private String infNFe;
	private String versao;
	private int cUF;
	private String cNF;
	private String natOp;
	private String mod;
	private String serie;
	private String nNF;
	private String dhEmi;
	private String dhSaiEnt;
	private String tpNF;
	private int idDest;
	private int cMunFG;
	private int tpImp;
	private int tpEmis;
	private int cDV;
	private int tpAmb;
	private int finNFe;
	private int indFinal;
	private int indPres;
	private int indIntermed;
	private int procEmi;
	private String verProc;

	EmitModel emitNfe = new EmitModel();
	Destinatario destNfe = new Destinatario();
	ArrayList<Produto> produtos = new ArrayList<>();
	Totais totais = new Totais();

	public EmitModel getEmitNfe() {
		return emitNfe;
	}

	public void setEmitNfe(EmitModel emitNfe) {
		this.emitNfe = emitNfe;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getInfNFe() {
		return infNFe;
	}

	public void setInfNFe(String infNFe) {
		this.infNFe = infNFe;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public int getcUF() {
		return cUF;
	}

	public void setcUF(int cUF) {
		this.cUF = cUF;
	}

	public String getcNF() {
		return cNF;
	}

	public void setcNF(String cNF) {
		this.cNF = cNF;
	}

	public String getNatOp() {
		return natOp;
	}

	public void setNatOp(String natOp) {
		this.natOp = natOp;
	}

	public String getMod() {
		return mod;
	}

	public void setMod(String mod) {
		this.mod = mod;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getnNF() {
		return nNF;
	}

	public void setnNF(String nNF) {
		this.nNF = nNF;
	}

	public String getDhEmi() {
		return dhEmi;
	}

	public void setDhEmi(String dhEmi) {
		this.dhEmi = dhEmi;
	}

	public String getDhSaiEnt() {
		return dhSaiEnt;
	}

	public void setDhSaiEnt(String dhSaiEnt) {
		this.dhSaiEnt = dhSaiEnt;
	}

	public String getTpNF() {
		return tpNF;
	}

	public void setTpNF(String tpNF) {
		this.tpNF = tpNF;
	}

	public int getIdDest() {
		return idDest;
	}

	public void setIdDest(int idDest) {
		this.idDest = idDest;
	}

	public int getcMunFG() {
		return cMunFG;
	}

	public void setcMunFG(int cMunFG) {
		this.cMunFG = cMunFG;
	}

	public int getTpImp() {
		return tpImp;
	}

	public void setTpImp(int tpImp) {
		this.tpImp = tpImp;
	}

	public int getTpEmis() {
		return tpEmis;
	}

	public void setTpEmis(int tpEmis) {
		this.tpEmis = tpEmis;
	}

	public int getcDV() {
		return cDV;
	}

	public void setcDV(int cDV) {
		this.cDV = cDV;
	}

	public int getTpAmb() {
		return tpAmb;
	}

	public void setTpAmb(int tpAmb) {
		this.tpAmb = tpAmb;
	}

	public int getFinNFe() {
		return finNFe;
	}

	public void setFinNFe(int finNFe) {
		this.finNFe = finNFe;
	}

	public int getIndFinal() {
		return indFinal;
	}

	public void setIndFinal(int indFinal) {
		this.indFinal = indFinal;
	}

	public int getIndPres() {
		return indPres;
	}

	public void setIndPres(int indPres) {
		this.indPres = indPres;
	}

	public int getIndIntermed() {
		return indIntermed;
	}

	public void setIndIntermed(int indIntermed) {
		this.indIntermed = indIntermed;
	}

	public int getProcEmi() {
		return procEmi;
	}

	public void setProcEmi(int procEmi) {
		this.procEmi = procEmi;
	}

	public String getVerProc() {
		return verProc;
	}

	public void setVerProc(String verProc) {
		this.verProc = verProc;
	}

	public Destinatario getDestNfe() {
		return destNfe;
	}

	public void setDestNfe(Destinatario destNfe) {
		this.destNfe = destNfe;
	}

	public Totais getTotais() {
		return totais;
	}

	public void setTotais(Totais totais) {
		this.totais = totais;
	}

}
