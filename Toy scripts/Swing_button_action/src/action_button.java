//Toy program for getting a button to trigger an action
import javax.swing.*;
import java.awt.event.*;

public class action_button extends JFrame implements ActionListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new action_button();
	}
	private JButton button1;
	action_button(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400,400);
		this.setTitle("Click the button!");
		JPanel panel=new JPanel();
		button1=new JButton("Click me!");
		button1.addActionListener(this);
		panel.add(button1);
		this.add(panel);
		this.setVisible(true);
	}
	//want the button to change every time the button is clicked
	private int count=0;
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==button1){
			count++;
			if(count ==1){
				button1.setText("I've been clicked");
			}
			if(1<count & count<25){
				button1.setText("I've been clicked "+count+" times!");
			}
			if(25<= count){
				button1.setText("STAPH!");
			}
		}
		
	}
}
