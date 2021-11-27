package com.perisic.sixeq.peripherals;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TimerTask;
import javax.swing.*;
import com.perisic.sixeq.engine.GameEngine;

import chrisGameProject.CreateAccount;
import chrisGameProject.MainScreen;
import chrisGameProject.UserCookies;
import chrisGameProject.UserLogin;

/**
 * A Simple Graphical User Interface for the Six Equation Game.
 * 
 * @author Marc Conrad
 *
 */
public class GameGUI extends JFrame implements ActionListener {	
	private static final long serialVersionUID = -107785653906635L;
	
	//Variable for the timer
     int counter = 0;
     Boolean isIt = false;
     

 	/**
 	 * Method that is called when a button has been pressed.
 	 */    
     
	@Override
	public void actionPerformed(ActionEvent e) {
		int solution = Integer.parseInt(e.getActionCommand());
		boolean correct = myGame.checkSolution(currentGame, solution);
		int score = myGame.getScore(); 
		
		if (correct) {
			//System.out.println("YEAH!");
			currentGame = myGame.nextGame(); 
			ImageIcon ii = new ImageIcon(currentGame);
			questArea.setIcon(ii);
			infoArea.setText("Good!  Score: "+score);
			
		} else { 
			//System.out.println("Not Correct"); 
			infoArea.setText("Oops. Try again!  Score: "+score);
		}
		
	}

	JLabel questArea = null;
	GameEngine myGame = null;
	URL currentGame = null;
	JTextArea infoArea = null;
	JTextArea infoRemainTime = null;
	JTextArea usernameDisplay = null;
	
	String user =  UserLogin.dummyvar; //Variable for getting the Users name from userlogin method
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
		JLabel lblNewLabel_2 = new JLabel("Time Left");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setForeground(Color.black);
		lblNewLabel_2.setBounds(71, 146, 89, 22);
		panel.add(lblNewLabel_2);

		myGame = new GameEngine(player);
		currentGame = myGame.nextGame();

		infoArea = new JTextArea(1, 30);
		
		infoRemainTime = new JTextArea(1, 2);
		
		usernameDisplay = new JTextArea(1, 15);
		
		infoArea.setEditable(false);
		infoArea.setFont(new Font("Tahoma", Font.BOLD, 12));
		infoArea.setForeground(Color.red);
		infoArea.setText("What is the value of the Heart?   Score: 0");  		
		
		infoRemainTime.setEditable(false);
		infoRemainTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		infoRemainTime.setForeground(Color.RED);
		
		usernameDisplay.setEditable(false);
		usernameDisplay.setText("Welcome " + user);
		usernameDisplay.setFont(new Font("Tahoma", Font.BOLD, 14));
		usernameDisplay.setForeground(Color.blue);
		
		java.util.Timer timer = new java.util.Timer();// new timer
		counter = 30; // setting the counter to 30 seconds
		
		TimerTask task = new TimerTask() {
			public void run() {
				infoRemainTime.setText(Integer.toString(counter));// the timer label to counter
				counter --;
				if (counter == -1) {
					timer.cancel();
					
		 try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamepdb","root","");
		Statement stat = con.createStatement();
		int score = myGame.getScore();
		LocalDate dateNow = java.time.LocalDate.now();
		LocalTime timeNow = java.time.LocalTime.now();
		String user =  UserLogin.dummyvar;
		//String user = UserLogin.usernameTF.getText();
		String sql= "insert into Scoreboard(Serial,Date,Time,Username,Score) values(null,'"+dateNow+"','"+timeNow+"','"+user+"','"+score+"')";
		stat.executeUpdate(sql);
					    
	    }
	   catch(Exception y){
	   System.out.println(y);
	   
	    }
		 
	Icon icon = new javax.swing.ImageIcon(getClass().getResource("EndGame.jpg"));
	int tryAgain = JOptionPane.showConfirmDialog(null,"Do You Want to Try Again ", "Time Out!" + " Sorry " + user+" You Ran Out Of Time",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,icon);
	if(tryAgain == JOptionPane.YES_OPTION)
  {	   dispose();	
	   GameGUI myGUI = new GameGUI();
	   myGUI.setLocationRelativeTo(null);
	   myGUI.setVisible(true);
						
  }else {
		dispose();
		UserCookies UCookies = new UserCookies();
		UCookies.setVisible(true);
		UCookies.setLocationRelativeTo(null);
						
	    }
  }
 else if(isIt) {
					timer.cancel();
					isIt = false;
				}
			}
		};
		
		timer.scheduleAtFixedRate(task, 1000, 1000);// 1000min seconds = 1second
		
		
		JScrollPane infoRemainTimePana = new JScrollPane(infoRemainTime);
		panel.add(infoRemainTimePana);
		
		JScrollPane infoPane = new JScrollPane(infoArea);
		panel.add(infoPane);
		
		JScrollPane usernamePana = new JScrollPane(usernameDisplay);
		panel.add(usernamePana);

		ImageIcon ii = new ImageIcon(currentGame);
		questArea = new JLabel(ii);
	    questArea.setSize(330, 600);
	    
		JScrollPane questPane = new JScrollPane(questArea);
		panel.add(questPane);


		for (int i = 0; i < 10; i++) {
			JButton btn = new JButton(String.valueOf(i));
			panel.add(btn);
			btn.addActionListener(this);
			btn.setFont(new Font("Tahoma", Font.BOLD, 16));
			btn.setForeground(Color.magenta);
		}

		getContentPane().add(panel);
		panel.repaint();

		
		JButton btnlogOut = new JButton("Log out");
		btnlogOut.setFont(new Font("Tahoma", Font.BOLD, 16));
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