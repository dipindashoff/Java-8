package appleAndLambda;

public class AppleGreenPredicate implements ProcessApples{

	public boolean test(Apple a) {
		return "green".equals(a.getColor()); 
	}
	
	

}
