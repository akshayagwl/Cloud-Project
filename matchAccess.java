package P3Pmerger;

import java.util.Iterator;
import org.dom4j.Element;

public class matchAccess {
	
	private String matchConsole = "";
	private String newline = "\n";
	private String newtab = "\t";
	
	@SuppressWarnings("rawtypes")
	public String match(Element root1, Element root2)
	{
		for(Iterator i1 = root1.elementIterator(); i1.hasNext();)
		{
			Element firstrow1 = (Element) i1.next(); // Access1
			
			for(Iterator j1 = root2.elementIterator(); j1.hasNext();)
			{
				Element firstrow2 = (Element) j1.next();
				if(firstrow1.getQualifiedName().equals("ACCESS") && firstrow2.getQualifiedName().equals("ACCESS"))
				{
					matchConsole = newline+newline +"<ACCESS> Found" + newline;
					Iterator iter1 = firstrow1.elementIterator();
					while(iter1.hasNext())
					{
						Iterator iter2 = firstrow2.elementIterator();
						Element element1 = (Element)iter1.next();
						
						while(iter2.hasNext())
						{
							Element element2 = (Element)iter2.next();
							if(element1.getQualifiedName().equalsIgnoreCase(element2.getQualifiedName()))
							{
								matchConsole += "<ACCESS>new_value = <ACCESS>A_value";
							}else
							{
								matchConsole += newtab+"<ACCESS>new_value = Apply Rule (<ACCESS>A_value, <ACCESS>B_value)";
							}
						}
					}
				}
			}
		}
		matchConsole += newline; 
		return matchConsole; 
	}
}
