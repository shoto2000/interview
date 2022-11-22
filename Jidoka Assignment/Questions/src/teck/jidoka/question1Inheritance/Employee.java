package teck.jidoka.question1Inheritance;

public class Employee {
	int id;
	String name;
	int age;
	
	public Employee(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public void printDetails() {
		System.out.println("Employee Details");
		System.out.println("id: "+id+" name: "+name+" age: "+age);
	}
}
