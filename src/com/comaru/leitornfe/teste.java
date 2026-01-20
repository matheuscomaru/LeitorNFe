package com.comaru.leitornfe;

import com.comaru.leitornfe.model.NFeModel;
import com.comaru.leitornfe.model.Produto;

public class teste {

	public static void main(String[] args) {

		NFeModel nfeModel = new NFeModel();
		nfeModel = LeitorNfe.getNfeModel("file:\\C:\\teste.xml");

		// Dados NFe
		// System.out.println(nfeModel.getnNF());
		// System.out.println(nfeModel.getInfNFe());

		// Dados Emitente
		// System.out.println(nfeModel.getEmitNfe().getEnderEmit().getCEP());

		// Dados Destinat�rio
		System.out.println(nfeModel.getnNF());

		// Produtos
		 for (Produto p : nfeModel.getProdutos()) {
			 System.out.println(p.getImposto().getIcms().getCsosn());
		 }
	}

}
