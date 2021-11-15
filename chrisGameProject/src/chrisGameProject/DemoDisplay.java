package chrisGameProject;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoDisplay {

	public static void main(String[] args) {
		
		NativeInterface.open();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame sdf = new JFrame("Heart Game Demo");
				sdf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
				sdf.getContentPane().add(getBrowser(),BorderLayout.CENTER);
				sdf.setBounds(350, 150, 690, 400);
				sdf.setVisible(true);

				JButton button = new JButton("Skip Demo");
        		button.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				
        			}
        		});
        		
        		sdf.getContentPane().add(button,BorderLayout.EAST);
        		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
        		button.setForeground(Color.black);
        		button.setBackground(new Color(204, 204, 255));
        		sdf.setVisible(true);
			}
			
		});
		
		
		NativeInterface.runEventPump();
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				NativeInterface.close();// closing NI
			}
			
		}));
	}
	   //this method will return panel with video
		public static JPanel getBrowser() {
			JPanel wbPanel = new JPanel(new BorderLayout());
			JWebBrowser wb = new JWebBrowser();
			wbPanel.add(wb, BorderLayout.CENTER);
			wb.setBarsVisible(false);
			//wb.navigate("https://www.youtube.com/watch_popup?v=cvi8A2XCK94");
			wb.navigate("https://youtu.be/277DpPflEvg./watch_popup?"); // use watch popup for fullscreen
			
			return wbPanel;

		}
		

	}


