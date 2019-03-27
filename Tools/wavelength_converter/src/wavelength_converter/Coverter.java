package wavelength_converter;
import java.util.Scanner;

public class Coverter {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[])
	{
		
		for(;;)
		{
			String entry;
			System.out.println("MHz or Wavenumber?");
			entry = sc.nextLine();
			if(entry.equalsIgnoreCase("mhz"))
			{
				double value;
				System.out.println("Please enter the value (MHz): ");
				value = sc.nextDouble();
				double conv = value/29979.2458;
				System.out.println("Converted value is "+ conv+ " cm^-1");
				break;
			}
			if(entry.equalsIgnoreCase("wavenumber"))
			{
				double value;
				System.out.println("Please enter the value (cm^-1): ");
				value = sc.nextDouble();
				double conv = value*29979.2458;
				System.out.println("Converted value is "+ conv +" MHz");
				break;
			}
			else
			{
				System.out.println("Please enter a valid unit\n");
				continue;
					
			}
		}
	}
	
}
