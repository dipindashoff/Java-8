package appleAndLambda;

public class Apple {
	
	public Apple (int weight, String color){
		this.color = color;
		this.weight = weight;
	}
	
	String color;
	int weight;
	
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public String toString() {
		
		String o = "Apple{"
				+ "color="+color+", weight="+weight+ "}";
		
		return o;
		
		
	}

}
