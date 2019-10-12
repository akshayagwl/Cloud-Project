package P3Pmerger;

import java.util.Iterator;
import org.dom4j.Attribute;
import org.dom4j.Element;

public class matchDispute {
	private String matchConsole = "";
	private String newline = "\n";
	private String newtab = "\t";
	
	@SuppressWarnings("rawtypes")
	public String match(Element root1, Element root2)
	{
		for(Iterator i1 = root1.elementIterator(); i1.hasNext();)
		{
			Element firstrow1 = (Element) i1.next(); // DISPUTE-GROUPS1
			for(Iterator j1 = root2.elementIterator(); j1.hasNext();)
			{
				Element firstrow2 = (Element) j1.next(); // DISPUTE-GROUPS2
				if((firstrow1.getQualifiedName() == "DISPUTES-GROUP") && (firstrow2.getQualifiedName() == "DISPUTES-GROUP"))
				{
					matchConsole += newline+"<DISPUTES-GROUP> Match Found";
					for(Iterator i2 = firstrow1.elementIterator(); i2.hasNext();)
					{
						Element secondrow1 = (Element) i2.next(); //DISPUTES
						Attribute attribute1 = secondrow1.attribute("resolution-type");
						for(Iterator j2 = firstrow2.elementIterator(); j2.hasNext();)
						{
							Element secondrow2 = (Element) j2.next(); //DISPUTES
							Attribute attribute2 = secondrow2.attribute("resolution-type");
							if((secondrow1.getQualifiedName() == "DISPUTES") && (secondrow2.getQualifiedName() == "DISPUTES"))
							{
								matchConsole += newline+newtab+"<DISPUTES> Match Found";
								if(attribute1.getName().equals("resolution-type") && attribute2.getName().equals("resolution-type"))
								{
									
									if(attribute1.getValue().equals(attribute2.getValue()))
									{
										matchConsole += newline + newtab + "<DISPUTES>new = <DISPUTES>A";
									}else
									{
										matchConsole += newline + newtab + "<DISPUTES>new = Apply rule (<DISPUTES>A, <DISPUTES>B)";
									}
								}
							}
							
						}
						
					}
						
					
				}
				
			}
			
		}
		return matchConsole;	
	}
}
