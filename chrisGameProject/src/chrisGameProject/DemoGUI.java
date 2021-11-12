package chrisGameProject;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import javax.swing.*;
import com.perisic.sixeq.peripherals.GameGUI;


import chrisGameProject.DemoEngine;
import chrisGameProject.DemoGUI;


/**
 * A Simple Graphical User Interface for the Game Demo.
 * 
 * @author Christopher Igiebor
 *
 */

public class DemoGUI extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public void actionPerformed1(ActionEvent e) {
		int solution = Integer.parseInt(e.getActionCommand());
	    boolean correct = myDemo.current(currentDemo);
		//int score = myDemo.getScore(); 
		
		if (correct) {
			System.out.println("YEAH!");
			currentDemo = myDemo.Demo(); 
			ImageIcon ii = new ImageIcon(currentDemo);
			questArea.setIcon(ii);
			
			
		} else { 
			System.out.println("Not Correct"); 
			infoArea.setText("Oops. Try again!  Score: ");
			
		}
		
	}
	
	
	JLabel questArea = null;
	DemoEngine myDemo = null;
	
	URL currentDemo = null;
	JTextArea infoArea = null;
	
/**
 * Initializes the Demo. 
 * @param player
 */
	private void initDemo(String player) {
		setSize(690, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Game Demo Display Menu");
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		


		
		// Displays the Demo
		/*JLabel lblNewLabel_2 = new JLabel("Heart Game Demo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(Color.black);
		lblNewLabel_2.setBounds(71, 146, 89, 22);
		panel.add(lblNewLabel_2);*/
		
		

		myDemo = new DemoEngine(player);
		currentDemo = myDemo.Demo();
		
		infoArea = new JTextArea(1, 10);
		infoArea.setEditable(false);
		infoArea.setText("Heart Game Demo");
    	JScrollPane infoPane = new JScrollPane(infoArea);
		panel.add(infoPane);
		
		ImageIcon ii = new ImageIcon(currentDemo);
		questArea = new JLabel(ii);
	    questArea.setSize(330, 600);
	    
		JScrollPane questPane = new JScrollPane(questArea);
		panel.add(questPane);

		/*for (int i = 0; i < 10; i++) {
			JButton btn = new JButton(String.valueOf(i));
			panel.add(btn);
			btn.addActionListener(this);
		}*/

		getContentPane().add(panel);
		panel.repaint();
		
		JButton btnskipdemo = new JButton("Skip Demo");
		btnskipdemo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnskipdemo.setForeground(Color.black);
		btnskipdemo.setBounds(22, 405, 91, 25);
		panel.add(btnskipdemo);
		
		btnskipdemo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				GameGUI myGUI = new GameGUI();
	    		myGUI.setLocationRelativeTo(null);
	    		myGUI.setVisible(true);
			}
		});

	}
	
/**
 * Default player is null. 
 */
	public DemoGUI() {
		super();
		initDemo(null);
	}
	/**
	 * Use this to start GUI, e.g., after login.
	 * 
	 * @param player
	 */
	public DemoGUI(String player) {
		super();
		initDemo(player);
	}
	

	/**
	 * Main entry point into the equation game.
	 * 
	 * @param args not used.
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	 

	
	public static void main(String[] args)  {
	
		DemoGUI dmGUI = new DemoGUI();
		dmGUI.setLocationRelativeTo(null);
		dmGUI.setVisible(true);
		
		


	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	}
	


