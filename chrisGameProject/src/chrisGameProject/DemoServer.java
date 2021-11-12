package chrisGameProject;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Game that interfaces to an external Server to retrieve Demo
 * 
 * @author Christopher Igiebor
 *
 */
public class DemoServer {
	


	/**
	 * @throws MalformedURLException
	 */
	public Demo getDemo() throws MalformedURLException { 
		String urlLocation = "https://youtu.be/AZ_1nnAOclE";
		URL url = new URL(urlLocation); 
		return new Demo(url);
		
		
	}



}
