package P3Pmerger;

import java.util.Iterator;
import org.dom4j.Element;

public class matchStatement {

	private String matchConsole = "";
	private String newline ="\n";
	private String newtab = "\t";
	private int flag = 0; 
	private String[] Statement;
	
	@SuppressWarnings("rawtypes")
	
	public String match(Element root1, Element root2)
	{
		for(Iterator i1 = root1.elementIterator(); i1.hasNext();)
		{
			Element firstrow1 = (Element) i1.next(); //Statement
			for(Iterator j1 = root2.elementIterator(); j1.hasNext();)
			{
				Element firstrow2 = (Element) j1.next();//Statement
				if((firstrow1.getQualifiedName() == "STATEMENT") && (firstrow2.getQualifiedName() == "STATEMENT"))
				{
					matchConsole += newline+ "<STATEMENT> Match Found" +newline;
				for(Iterator i2 = firstrow1.elementIterator(); i2.hasNext();)
				{
					Element secondrow1 = (Element) i2.next(); //Data-Group
					for(Iterator j2 = firstrow2.elementIterator(); j2.hasNext();)
					{
						Element secondrow2 = (Element) j2.next(); //Data-Group
						//if the element is DATA-GROUP do 
						if((secondrow1.getName().equals("DATA-GROUP")) && (secondrow2.getName().equals("DATA-GROUP")))
						{
							for(Iterator i3 = secondrow1.elementIterator(); i3.hasNext();)
							{
								Element thirdrow1 = (Element) i3.next();
								matchConsole += newline+"<DATA> :"+newtab+ thirdrow1.attributeValue("ref");							
							}
							
							for(Iterator j3 = secondrow2.elementIterator(); j3.hasNext();)
							{
								Element thirdrow2 = (Element) j3.next();
								matchConsole += newline+"<DATA> :"+newtab+ thirdrow2.attributeValue("ref");
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
