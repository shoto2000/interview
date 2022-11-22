package teck.jidoka.question1Inheritance;

public class Main {
	public static void main(String[] args) {
		Employee emp = new Employee(1, "Naruto", 24);
		emp.printDetails();
		
		Employee eng1 = new Engineer(3, "Sherlock", 36, "B.tech");
		eng1.printDetails();
		
		Engineer eng2 = new Engineer(5, "Holmes", 31, "BCA");
		eng2.printDetails();
		
		Employee fre1 = new Fresher(21, "Tayyab", 22, "B.Sc", false);
		fre1.printDetails();
		
		Engineer fre2 = new Fresher(45, "Rahul", 23, "BCA", true);
		fre2.printDetails();
		
		Fresher fre3 = new Fresher(34, "Rimpi", 23, "B.Sc", false);
		fre3.printDetails();
	}
}
