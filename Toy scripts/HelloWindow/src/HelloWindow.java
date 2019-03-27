import javax.swing.*;

public class HelloWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame j= new JFrame("Look a window!");
		JLabel label=new JLabel("Hello World!");
		j.getContentPane().add(label, null);
		j.pack();
		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
