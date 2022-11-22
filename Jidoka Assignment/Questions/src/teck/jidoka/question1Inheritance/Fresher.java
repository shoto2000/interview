package teck.jidoka.question1Inheritance;

public class Fresher extends Engineer{
	Boolean currentlyTraining;

	public Fresher(int id, String name, int age, String education, Boolean currentlyTraining) {
		super(id, name, age, education);
		this.currentlyTraining = currentlyTraining;
	}
	
	@Override
	public void printDetails() {
		System.out.println("Fresher Details");
		System.out.println("id: "+id+" name: "+name+" age: "+age+" education: "+education+" Training: "+currentlyTraining);
	}
}
