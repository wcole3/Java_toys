//toy program implementing a pizza rdering menu in an applet
package pizza_applet;
import java.applet.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class pizza_menu extends Applet {
	public void init(){
		new pizza_menu();
	}
	//some private variables to help with the program
	private JCheckBox sizeSm; JCheckBox sizeMd; JCheckBox sizeLg;
	private JRadioButton pepp; JRadioButton saus; JRadioButton chee;
	private JButton orderButt; JButton closeButt;
	private JTextArea driveInst;
	private JTextField fName; JTextField lName; JTextField zip;
	
	public pizza_menu(){
		this.setSize(400, 400);
		//start adding components
		JPanel mainP=new JPanel();
		mainP.setLayout(new GridLayout(0,2));
		JLabel welcomeMess=new JLabel("Welcome to Pizza Inc.\n"
				+ "What kind of pizza would you like?");
		mainP.add(welcomeMess); mainP.add(Box.createHorizontalStrut(5));
				
		//start with size options
		JPanel sizeP=new JPanel();
		Border sizeBorder=BorderFactory.createTitledBorder("Size");
		sizeP.setBorder(sizeBorder);
		sizeP.setLayout(new BoxLayout(sizeP,BoxLayout.Y_AXIS));
		sizeP.add(sizeSm=new JCheckBox("Small"));
		sizeP.add(sizeMd=new JCheckBox("Medium"));
		sizeP.add(sizeLg=new JCheckBox("Large"));
		mainP.add(sizeP);
		//now do toppings
		JPanel toppP=new JPanel();
		Border toppBorder=BorderFactory.createTitledBorder("Toppings");
		toppP.setBorder(toppBorder);
		toppP.setLayout(new BoxLayout(toppP, BoxLayout.Y_AXIS));
		pepp=new JRadioButton("Pepperoni");
		saus=new JRadioButton("Sausage");
		chee=new JRadioButton("Cheese");
		ButtonGroup toppButts=new ButtonGroup();
		toppButts.add(pepp);
		toppButts.add(saus);
		toppButts.add(chee);
		toppP.add(pepp);toppP.add(saus);toppP.add(chee);
		mainP.add(toppP);
		//now the cust info
		JPanel custInfo=new JPanel();
		custInfo.setLayout(new GridLayout(0,2));
		fName=new JTextField("First Name",9);
		lName=new JTextField("Last Name",9);
		zip=new JTextField("Zip Code",9);
		custInfo.add(fName);custInfo.add(lName);
		custInfo.add(zip, 1,2);
		mainP.add(custInfo);
		//add the driver instructions
		JPanel driveP=new JPanel();
		driveInst=new JTextArea("Enter special instructions for driver",5,20);
		driveInst.setLineWrap(true);
		driveInst.setWrapStyleWord(true);
		JScrollPane driveInstScroll=new JScrollPane(driveInst,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		driveP.add(driveInstScroll);
		mainP.add(driveP);
		//finally add buttons
		JPanel buttP=new JPanel();
		orderButt=new JButton("Place Order");
		orderButt.addActionListener(e->orderPlaced());
		closeButt=new JButton("Exit");
		closeButt.addActionListener(e->System.exit(0));
		buttP.add(orderButt);
		buttP.add(Box.createHorizontalStrut(10));
		buttP.add(closeButt);
		mainP.add(buttP);
		this.add(mainP);
		this.setVisible(true);
	}

	
	//method to pop out a window when order is placed
	private void orderPlaced(){
		
	}
}
