package streamsPart1;

import java.util.Arrays;
import java.util.List;

import javax.swing.plaf.synth.SynthScrollBarUI;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;

public class MapExercises {

	public static void main(String[] args) {

		/*
		 * Given a list of numbers, how would you return a list of the square of each
		 * number? For example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16,
		 * 25].
		 */

		List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);

		List<Integer> sqList = numList.stream().map(x -> x * x).collect(toList());

		sqList.forEach(System.out::println);

		/*
		 * Given two lists of numbers, how would you return all pairs of numbers? For
		 * example, given a list [1, 2, 3] and a list [3, 4] you should return [(1, 3),
		 * (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For simplicity, you can represent a
		 * pair as an array with two elements.
		 */

		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(3, 4);

		List<Integer[]> intArray = new ArrayList<>();
		for (Integer i : list1) {
			for (Integer j : list2) {
				Integer[] a = new Integer[2];
				a[0] = i;
				a[1] = j;
				intArray.add(a);
			}
		}
		// intArray.forEach(System.out::println);
		System.out.println("Pairs of numbers:");
		for (Integer[] y : intArray) {
			System.out.println(y[0] + "," + y[1]);
		}
		
		// Using FlatMap
		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);
		List<int[]> pairs =
					numbers1.stream()								// Stream<Integer>
					.flatMap(i -> numbers2.stream()
										  .map(j -> new int[]{i, j}) //  
		)
		.collect(toList());
		
		System.out.println("Pairs using flatmap:");
		for (Integer[] y : intArray) {
			System.out.println(y[0] + "," + y[1]);
		}

	}

}
