package loadparse;

import java.io.FileReader;
import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import help.Const;

public class AppakLoadMock implements Load {
	
	public boolean load(String fileName) {
		XMLReader XMLReader;
		try {
			XMLReader = XMLReaderFactory.createXMLReader();
			AppakParser parser = new AppakParser();
			XMLReader.setContentHandler(parser);
			XMLReader.setErrorHandler(parser);
			System.out.println("loading");
			if (fileName.length() == 49) { 
				FileReader r = new FileReader(Const.OUTPUTDONE + fileName);
				XMLReader.parse(new InputSource(r));
				System.out.println("load good");
				return true;
			} else {
				return false;
			}
		} catch (SAXException | IOException e) {
			return false;
		}
	}
}
