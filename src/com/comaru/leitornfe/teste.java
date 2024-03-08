package com.comaru.leitornfe;

public class teste {

	public static void main(String[] args) {

		NFeModel nfeModel = new NFeModel();

		nfeModel = LeitorNfe.getNfeModel("C:\\teste.xml");

		// System.out.println("CNPJ:" + nfeModel.getEmitNfe().getCNPJ());
		// System.out.println("RazaoSocial:" + nfeModel.getEmitNfe().getxNome());
		// System.out.println("Fantasia:" + nfeModel.getEmitNfe().getxFant());
		// System.out.println("IE:" + nfeModel.getEmitNfe().getIE());

		// LeitorNfe.getItens("C:\\teste.xml");

		for (Produto p : nfeModel.getProdutos()) {

			System.out.println(p.toString());
		}
	}

}
