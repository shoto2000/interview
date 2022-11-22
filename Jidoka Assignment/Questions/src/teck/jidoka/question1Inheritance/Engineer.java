package teck.jidoka.question1Inheritance;

public class Engineer extends Employee{
	String education;

	public Engineer(int id, String name, int age, String education) {
		super(id, name, age);
		this.education = education;
	}
	
	@Override
	public void printDetails() {
		System.out.println("Engineer Details");
		System.out.println("id: "+id+" name: "+name+" age: "+age+" education: "+education);
	}
	
}
