//toy program with counter button and exit button

import javax.swing.*;
import java.awt.event.*;

public class swing_exitbutton extends JFrame{

	public static void main(String[] args) {
		new swing_exitbutton();

	}
	//private class variables
	private JButton button1, exitButton;
	private int count=0;
	swing_exitbutton(){
		this.setSize(400, 400);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		JPanel panel1=new JPanel();
		//want to add a window listener that can catch the user closing the window
		//from the frame itself.  Use anonymous inner class
		addWindowListener(new WindowAdapter()
			{
			//make sure you spell the method correctly
				public void windowClosing(WindowEvent e)
				{
					exitButton.doClick();
				}
			});
		
		
		button1=new JButton("Click me!");
		exitButton=new JButton("Exit");
		button1.addActionListener(e -> doClick());
		exitButton.addActionListener(e -> exitWindow());
		panel1.add(button1);
		panel1.add(exitButton);
		this.add(panel1);
		this.setVisible(true);
		
	}
	private void doClick(){
		count++;
		if(count==1){
			button1.setText("I have been clicked!");
		}
		else if(1<count & count <=25){
			button1.setText("I have been clicked "+count+" times!");
		}
		else{
			button1.setText("STAPH!");
		}
	}
	private void exitWindow(){
		if(0<count){
			System.exit(0);
		}
		else{
			//JOptionPane pane = new JOptionPane();
			//make sure to set the place you display the pane as the window NOT the button
			JOptionPane.showMessageDialog(this.getOwner(), "You must click the button at least once!");
			
			
		}
	}
}
