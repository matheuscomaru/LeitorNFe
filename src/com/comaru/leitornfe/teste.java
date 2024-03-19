package com.comaru.leitornfe;

import com.comaru.leitornfe.model.NFeModel;
import com.comaru.leitornfe.model.Produto;

public class teste {

	public static void main(String[] args) {

		NFeModel nfeModel = new NFeModel();
		nfeModel = LeitorNfe.getNfeModel("file:\\C:\\teste3.xml");

		// Dados NFe
		// System.out.println(nfeModel.getnNF());
		// System.out.println(nfeModel.getInfNFe());

		// Dados Emitente
		// System.out.println(nfeModel.getEmitNfe().getEnderEmit().getCEP());

		// Dados Destinatário
		System.out.println(nfeModel.getDestNfe().getCPF());

		// Produtos
		// for (Produto p : nfeModel.getProdutos()) {
		// System.out.println(p.getImposto().getIcms().getCst());
		// }
	}

}
