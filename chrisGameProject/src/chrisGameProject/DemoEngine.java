package chrisGameProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.perisic.sixeq.engine.Game;
import com.perisic.sixeq.engine.GameServer;

/**
 * Main class where the Demo is coming from. 
 *
 */
public class DemoEngine {

	String thePlayer = null;
	

	/**
	 * Each player has their own Demo engine.
	 * 
	 * @param player
	 */
	public DemoEngine(String player) {
		thePlayer = player;
	}

	DemoServer theDemos = new DemoServer(); 
	Demo current = null; 
/*
 * Retrieves a Demo.
 */
	public URL Demo() {		
			try {
				current = theDemos.getDemo();
				return current.getLocation(); 
			} catch (MalformedURLException e) {
				System.out.println("Something went wrong when trying to retrieve demo"); 
				e.printStackTrace();
				return null; 
			} 
		
	}
	public boolean current(URL currentDemo) {
		// TODO Auto-generated method stub
		return false;
	}
		

}
