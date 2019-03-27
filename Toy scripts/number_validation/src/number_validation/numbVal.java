//toy program to accept a number from a text field and checks if it is an int
package number_validation;
import javax.swing.*;
import java.awt.event.*;

public class numbVal extends JFrame {

	public static void main(String[] args) {
		new numbVal();

	}
	private JButton okButt; JButton exitButt;
	private boolean validNumb=false;
	private JTextField numbField;
	numbVal(){
		this.setSize(400, 400);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setTitle("Welcome to the number game");
		//add window listener to add exit function
		//use anonymous inner class
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				exitButt.doClick();
			}
		});
		JPanel panel1=new JPanel();
		JLabel textLab=new JLabel("Please enter an integer:");
		numbField=new JTextField(10);
		panel1.add(textLab);
		panel1.add(numbField);
		okButt=new JButton("Okay");
		okButt.addActionListener(e->okClick());
		panel1.add(okButt);
		exitButt=new JButton("EXIT");
		exitButt.addActionListener(e->exitClick());
		panel1.add(exitButt);
		this.add(panel1);
		this.setVisible(true);
	}
	//create a class just for validation
	public static class intValid{
		public int numb;
		public boolean valid=false;
	}
	//Just for fun we will make a class that contains the validation method
	//DOing this to not bloat the okClcik method
	public static class Validation{
		//make it noninstantiable 
		private Validation(){}
		//the method used to validate an entry
		public static intValid isInt(JTextField t, String mes){
			intValid result=new intValid();
			if(!t.getText().equals("")){
				try{
					result.numb=Integer.parseInt(t.getText());
				}
				catch(NumberFormatException e){
					result.valid=false;
					JOptionPane.showMessageDialog(t, mes);
				}
				result.valid=true;
				return result;
			}
			else{
				JOptionPane.showMessageDialog(t, "Please enter an integer");
				result.valid=false;
				return result;
			}
			
		}
	}
	public void okClick(){
		//Want to parse to see if the entry is valid
		
		intValid result=new intValid();
		result=Validation.isInt(numbField, "Not a valid integer");
		if(result.valid){
			JOptionPane.showMessageDialog(this, "You have entered "+result.numb);
			validNumb=true;
		}
		numbField.requestFocus();
	}
	public void exitClick(){
		if(validNumb){
			System.exit(0);
		}
		else{
			JOptionPane.showMessageDialog(this, "Please enter a number before closing");
		}
		numbField.requestFocusInWindow();
	}
}
