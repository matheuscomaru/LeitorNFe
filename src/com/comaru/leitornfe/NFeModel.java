package com.comaru.leitornfe;

import java.util.ArrayList;

public class NFeModel {

	EmitModel emitNfe = new EmitModel();
	ArrayList<Produto> produtos = new ArrayList<>();

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

}
