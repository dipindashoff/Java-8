package streamsPart1;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class Map {

	public static void main(String[] args) {

		/*
		 * Given a list of words, you’d like to return a list of the number of
		 * characters for each word.
		 */

		List<Integer> listNo = Arrays.asList("Java", "In", "Action")
				.stream()  				// Stream<String>
				.map(String::length) 	// Stream<Integers>
				.collect(toList());
		
		listNo.forEach(System.out::println);

	}

}
