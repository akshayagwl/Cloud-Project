package P3Pmerger;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;

public class mergeP3P {

	private Document document;
	private Element entityElement;
	private Element policyElement;
	
	public void merge(String name, String discuri, String opturi)
	{
		document = DocumentHelper.createDocument();
		policyElement = document.addElement("POLICY");
		
		//adding attributes to the policy tags
		policyElement.addAttribute("name", name);
		policyElement.addAttribute("discuri", discuri);
		policyElement.addAttribute("opturi", opturi);
	}
	
	public Document merged(Document doc1, Document doc2)
	{
		Element root1 =  doc1.getRootElement();
		Element root2 =  doc2.getRootElement();

		mergeEntity objEntity = new mergeEntity();
		Element tryElement = objEntity.mergeElement(root1, root2);
		
		System.out.println("\n" + tryElement.asXML());
		return document;
	}
}
