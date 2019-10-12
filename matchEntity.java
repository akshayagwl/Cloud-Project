package P3Pmerger;

import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Element;

public class matchEntity {
	private String matchConsole = "";
	private String newline = "\n";
	private String newtab = "\t";
	private int flag = 0; 

	@SuppressWarnings("rawtypes")
	public String match(Element root1, Element root2)
	{

		for(Iterator i1 = root1.elementIterator(); i1.hasNext();)
		{
			Element firstrow1 = (Element) i1.next(); // Entity1
			for(Iterator j1 = root2.elementIterator(); j1.hasNext();)
			{
				Element firstrow2 = (Element) j1.next(); // Entity2
				if((firstrow1.getQualifiedName() == "ENTITY") && (firstrow2.getQualifiedName() == "ENTITY"))
				{	
					for(Iterator i2 = firstrow1.elementIterator(); i2.hasNext();)
					{   
						Element secondrow1 = (Element) i2.next(); // DATA-GROUP1
						
						 for(Iterator j2 = firstrow2.elementIterator(); j2.hasNext();)
						{
							Element secondrow2 = (Element) j2.next(); // DATA-GROUP2
							
							if((secondrow1.getQualifiedName() == "DATA-GROUP") && (secondrow2.getQualifiedName() == "DATA-GROUP"))
							{
								for(Iterator i3 = secondrow1.elementIterator(); i3.hasNext();)
								{
									Element thirdrow1 = (Element) i3.next(); // DATA1 Row
									
									for(Iterator j3 = secondrow2.elementIterator(); j3.hasNext();)
									{
										Element thirdrow2 = (Element) j3.next(); // DATA2 row
									if((thirdrow1.getQualifiedName() == "DATA") && (thirdrow2.getQualifiedName() == "DATA"))
									{
										Iterator iter1 = thirdrow1.attributeIterator();
										while(iter1.hasNext())
										{
											Iterator iter2 = thirdrow2.attributeIterator();
											Attribute attribute1 = (Attribute)iter1.next();
											while(iter2.hasNext())
											{
												Attribute attribute2 = (Attribute)iter2.next();
											
											if((attribute1.getName().equals("ref")) &&(attribute1.getValue().equals("#business.name")))
											{
												if((attribute2.getName().equals("ref")) &&(attribute2.getValue().equals("#business.name")))
												{
													if((thirdrow1.getText().equals(thirdrow2.getText())))
													{	
														flag = flag + 1 ;
													} else 
													{
														flag = 0;
													}
													
												}
											}
															
											}
											
										}
									}
									
									}
								}
							}
						}
					}
				}
			}
		}
		if(flag > 0){
			matchConsole += "<ENTITY>  Match FOUND" + newline + newtab+"<DATA-GROUP>new  = <DATA-GROUP> A" ;
		} else 
		{
			matchConsole += matchConsole += "<ENTITY>  Match FOUND" + newline +newtab+ "<DATA-GROUP>new  = <DATA-GROUP> A + B" ;
		}
		return matchConsole;
	}
	

}
