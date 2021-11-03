package com.perisic.sixeq.engine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Main class where the games are coming from. 
 * Basic functionality
 */
public class GameEngine {
	String thePlayer = null;

	/**
	 * Each player has their own game engine.
	 * 
	 * @param player
	 */
	public GameEngine(String player) {
		thePlayer = player;
	}
	
    //Variable for high score 
    
    private String highScore = ""; // telling the game that an higher score is not set
    

	int counter = 0;
	int score = 0; 
	GameServer theGames = new GameServer(); 
	Game current = null; 
/*
 * Retrieves a game. This basic version only has two games that alternate.
 */
	public URL nextGame() {		
			try {
				current = theGames.getRandomGame();
				return current.getLocation(); 
			} catch (MalformedURLException e) {
				System.out.println("Something went wrong when trying to retrieve game "+counter+"!"); 
				e.printStackTrace();
				return null; 
			} 
		
	}

	/**
	 * Checks if the parameter i is a solution to the game URL. If so, score is increased by one. 
	 * @param game
	 * @param i
	 * @return
	 */
	public boolean checkSolution(URL game, int i) {
		if (i == current.getSolution()) {
			score++; 
			return true;
		} else {
			return false;
		}
	}



	/**
	 * Retrieves the score. 
	 * 
	 * @param player
	 * @return
	 */
	
	
	public int getScore() {
		return score;
	}

	public String GetHighScore() {
		
		//Format:   Christopher: 100
		FileReader readFile = null;
		BufferedReader reader = null;
		
		if (highScore.equals("")) //remove
		{
			
			//init the highscore
			highScore = this.GetHighScore();
			
			
		}//remove
		
		try {
			 readFile = new FileReader("highscore.dat");
			 reader = new BufferedReader(readFile);
			return reader.readLine();
		}
		
		
		catch (Exception e)
		{
			return "0";
		}
		finally
		{
			try {
				if(reader != null)
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}

}
