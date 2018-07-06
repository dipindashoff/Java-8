package streamsPart1;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class StreamMethods {

	public static void main(String[] args) {

		List<Dish> menu = prepMenu();
		// Get the first 3 names of high calorie dishes
		List<String> listOfThreeHighCalorieDishNames = menu.stream().filter(d -> d.getCalories() > 300)
				.map(Dish::getName).limit(3).collect(toList());
		// [pork, beef, chicken]
		System.out.println(listOfThreeHighCalorieDishNames);

		// Use streams to filter the first two meat dishes
		List<Dish> firstTwoMeatDishes = menu.stream().filter(d -> d.getType() == Dish.Type.MEAT).limit(2)
				.collect(toList());
		// pork, beef
		firstTwoMeatDishes.forEach(System.out::println);

		// What if you wanted to find out the length of the name of each dish? -- Note:
		// 2 map methods are used
		List<Integer> listNameLength = menu.stream().map(Dish::getName).map(String::length).collect(toList());
		// 4, 4, 7, 12, 4, 12, 5, 6, 6
		listNameLength.forEach(System.out::println);

	}

	public static List<Dish> prepMenu() {

		List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));
		return menu;

	}

}
