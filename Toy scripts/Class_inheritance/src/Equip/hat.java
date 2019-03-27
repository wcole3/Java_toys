package Equip;
//This will be a general interface to demonstrate lambda expressions
//Can only have one abstract method, everything else must have an implementation
public interface hat {
	void getHealth();
	default void test(){System.out.println("This is a test");}
}
