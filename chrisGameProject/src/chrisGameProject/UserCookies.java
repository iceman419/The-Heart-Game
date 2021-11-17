package chrisGameProject;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.perisic.sixeq.peripherals.GameGUI;
import java.awt.BorderLayout;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UserCookies extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextField usernameTF;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserCookies UCookies = new UserCookies();
					UCookies.setVisible(true);
					UCookies.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public UserCookies() {
		setTitle("Cookies");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 436);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				NativeInterface.open();
				JFrame sdf = new JFrame("Heart Game Demo");
				sdf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
				sdf.getContentPane().add(DemoDisplay.getBrowser(),BorderLayout.CENTER); 
				sdf.setBounds(350, 150, 690, 400);
				sdf.setVisible(true);
			
        		
        	    JButton button = new JButton("Skip Demo");
                button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                sdf.dispose();
                
        		GameGUI myGUI = new GameGUI();
        		myGUI.setLocationRelativeTo(null);
        		myGUI.setVisible(true);
                	    		
            	}
                	});
               		
       		    sdf.getContentPane().add(button,BorderLayout.EAST);
        		button.setFont(new Font("Tahoma", Font.BOLD, 18));
        		button.setForeground(Color.black);
		        button.setBackground(new Color(204, 204, 255));
        		sdf.setVisible(true);
				
//				dispose();
//				
//				GameGUI myGUI = new GameGUI();
//	    		myGUI.setLocationRelativeTo(null);
//	    		myGUI.setVisible(true);

			}
		});
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPlay.setBounds(240, 21, 179, 78);
		contentPane.add(btnPlay);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Icon icon = new javax.swing.ImageIcon(getClass().getResource("Wellcome Heart.png"));
				JOptionPane.showMessageDialog(null," Your Have Successful Logged Out!!", "Authentication", JOptionPane.INFORMATION_MESSAGE,icon);
				dispose();
				MainScreen frame = new MainScreen();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogout.setBounds(240, 311, 179, 78);
		contentPane.add(btnLogout);
		
		JButton btnscoreBoard = new JButton("Score Board");
		btnscoreBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ScoreBoard frame = new ScoreBoard();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnscoreBoard.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnscoreBoard.setBounds(240, 109, 179, 78);
		contentPane.add(btnscoreBoard);
		
		JButton btnNewButton = new JButton("My Score");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MyScore frame = new MyScore();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(240, 207, 179, 78);
		contentPane.add(btnNewButton);
	}
}
