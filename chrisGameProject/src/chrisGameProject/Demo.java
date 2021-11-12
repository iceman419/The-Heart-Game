package chrisGameProject;

import java.net.URL;

public class Demo {
	URL location = null; 
	/**
	 * Location of the Demo.
	 * @param location
	 */
	public Demo(URL location) {
		super();
		this.location = location;
	}
	/**
	 * The location of the Demo. 
	 * @return the location of the Demo.
	 */
	public URL getLocation() {
		return location;
	}


}
