package com.comaru.leitornfe;

import com.comaru.leitornfe.model.NFeModel;
import com.comaru.leitornfe.model.Produto;

public class teste {

	public static void main(String[] args) {

		NFeModel nfeModel = new NFeModel();
		nfeModel = LeitorNfe.getNfeModel(
				"file:\\C:\\Users\\mathe\\OneDrive\\Área de Trabalho\\teste\\51230131178921000172550010000118171780670669.xml");

		// Dados NFe
		// System.out.println(nfeModel.getnNF());
		// System.out.println(nfeModel.getInfNFe());

		// Dados Emitente
		// System.out.println(nfeModel.getEmitNfe().getEnderEmit().getCEP());

		// Dados Destinatário
		// System.out.println(nfeModel.getDestNfe().getEmail());

		// Produtos
		for (Produto p : nfeModel.getProdutos()) {
			System.out.println(p.getImposto().getIcms().getCst());
		}
	}

}
