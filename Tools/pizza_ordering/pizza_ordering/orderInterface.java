//toy program to imitate a pizza ordering system

package pizza_ordering;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.*;

public class orderInterface extends JFrame{

	public static void main(String[] args) {
		new orderInterface();

	}
	//want options for size, toppings, driver instructions
	//possibly price
	private JCheckBox pepp; JCheckBox cheese; JCheckBox saus;
	private JRadioButton sizeSm; JRadioButton sizeMd; JRadioButton sizeLg;
	private JTextArea driveInst;
	private JButton orderButt; JButton closeButt;
	private ButtonGroup sizeGroup;
	private JTextField fName; JTextField lName; JTextField zip;
	orderInterface(){
		this.setSize(400, 400);
		this.setTitle("What would you like to order?");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel mainPanel=new JPanel();
		JPanel infoP=new JPanel();
		JPanel custInfo=new JPanel();
		JPanel sizeP=new JPanel();
		Border sizeB=BorderFactory.createTitledBorder("Size");
		sizeP.setBorder(sizeB);
		sizeP.setLayout(new BoxLayout(sizeP,BoxLayout.Y_AXIS));
		JPanel toppP=new JPanel();
		Border toppB=BorderFactory.createTitledBorder("Toppings");
		toppP.setBorder(toppB);
		toppP.setLayout(new BoxLayout(toppP, BoxLayout.Y_AXIS));
		JPanel driveP=new JPanel();
		JPanel confirmP=new JPanel();
		//info panel is just a greeting
		JLabel message=new JLabel("Welcome to Pizza Co.!\nPlease place your order.");
		infoP.add(message);
		//topping buttons
		pepp=new JCheckBox("Pepperoni");cheese=new JCheckBox("Cheese");
		saus=new JCheckBox("Sausage");
		toppP.add(pepp);toppP.add(cheese);toppP.add(saus);
		//size buttons
		sizeSm=new JRadioButton("Small"); sizeMd=new JRadioButton("Medium");
		sizeLg=new JRadioButton("Large");
		sizeGroup=new ButtonGroup();
		sizeGroup.add(sizeSm);sizeGroup.add(sizeMd);sizeGroup.add(sizeLg);
		sizeP.add(sizeSm);sizeP.add(sizeMd);sizeP.add(sizeLg);
		//Customer Info, for govt tracking purposes
		fName=new JTextField("First Name",8);
		lName=new JTextField("Last Name",8);
		zip=new JTextField("Zip Code",8);
		GridLayout custLayout=new GridLayout(0,2);
		custInfo.setLayout(custLayout);
		custInfo.add(fName);
		custInfo.add(lName);
		custInfo.add(zip);
		//driver instructions
		driveInst=new JTextArea("Enter special instructions for driver",5,20);
		driveInst.setLineWrap(true);
		driveInst.setWrapStyleWord(true);
		JScrollPane scrollP=new JScrollPane(driveInst,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
				,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		driveP.add(scrollP);
		closeButt=new JButton("Close");
		closeButt.addActionListener(e-> System.exit(0));
		orderButt=new JButton("Place Order");
		orderButt.addActionListener(e->orderPlaced());
		confirmP.add(orderButt); 
		confirmP.add(Box.createHorizontalStrut(20));
		confirmP.add(closeButt);
		mainPanel.add(infoP);
		mainPanel.add(sizeP);mainPanel.add(toppP);
		mainPanel.add(custInfo);
		mainPanel.add(driveP);
		mainPanel.add(confirmP);
		this.add(mainPanel);
		this.setVisible(true);
	}
	//once the order is placed I want to display a info box saying what the order is
	public void orderPlaced(){
		String size=getPizzaSize();
		ArrayList<String> toppings=getToppings();
		String message="Your order is the following:\n";
		message=message+"One "+size+" pizza with:\n";
		for(String topping:toppings){
			message=message+"\t\t\t"+topping+"\n";
		}
		message=message+"Delivering to "+fName.getText()+" "+lName.getText()+" in area: "+zip.getText()+"\n";
		message=message+"Instructions for driver: \n"+"\t\t\t"+driveInst.getText();
		JOptionPane.showMessageDialog(this, message, "Here is your Order",
				JOptionPane.INFORMATION_MESSAGE);
		
		
	}
	//want a method to get selected size; just so it is not in the orderPlaced method
	public String getPizzaSize(){
		String sizeOut;
		if(sizeSm.isSelected()){sizeOut="Small";}
		else if(sizeMd.isSelected()){sizeOut="Medium";}
		else if(sizeLg.isSelected()){sizeOut="Large";}
		else{sizeOut="Imaginary (You forgot to pick a size)";}
		return sizeOut;
		
	}
	//Another method to get the toppings
	public ArrayList<String> getToppings(){
		ArrayList<String> toppings=new ArrayList<String>();
		if(pepp.isSelected()){toppings.add("Pepperoni");}
		if(saus.isSelected()){toppings.add("Sausage");}
		if(cheese.isSelected()){toppings.add("Cheese");}
		return toppings;
	}
}
