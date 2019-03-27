//this is a toy program to show how to use the 'Object' and 'Class'
//superclasses.  Specifically the methods of Object
public class Obj_Class_gen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Make a student
		Student s=new Student("Will", "Cole", 2.5);
		s.u.setUniv("UC Berkeley");
		//use toString to get info
		System.out.println(s);
		Student w=(Student)s.clone();
		System.out.println(s);
		System.out.println(w);
		System.out.println(s.equals(w));
		s.setFN("Casey");
		s.u.setUniv("USC");
		System.out.println(s);
		System.out.println(w);
		System.out.println(s.equals(w));
	}

}

class Student implements Cloneable {
	private String firstname;
	private String lastname;
	private double gpa;
	public University u;
	public String getFN(){return this.firstname;}
	public String getLN(){return this.lastname;}
	public double getGPA(){return this.gpa;}
	public void setFN(String firstname){
		this.firstname=firstname;
	}
	public void setLN(String lastname){
		this.lastname=lastname;
	}
	public void setGPA(double gpa){
		this.gpa=gpa;
	}
	Student(String firstname, String lastname, double gpa){
		this.firstname=firstname;
		this.lastname=lastname;
		this.gpa=gpa;
		this.u=new University("none");
	}
	
	//Now we want definitions for the equals, clone, and toString methods
	public String toString(){
		return this.getClass().getName()+": "+
				this.getFN()+" "+this.getLN()+", "+this.u.getUniv();
	}
	//Now define the clone function
	public Object clone(){
		Student s;
		try{
			//this will get all of the basic type fields
			s= (Student)super.clone();
			//still need the University part
			s.u=(University)u.clone();
			return s;
		}
		catch(CloneNotSupportedException e){
			return null;
		}
	}
	//Now give the class a equals function
	public boolean equals(Object o){
		//need to take care of a few properties
		//If the objects are different classes they cannot be equal
		if(this.getClass()!=o.getClass()){return false;}
		//If the object is itself there are equal
		if(this==o){return true;}
		//If the object is null they are not equal
		if(this==null){return false;}
		//And finally what we actually care about
		else{
			Student t=(Student)o;
			return this.lastname.equals(t.getLN())&&this.firstname.equals(t.getFN())&&
					this.gpa==t.getGPA();
		}
		
	}
}
class University implements Cloneable{
	private String uName;
	public String getUniv(){return uName;}
	public void setUniv(String uName){
		this.uName=uName;
	}
	University(String uName){
		this.uName=uName;
	}
	public Object clone(){
		try{
			return super.clone();
		}
		catch(CloneNotSupportedException e){
			//this should never happen
			return null;
		}
	}
	public boolean equals(Object obj){
		//Take care of trivial properties
		if(this==null){return false;}
		if(this==obj){return true;}
		if(this.getClass()!=obj.getClass()){return false;}
		else{
			University u=(University) obj;
			return this.uName.equals(u.getUniv());
		}
	}
}