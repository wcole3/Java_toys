package Character;

public class Dress {

	public static void main(String[] args) {
		//Generate our outside objects
		Shirt s1 = new Shirt();
		Shirt s2 = new Shirt("red");
		Shirt s3 = new Shirt("blue", 4);
		Shirt[] sArr = new Shirt[3];
		sArr[0]=s1;
		sArr[1]=s2;
		sArr[2]=s3;
		//Now check to see if they are correctly constructed
		System.out.println("The color of shirt 2 is " + s2.getColor());
		System.out.println("The size of shirt 2 is "+s2.getSize());
		System.out.println("Shirt 1 goes on your " + Shirt.getBodyLoc());
		for(int i =0; i < sArr.length; i++){
			System.out.println("The color of shirt "+i+" is " + sArr[i].getColor());
			System.out.println("The size of shirt "+i+" is " + sArr[i].getSize());
			System.out.println("Shirt "+i+" goes on your " + Shirt.getBodyLoc());
		}
	}

}
