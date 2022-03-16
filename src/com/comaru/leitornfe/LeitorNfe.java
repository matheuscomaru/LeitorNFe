package com.comaru.leitornfe;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeitorNfe {

	public static NfeModel getNfeModel(String arquivo) {

		NfeModel nfeModel = new NfeModel();
		
		nfeModel.setEmitNfe(getEmitNfe(arquivo));

		return nfeModel;

	}

	public static EmitModel getEmitNfe(String arquivo) {

		EmitModel emit = new EmitModel();

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse(arquivo);

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

}
