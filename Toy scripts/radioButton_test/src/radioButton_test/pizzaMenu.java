package radioButton_test;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

//toy prgram to simulate a shitty pizza ordering interface

public class pizzaMenu extends JFrame {

	public static void main(String[] args) {
		new pizzaMenu();

	}
	//button for size and toppings
	private JRadioButton sizeLg, sizeMd, sizeSm;
	private JCheckBox cheese, sausage, pineapple;
	
	pizzaMenu(){
		this.setSize(400,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Welcome to Cole's Pizza");
		JPanel face=new JPanel();
		JPanel panel1=new JPanel();
		JPanel panel2=new JPanel();
		Border sizeBor=BorderFactory.createTitledBorder("Size");
		Border toppBor=BorderFactory.createTitledBorder("Toppings");
		panel1.setBorder(sizeBor);
		panel2.setBorder(toppBor);
		ButtonGroup sizeButtons=new ButtonGroup();
		//radio buttons must be created and added to button group
		JLabel sizeLab=new JLabel("Please select your size:");
		panel1.add(sizeLab);
		sizeLg=new JRadioButton("Large"); sizeMd=new JRadioButton("Medium");sizeSm=new JRadioButton("Small");
		sizeButtons.add(sizeLg);sizeButtons.add(sizeMd);sizeButtons.add(sizeSm);
		panel1.add(sizeLg);panel1.add(sizeMd);panel1.add(sizeSm);
		//now set up the normal check boxes
		JLabel toppingLab=new JLabel("Please select your toppings:");
		panel2.add(toppingLab);
		cheese=new JCheckBox("Cheese"); sausage=new JCheckBox("Sausage"); pineapple=new JCheckBox("Pineapple");
		panel2.add(cheese);panel2.add(sausage);panel2.add(pineapple);
		face.add(panel1);
		face.add(panel2);
		this.add(face);
		this.setVisible(true);
	}
}
