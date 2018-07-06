package appleAndLambda;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterApples {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(150, "green"), new Apple(75, "red"));

		inventory.forEach(a -> System.out.println(a));

		// filter by green apples
		List<Apple> GreenApples = filterByGreenApples(inventory);
		System.out.println("Filter By Green Apples");
		System.out.println(GreenApples);

		// filter by red apples
		List<Apple> RedApples = filterByRedApples(inventory);
		System.out.println("Filter By Red Apples");
		System.out.println(RedApples);

		// filter by apples by a flag
		List<Apple> FlagApples = filterApplesByFlag(inventory, "red");
		System.out.println("Filter By Red using a Flag");
		System.out.println(FlagApples);

		// filter by light weight apples
		List<Apple> LtWtApples = filterByLtWeight(inventory);
		System.out.println("Filter By light weight apples");
		System.out.println(LtWtApples);

		// filter by green apples using Predicate
		List<Apple> GreenApplesPredicate = filterByPredicate(inventory, new AppleGreenPredicate());
		System.out.println("Filter By green apples via predicate");
		System.out.println(GreenApplesPredicate);

		// filter by red & light weight apples using Predicate
		List<Apple> RedAndLtWtApplesPredicate = filterByPredicate(inventory, new RedAndLightWtApple());
		System.out.println("Filter by Red and light wt apples via predicate");
		System.out.println(RedAndLtWtApplesPredicate);

		// filter by Heavy weight apples using anonymous class
		List<Apple> HeavyWtApplesPredicate = filterByPredicate(inventory, new ProcessApples() {
			public boolean test(Apple a) {
				return a.getWeight() >= 150;
			}
		});
		System.out.println("Filter by Heavy weight apples using anonymous class");
		System.out.println(HeavyWtApplesPredicate);

		// filter by green & light weight apples using Lambda

		/*
		 * NOTE: Lambda expressions let you provide the implementation of the abstract
		 * method of a functional interface directly inline and treat the whole
		 * expression as an instance of a functional interface
		 */
		List<Apple> GreenApplesLambda = filterByPredicate(inventory,
				(Apple a) -> a.getColor().equals("green") && a.getWeight() <= 80);
		System.out.println("Filter by green & light weight apples using Lambda");
		System.out.println(GreenApplesLambda);

	}

	public static List filterByGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();

		for (Apple a : inventory) {
			if ("green".equals(a.getColor())) {
				result.add(a);
			}
		}
		return result;
	}

	public static List filterByRedApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();

		for (Apple a : inventory) {
			if ("red".equals(a.getColor())) {
				result.add(a);
			}
		}
		return result;
	}

	public static List filterApplesByFlag(List<Apple> inventory, String flag) {
		List<Apple> result = new ArrayList<>();

		for (Apple a : inventory) {
			if (flag.equals(a.getColor())) {
				result.add(a);
			}
		}
		return result;
	}

	public static List filterByLtWeight(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
		for (Apple a : inventory) {
			if (a.getWeight() <= 80) {
				result.add(a);
			}
		}
		return result;
	}

	public static List filterByPredicate(List<Apple> inventory, ProcessApples p) {
		List<Apple> result = new ArrayList<>();
		for (Apple a : inventory) {
			if (p.test(a)) {
				result.add(a);
			}
		}
		return result;
	}

}
