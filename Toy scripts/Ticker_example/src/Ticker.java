import java.awt.event.*;
import javax.swing.*;
//want to create a ticker program that output a clock "tick, tock" message
public class Ticker {

	public static void main(String[] args) {
		//need a timer that will trigger every 1000ms
		Timer t= new Timer(1000, new Tickact());
		//start the counter
		t.start();
		//open a window to keep the program open for a while
		JOptionPane.showMessageDialog(null, "Click OK to exit program");
		//end the program after closing window
		t.stop();

	}
	//This is a static inner class example
	//This class must be static since the calling Main() function is static
	static class Tickact implements ActionListener {
		private boolean tick = true;
		//this implementation tells what to do after triggered
		public void actionPerformed(ActionEvent e){
			if(tick){
				System.out.println("Tick");
				
			}
			else{
				System.out.println("Tock");
				
			}
			tick=!tick;
		}
	}
}


