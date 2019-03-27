package javaAIO;

public class HelloSayer {
	public HelloSayer(String greeting, String addressee) {
		this.greeting = greeting;
		this.addressee = addressee;
	}
	private String greeting;
	private String addressee;
	public void sayHello()
	{
		System.out.println(greeting+", "+addressee+"!");
	}
}
