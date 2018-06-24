
public class AppleRedPredicate implements ProcessApples{

	public boolean test(Apple a) {
		return "red".equals(a.getColor()); 
	}
	
	

}
