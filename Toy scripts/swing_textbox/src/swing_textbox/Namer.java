package swing_textbox;
import javax.swing.*;
import java.awt.event.*;


public class Namer extends JFrame {
	private JButton okButt; JButton exitButt;
	private JTextField textBox;
	private Boolean nameEntered=false;
	public static void main(String[] args){
		new Namer();
	}
	Namer(){
		this.setSize(400,400);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setTitle("Please introduce yourself");
		JPanel panel1=new JPanel();
		//create an area to enter a name
		textBox=new JTextField(20);
		JLabel textLabel=new JLabel("Please enter your name:");
		panel1.add(textLabel);
		panel1.add(textBox);
		okButt=new JButton("Okay");
		okButt.addActionListener(e->okClick());
		panel1.add(okButt);
		exitButt=new JButton("Exit");
		exitButt.addActionListener(e->exitClick());
		panel1.add(exitButt);
		//add a window adapter to catch window closing
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				exitButt.doClick();
			}
		});
		this.add(panel1);
		this.setVisible(true);
		
	}
	
	public void okClick(){
		String name=textBox.getText();
		if(name.equals("")){
			exitButt.doClick();
		}
		else{
			nameEntered=true;
			JOptionPane.showMessageDialog(this, "Thank you, "+name);
		}
	}
	public void exitClick(){
		if(nameEntered){
			System.exit(0);
		}
		else{
			JOptionPane.showMessageDialog(this, "Please enter your name");
		}
	}
}
