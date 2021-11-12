package chrisGameProject;
import java.awt. *;
import java. awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class WebBrowerDemo {
	private JFrame frame;
	private JPanel Paneltop;
	private JEditorPane editor;
	private JScrollPane scroll;
	private JTextField field;
	private JButton button;
	private URL url;
	public WebBrowerDemo(String title) {
		
	    initComponents();
	    frame.setTitle(title);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(800, 6000);
	    frame.add(BorderLayout.NORTH,Paneltop);
	    Paneltop.add(field);
		frame.add(BorderLayout.CENTER, scroll);
		frame.setVisible(true);
	}
		private void initComponents() {
			frame = new JFrame();
			Paneltop = new JPanel();
			try {
				url = new URL ("https://www.google.com");
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				editor = new JEditorPane(url);
				editor.setEditable(false);
			}
			catch (IOException e) {
				JOptionPane.showMessageDialog(null, e);
			}
			scroll = new JScrollPane(editor,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			field = new JTextField();
			SwingUtilities.invokeLater(new Runnable() {
				public void run( ) {
					field.setText(url.toString());
					Paneltop.add(button);
				}
				
			});
			
			button = new JButton("GO");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						editor.setPage(field.getText());
					}
					catch (IOException ioe) {
				JOptionPane.showMessageDialog(null, ioe);
			}

				}
				
				
			});
			
		}
		public static void main(String a[]) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new WebBrowerDemo("Simple WebBrowerDemo");
				}
			});
		

		}
	}


