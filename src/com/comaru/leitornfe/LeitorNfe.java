package com.comaru.leitornfe;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.comaru.leitornfe.model.Cofins;
import com.comaru.leitornfe.model.CofinsAliq;
import com.comaru.leitornfe.model.Destinatario;
import com.comaru.leitornfe.model.EmitModel;
import com.comaru.leitornfe.model.EnderDest;
import com.comaru.leitornfe.model.EnderEmit;
import com.comaru.leitornfe.model.Icms;
import com.comaru.leitornfe.model.ImpostoProduto;
import com.comaru.leitornfe.model.Ipi;
import com.comaru.leitornfe.model.IpiTrib;
import com.comaru.leitornfe.model.NFeModel;
import com.comaru.leitornfe.model.Pis;
import com.comaru.leitornfe.model.PisAliq;
import com.comaru.leitornfe.model.Produto;

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
		nfeModel = getIde(nfeModel);
		nfeModel.setEmitNfe(getEmitNfe());
		nfeModel.setDestNfe(getDestNfe());
		nfeModel.setProdutos(getItens());
		return nfeModel;

	}

	public static NFeModel getIde(NFeModel nfeModel) {

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(caminho);

			NodeList lista = doc.getElementsByTagName("infNFe");
			Node node = lista.item(0);
			NamedNodeMap map = node.getAttributes();

			nfeModel.setInfNFe(map.getNamedItem("Id").getNodeValue());
			nfeModel.setVersao(map.getNamedItem("versao").getNodeValue());

			NodeList listaIde = doc.getElementsByTagName("ide");
			Node nodeIde = listaIde.item(0);

			NodeList filhos = nodeIde.getChildNodes();

			for (int i = 0; i < filhos.getLength(); i++) {

				Node filho = filhos.item(i);

				Element el = (Element) filho;

				switch (el.getTagName()) {
				case "cUF":
					nfeModel.setcUF(Integer.parseInt(el.getTextContent()));
					break;
				case "cNF":
					nfeModel.setcNF(el.getTextContent());
					break;
				case "natOp":
					nfeModel.setNatOp(el.getTextContent());
					break;
				case "mod":
					nfeModel.setMod(el.getTextContent());
					break;
				case "serie":
					nfeModel.setSerie(el.getTextContent());
					break;
				case "nNF":
					nfeModel.setnNF(el.getTextContent());
					break;
				case "dhEmi":
					nfeModel.setDhEmi(el.getTextContent());
					break;
				case "dhSaiEnt":
					nfeModel.setDhSaiEnt(el.getTextContent());
					break;
				case "tpNF":
					nfeModel.setTpNF(el.getTextContent());
					break;
				case "idDest":
					nfeModel.setIdDest(Integer.parseInt(el.getTextContent()));
					break;
				case "cMunFG":
					nfeModel.setcMunFG(Integer.parseInt(el.getTextContent()));
					break;
				case "tpImp":
					nfeModel.setTpImp(Integer.parseInt(el.getTextContent()));
					break;
				case "tpEmis":
					nfeModel.setTpEmis(Integer.parseInt(el.getTextContent()));
					break;
				case "cDV":
					nfeModel.setcDV(Integer.parseInt(el.getTextContent()));
					break;
				case "tpAmb":
					nfeModel.setTpAmb(Integer.parseInt(el.getTextContent()));
					break;
				case "finNFe":
					nfeModel.setFinNFe(Integer.parseInt(el.getTextContent()));
					break;
				case "indFinal":
					nfeModel.setIndFinal(Integer.parseInt(el.getTextContent()));
					break;
				case "indPres":
					nfeModel.setIndPres(Integer.parseInt(el.getTextContent()));
					break;
				case "indIntermed":
					nfeModel.setIndIntermed(Integer.parseInt(el.getTextContent()));
					break;
				case "verProc":
					nfeModel.setVerProc(el.getTextContent());
					break;
				}

			}

			return nfeModel;

		} catch (

		ParserConfigurationException ex) {
			ex.printStackTrace();
		} catch (SAXException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

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

					Element el = (Element) filho;

					switch (el.getTagName()) {
					case "CNPJ":
						emit.setCNPJ(el.getTextContent());
						break;
					case "xNome":
						emit.setxNome(el.getTextContent());
						break;
					case "xFant":
						emit.setxFant(el.getTextContent());
						break;
					case "IE":
						emit.setIE(el.getTextContent());
						break;
					case "CRT":
						emit.setIE(el.getTextContent());
						break;
					case "CNAE":
						emit.setCNAE(el.getTextContent());
						break;
					case "IM":
						emit.setIM(el.getTextContent());
						break;
					case "enderEmit":
						Node nodeEnderEmit = el;
						NodeList nodeListNodeEnderEmit = nodeEnderEmit.getChildNodes();
						emit.setEnderEmit(getEnderEmit(nodeListNodeEnderEmit));
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
	// DEST
	// ====================
	public static Destinatario getDestNfe() {

		Destinatario dest = new Destinatario();

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse(caminho);

			NodeList lista = doc.getElementsByTagName("dest");

			Node node = lista.item(0);

			if (node.getNodeType() == Node.ELEMENT_NODE) {

				NodeList filhos = node.getChildNodes();

				for (int i = 0; i < filhos.getLength(); i++) {

					Node filho = filhos.item(i);

					Element el = (Element) filho;

					switch (el.getTagName()) {
					case "CNPJ":
						dest.setCNPJ(el.getTextContent());
						break;
					case "xNome":
						dest.setxNome(el.getTextContent());
						break;
					case "indIEDest":
						dest.setIndIEDest(Integer.parseInt(el.getTextContent()));
						break;
					case "IE":
						dest.setIE(el.getTextContent());
						break;
					case "email":
						dest.setEmail(el.getTextContent());
						break;
					case "enderDest":
						Node nodeEnderDest = el;
						NodeList nodeListNodeEnderDest = nodeEnderDest.getChildNodes();
						dest.setEnderDest(getEnderDest(nodeListNodeEnderDest));
						break;
					}

				}

			}

			return dest;

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

	public static EnderEmit getEnderEmit(NodeList nodeList) {

		EnderEmit enderEmit = new EnderEmit();

		for (int i = 0; i < nodeList.getLength(); i++) {

			Node node = nodeList.item(i);
			Element el = (Element) node;

			switch (el.getTagName()) {
			case "xLgr":
				enderEmit.setxLgr(el.getTextContent());
				break;
			case "nro":
				enderEmit.setnro(el.getTextContent());
				break;
			case "xCpl":
				enderEmit.setxCpl(el.getTextContent());
				break;
			case "xBairro":
				enderEmit.setxBairro(el.getTextContent());
				break;
			case "cMun":
				enderEmit.setcMun(Integer.parseInt(el.getTextContent()));
				break;
			case "xMun":
				enderEmit.setxMun(el.getTextContent());
				break;
			case "UF":
				enderEmit.setUF(el.getTextContent());
				break;
			case "CEP":
				enderEmit.setCEP(el.getTextContent());
				break;
			case "cPais":
				enderEmit.setcPais(Integer.parseInt(el.getTextContent()));
				break;
			case "xPais":
				enderEmit.setxPais(el.getTextContent());
				break;
			case "fone":
				enderEmit.setFone(el.getTextContent());
				break;

			}

		}

		return enderEmit;

	}

	public static EnderDest getEnderDest(NodeList nodeList) {

		EnderDest enderDest = new EnderDest();

		for (int i = 0; i < nodeList.getLength(); i++) {

			Node node = nodeList.item(i);
			Element el = (Element) node;

			switch (el.getTagName()) {
			case "xLgr":
				enderDest.setxLgr(el.getTextContent());
				break;
			case "nro":
				enderDest.setnro(el.getTextContent());
				break;
			case "xCpl":
				enderDest.setxCpl(el.getTextContent());
				break;
			case "xBairro":
				enderDest.setxBairro(el.getTextContent());
				break;
			case "cMun":
				enderDest.setcMun(Integer.parseInt(el.getTextContent()));
				break;
			case "xMun":
				enderDest.setxMun(el.getTextContent());
				break;
			case "UF":
				enderDest.setUF(el.getTextContent());
				break;
			case "CEP":
				enderDest.setCEP(el.getTextContent());
				break;
			case "cPais":
				enderDest.setcPais(Integer.parseInt(el.getTextContent()));
				break;
			case "xPais":
				enderDest.setxPais(el.getTextContent());
				break;
			case "fone":
				enderDest.setFone(el.getTextContent());
				break;

			}

		}

		return enderDest;

	}

}
