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

import com.comaru.leitornfe.model.Cofins;
import com.comaru.leitornfe.model.CofinsAliq;
import com.comaru.leitornfe.model.Icms;
import com.comaru.leitornfe.model.ImpostoProduto;
import com.comaru.leitornfe.model.Ipi;
import com.comaru.leitornfe.model.IpiTrib;
import com.comaru.leitornfe.model.Pis;
import com.comaru.leitornfe.model.PisAliq;

/**
 * LeitorNfe
 *
 * <p>
 * Possui métodos para ler o arquivo XML de NFe e converter em modelos para
 * fácilitar a manipulação.
 *
 * @author Matheus Comaru
 * @version 1.0
 */
public class LeitorNfe {

	static String caminho = "";

	/**
	 * Converte o XML da NF-e em um Objeto já manipulável.
	 *
	 * @param caminhoArquivo Caminho completo do XML exemplo C://arquivo.xml.
	 * @return NFeModel.
	 */
	public static NFeModel getNfeModel(String caminhoArquivo) {
		caminho = caminhoArquivo;
		NFeModel nfeModel = new NFeModel();
		nfeModel.setEmitNfe(getEmitNfe());
		nfeModel.setProdutos(getItens());
		return nfeModel;

	}

	// ====================
	// EMITENTE
	// ====================
	public static EmitModel getEmitNfe() {

		EmitModel emit = new EmitModel();

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse(caminho);

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

	// ====================
	// PRODUTOS
	// ====================
	public static ArrayList<Produto> getItens() {

		ArrayList<Produto> lista = new ArrayList<>();

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse(caminho);

			NodeList listaDet = doc.getElementsByTagName("det");

			for (int i = 0; i < listaDet.getLength(); i++) {

				Produto produto = new Produto();
				ImpostoProduto imposto = new ImpostoProduto();
				Icms icms = new Icms();

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

				// ====================
				// IMPOSTO
				// ====================
				Node nodeImposto = listaProd.item(1);
				NodeList nodeListImposto = nodeImposto.getChildNodes();
				Element elementListImposto = (Element) nodeListImposto;

				// ====================
				// --> ICMS
				// ====================

				Node nodeIcms00 = nodeListImposto.item(1);
				NodeList nodeListIcms = nodeIcms00.getChildNodes();

				for (int j = 0; j < nodeListIcms.getLength(); j++) {

					Node nodeIcms = nodeListIcms.item(0);

					if (nodeIcms.getNodeType() == Node.ELEMENT_NODE) {

						NodeList filhos = nodeIcms.getChildNodes();

						for (int contIcms = 0; contIcms < filhos.getLength(); contIcms++) {

							Node filho = filhos.item(contIcms);
							Element el = (Element) filho;

							switch (el.getTagName()) {
							case "orig":
								icms.setOrig(el.getTextContent());
								break;
							case "CST":
								icms.setCst(el.getTextContent());
								break;
							case "modBC":
								icms.setModBC(el.getTextContent());
								break;
							case "vBC":
								icms.setvBC(Double.parseDouble(el.getTextContent()));
								break;
							case "pICMS":
								icms.setpICMS(Double.parseDouble(el.getTextContent()));
								break;
							case "vICMS":
								icms.setvICMS(Double.parseDouble(el.getTextContent()));
								break;

							}

						}

					}

				}

				// IPI
				NodeList nodeListIpi = elementListImposto.getElementsByTagName("IPI");
				imposto.setIpi(getIpi(nodeListIpi));

				// PIS
				NodeList nodeListPis = elementListImposto.getElementsByTagName("PIS");
				imposto.setPis(getPis(nodeListPis));

				// Cofins
				NodeList nodeListCofins = elementListImposto.getElementsByTagName("COFINS");
				imposto.setCofins(getCofins(nodeListCofins));

				imposto.setIcms(icms);
				produto.setImposto(imposto);
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

		return lista;

	}

	public static Ipi getIpi(NodeList nodeListIpi) {

		Ipi ipi = new Ipi();

		for (int i = 0; i < nodeListIpi.getLength(); i++) {

			Node nodeItemIpi = nodeListIpi.item(i);
			NodeList nodeItemListIpi = nodeItemIpi.getChildNodes();

			for (int j = 0; j < nodeItemListIpi.getLength(); j++) {

				Element el = (Element) nodeItemListIpi.item(j);

				switch (el.getTagName()) {
				case "CNPJProd":
					ipi.setCNPJProd(el.getTextContent());
					break;
				case "qSelo":
					ipi.setqSelo(el.getTextContent());
					break;
				case "cEnq":
					ipi.setcEnq(el.getTextContent());
					break;
				case "IPITrib":
					Node nodeIPITrib = el;
					NodeList nodeListIPITrib = nodeIPITrib.getChildNodes();
					ipi.setIpiTrib(getIpiTrib(nodeListIPITrib));
					break;

				}

			}

		}

		return ipi;
	}

	public static IpiTrib getIpiTrib(NodeList nodeList) {

		IpiTrib ipiTrib = new IpiTrib();

		for (int i = 0; i < nodeList.getLength(); i++) {

			Node node = nodeList.item(i);
			Element el = (Element) node;

			switch (el.getTagName()) {
			case "CST":
				ipiTrib.setCst(el.getTextContent());
				break;
			case "vBC":
				ipiTrib.setvBC(Double.parseDouble(el.getTextContent()));
				break;
			case "pIPI":
				ipiTrib.setpIPI(Double.parseDouble(el.getTextContent()));
				break;
			case "vIPI":
				ipiTrib.setvIPI(Double.parseDouble(el.getTextContent()));
				break;

			}

		}

		return ipiTrib;

	}

	public static Pis getPis(NodeList nodeList) {

		Pis pis = new Pis();
		PisAliq pisAliq = new PisAliq();

		for (int i = 0; i < nodeList.getLength(); i++) {

			Node node = nodeList.item(i).getFirstChild();
			NodeList n2 = node.getChildNodes();

			for (int j = 0; j < n2.getLength(); j++) {

				Element el = (Element) n2.item(j);

				switch (el.getTagName()) {
				case "CST":
					pisAliq.setCST(el.getTextContent());
					break;
				case "vBC":
					pisAliq.setvBC(Double.parseDouble(el.getTextContent()));
					break;
				case "pPIS":
					pisAliq.setpPIS(Double.parseDouble(el.getTextContent()));
					break;
				case "vPIS":
					pisAliq.setvPIS(Double.parseDouble(el.getTextContent()));
					break;

				}

			}

		}

		pis.setPisAliq(pisAliq);
		return pis;
	}

	public static Cofins getCofins(NodeList nodeList) {

		Cofins cofins = new Cofins();
		CofinsAliq cofinsAliq = new CofinsAliq();

		for (int i = 0; i < nodeList.getLength(); i++) {

			Node node = nodeList.item(i).getFirstChild();
			NodeList n2 = node.getChildNodes();

			for (int j = 0; j < n2.getLength(); j++) {

				Element el = (Element) n2.item(j);

				switch (el.getTagName()) {
				case "CST":
					cofinsAliq.setCST(el.getTextContent());
					break;
				case "vBC":
					cofinsAliq.setvBC(Double.parseDouble(el.getTextContent()));
					break;
				case "pCOFINS":
					cofinsAliq.setpCOFINS(Double.parseDouble(el.getTextContent()));
					break;
				case "vCOFINS":
					cofinsAliq.setvCOFINS(Double.parseDouble(el.getTextContent()));
					break;

				}

			}

		}

		cofins.setCofinsAliq(cofinsAliq);
		return cofins;
	}

}
