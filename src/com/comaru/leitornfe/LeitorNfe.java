package com.comaru.leitornfe;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeitorNfe {

	private LeitorNfe() {

	}

	public static NFeModel getNfeModel(String caminho) {

		NFeModel nfeModel = new NFeModel();
		nfeModel.setEmitNfe(getEmitNfe(caminho));
		nfeModel.setProdutos(getItens(caminho));
		return nfeModel;

	}

	public static EmitModel getEmitNfe(String arquivo) {

		EmitModel emit = new EmitModel();

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse(arquivo);

			// EMITENTE
			NodeList lista = doc.getElementsByTagName("emit");

			Node node = lista.item(0);

			if (node.getNodeType() == Node.ELEMENT_NODE) {

				NodeList filhos = node.getChildNodes();

				for (int i = 0; i < filhos.getLength(); i++) {

					Node filho = filhos.item(i);

					Element elementoFilho = (Element) filho;

					switch (elementoFilho.getTagName()) {
					case "CNPJ":
						emit.setCNPJ(elementoFilho.getTextContent());
						break;
					case "xNome":
						emit.setxNome("xNome:" + elementoFilho.getTextContent());
						break;
					case "xFant":
						emit.setxFant("xFant:" + elementoFilho.getTextContent());
						break;
					case "IE":
						emit.setIE("IE:" + elementoFilho.getTextContent());
						break;
					case "CRT":

						break;
					}

				}

			}

			return emit;

		} catch (

		ParserConfigurationException ex) {
			ex.printStackTrace();
		} catch (SAXException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return null;

	}

	public static ArrayList<Produto> getItens(String arquivo) {

		ArrayList<Produto> lista = new ArrayList<>();

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse(arquivo);

			// EMITENTE
			NodeList listaDet = doc.getElementsByTagName("det");

			for (int i = 0; i < listaDet.getLength(); i++) {

				Produto produto = new Produto();

				Node itemDet = listaDet.item(i);

				NodeList listaProd = itemDet.getChildNodes();

				Node prod = listaProd.item(0);

				if (prod.getNodeType() == Node.ELEMENT_NODE) {

					NodeList filhos = prod.getChildNodes();

					for (int j = 0; j < filhos.getLength(); j++) {

						Node filho = filhos.item(j);

						Element el = (Element) filho;

						switch (el.getTagName()) {
						case "cProd":
							produto.setcProd(el.getTextContent());
							break;
						case "cEAN":
							produto.setcEAN(el.getTextContent());
							break;
						case "xProd":
							produto.setxProd(el.getTextContent());
							break;
						case "CFOP":
							produto.setCFOP(el.getTextContent());
							break;
						case "uCom":
							produto.setuCom(el.getTextContent());
							break;
						case "qCom":
							produto.setqCom(Double.parseDouble(el.getTextContent()));
							break;
						case "vUnCom":
							produto.setvUnCom(Double.parseDouble(el.getTextContent()));
							break;
						case "vProd":
							produto.setvProd(Double.parseDouble(el.getTextContent()));
							break;
						case "cEANTrib":
							produto.setcEANTrib(el.getTextContent());
							break;
						case "uTrib":
							produto.setuTrib(el.getTextContent());
							break;
						case "qTrib":
							produto.setqTrib(Double.parseDouble(el.getTextContent()));
							break;
						case "vUnTrib":
							produto.setvUnTrib(Double.parseDouble(el.getTextContent()));
							break;
						case "indTot":
							produto.setIndTot(Integer.parseInt(el.getTextContent()));
							break;
						}

					}

				}
				lista.add(produto);
			}

			return lista;

		} catch (

		ParserConfigurationException ex) {
			ex.printStackTrace();
		} catch (SAXException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return null;

	}

}
