package com.perisic.sixeq.peripherals;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.TimerTask;
import javax.swing.*;

import com.perisic.sixeq.engine.Game;
import com.perisic.sixeq.engine.GameEngine;
import java.awt.Desktop;


import chrisGameProject.MainScreen;
import chrisGameProject.UserCookies;


/**
 * A Simple Graphical User Interface for the Six Equation Game.
 * 
 * @author Marc Conrad
 *
 */
public class GameGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = -107785653906635L;

	/**
	 * Method that is called when a button has been pressed.
	 */
	//Variable for the timer
     int counter = 0;
     Boolean isIt = false;
     
     
    
 	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int solution = Integer.parseInt(e.getActionCommand());
		boolean correct = myGame.checkSolution(currentGame, solution);
		int score = myGame.getScore(); 
		//String highScore = TopPlayer.GetHighScore();
		if (correct) {
			System.out.println("YEAH!");
			currentGame = myGame.nextGame(); 
			ImageIcon ii = new ImageIcon(currentGame);
			questArea.setIcon(ii);
			infoArea.setText("Good!  Score: "+score);
			
		} else { 
			System.out.println("Not Correct"); 
			infoArea.setText("Oops. Try again!  Score: "+score);
			highScoreinfoArea.setText("The Highest score is: "+" " + " "+ "User Name: " );
		}
		
	}

	JLabel questArea = null;
	GameEngine myGame = null;
	//GameEngine TopPlayer = null;
	URL currentGame = null;
	JTextArea infoArea = null;
	JTextArea infoRemainTime = null;
	JTextArea highScoreinfoArea = null;
	
	
/**
 * Initializes the game. 
 * @param player
 */
	private void initGame(String player) {
		setSize(690, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("What is the value of the heart?");
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		
		
		

		// Displays the Time Left
		JLabel lblNewLabel_2 = new JLabel("Time Left:-");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(Color.red);
		lblNewLabel_2.setBounds(71, 146, 89, 22);
		panel.add(lblNewLabel_2);

	

		myGame = new GameEngine(player);
		currentGame = myGame.nextGame();

		infoArea = new JTextArea(1, 30);
		
		infoRemainTime = new JTextArea(1, 2);
		
		highScoreinfoArea = new JTextArea(1, 30);
		
		
		
		infoArea.setEditable(false);
		infoArea.setText("What is the value of the Heart?   Score: 0");
		
		infoRemainTime.setEditable(false);
		
		highScoreinfoArea.setEditable(false);
		highScoreinfoArea.setText("");
		
		java.util.Timer timer = new java.util.Timer();// new timer
		counter = 30; // setting the counter to 20 seconds
		TimerTask task = new TimerTask() {
			public void run() {
				infoRemainTime.setText(Integer.toString(counter));// the timer label to counter
				counter --;
				if (counter == -1) {
					timer.cancel();
					Icon icon = new javax.swing.ImageIcon(getClass().getResource("EndGame.jpg"));
					//JOptionPane.showMessageDialog(null,"Oops! You Ran Out Of Time!!", "Game Over", JOptionPane.INFORMATION_MESSAGE,icon);
					int tryAgain = JOptionPane.showConfirmDialog(null,"Do You Want to Try Again", "Time Out!" + " Sorry You Ran Out Of Time",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,icon);
					if(tryAgain == JOptionPane.YES_OPTION) {
						
						GameGUI myGUI = new GameGUI();
						myGUI.setLocationRelativeTo(null);
						myGUI.setVisible(true);
						
					}else {
						dispose();
						UserCookies UCookies = new UserCookies();
						UCookies.setVisible(true);
						UCookies.setLocationRelativeTo(null);
						//System.exit(ABORT);
						
					}
					

				}
				else if(isIt) {
					timer.cancel();
					isIt = false;
				}
				
			}
		};
		timer.scheduleAtFixedRate(task, 1000, 1000);// 1000min seconds = 1second
		
		/*int time = Integer.parseInt (infoRemainTime.getText());
		int point = 1;
	    int score = myGame.getScore();
	    
	    if(time!=0)
	    {
	    	point=+score;
	    	myGame.getScore();
	    }
	    else if(time==0)
	    {
	    	JOptionPane.showMessageDialog(null,"'oops! Game Over you ran out of time'");
	    }*/
		
		
		JScrollPane infoRemainTimePana = new JScrollPane(infoRemainTime);
		panel.add(infoRemainTimePana);
		
		JScrollPane infoPane = new JScrollPane(infoArea);
		panel.add(infoPane);
		
		JScrollPane highScorePana = new JScrollPane(highScoreinfoArea);
		panel.add(highScorePana);

		ImageIcon ii = new ImageIcon(currentGame);
		questArea = new JLabel(ii);
	    questArea.setSize(330, 600);
	    
		JScrollPane questPane = new JScrollPane(questArea);
		panel.add(questPane);

		for (int i = 0; i < 10; i++) {
			JButton btn = new JButton(String.valueOf(i));
			panel.add(btn);
			btn.addActionListener(this);
		}

		getContentPane().add(panel);
		panel.repaint();
		
		
		
		
		JButton btnlogOut = new JButton("Log out");
		btnlogOut.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnlogOut.setForeground(Color.black);
		btnlogOut.setBounds(22, 405, 91, 25);
		panel.add(btnlogOut);
		
		btnlogOut.addActionListener(new ActionListener() {
			Icon icon = new javax.swing.ImageIcon(getClass().getResource("Wellcome Heart.png"));
			public void actionPerformed(ActionEvent e) {int option = JOptionPane.showConfirmDialog(null,"Are you Sure You Want to Logged Out!", "You Are About to Logout!",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,icon);
			if(option == JOptionPane.YES_OPTION) {
				timer.cancel();
				dispose();
				JOptionPane.showMessageDialog(null," Your Have Successful Logged Out!!", "Authentication", JOptionPane.INFORMATION_MESSAGE,icon);
				MainScreen frame = new MainScreen();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				
				
			}else {
				
				
				
			}
				
				

			}
		});


	}
/**
 * Default player is null. 
 */
	public GameGUI() {
		super();
		initGame(null);
	}
	/**
	 * Use this to start GUI, e.g., after login.
	 * 
	 * @param player
	 */
	public GameGUI(String player) {
		super();
		initGame(player);
	}
	

	/**
	 * Main entry point into the equation game.
	 * 
	 * @param args not used.
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	 

	
	public static void main(String[] args)  {
	
		GameGUI myGUI = new GameGUI();
		myGUI.setLocationRelativeTo(null);
		myGUI.setVisible(true);
		

		


	}
	
}