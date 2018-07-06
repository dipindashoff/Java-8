package appleAndLambda;

public class RedAndLightWtApple implements ProcessApples {

	public boolean test(Apple a) {
		return "red".equals(a.getColor()) && a.getWeight() <=80;
	}
	
}
