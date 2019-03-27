package swing_window_test;
import javax.swing.*;
import java.awt.*;
public class Hello_window extends JFrame{

	public static void main(String[] args) {
		//Since the main method is static all the calls have to happen here
		new Hello_window();
		

	}
	public Hello_window(){
		this.setTitle("Hello World!");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel=new JPanel();
		JButton butt= new JButton();
		JLabel label=new JLabel("Button 1");
		butt.add(label);
		butt.setBounds(0, 0, 1, 1);
		panel.add(butt);
		panel.add(new button());
		this.add(panel);
		this.setVisible(true);
	}
	
	public class button extends JButton{
		button(){
			
			
			JLabel label=new JLabel("Hello_World");
			this.add(label);
			this.setBounds(20, 20, 20, 20);
			
		}
	}
}
