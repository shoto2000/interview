package teck.jidoka.question2Exception;

public class Check {
	public void checkEvenOdd(int n) throws EvenNumberException, OddNumberException{
		if(n%2!=0) {
			throw new OddNumberException("You entered an odd number");
		}
		else if(n%2==0) {
			throw new EvenNumberException("You entered an even number");
		}
	}
}
