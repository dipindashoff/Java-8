package streamsPart1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FlatMap {

	public static void main(String[] args) {

		// How could you return a list of all the unique characters for a list of words?

		List<String> words1 = Arrays.asList("Hello", "World");

		// String.split -> returns an array of strings i.e. String[] for each split word
		// Cannot use List<String> list here. It throws error:
		// Type mismatch: cannot convert from List<String[]> to List<String>
		// So change it from List<String> to List<String[]>
		List<String[]> list = words1.stream().map(word -> word.split("")) // returns Stream<String[]>
				.distinct().collect(toList());

		// List<String[]> list will have [H,e,l,l,o] & [W,o,r,l,d]
		// For each String[]
		for (String[] a : list) {
			// For each string in the String[]
			for (String s : a) {
				// Print the string from inside String[]
				System.out.print(s);
			}
			System.out.println();
		}

		// ATTEMPT USING MAP AND ARRAYS.STREAM
		String[] arrayOfWords = { "Goodbye", "World" };

		// Arrays.stream()that takes an array and produces a stream
		// Each element in the stream is now a String -- Goodbye, & World
		Stream<String> streamOfwords = Arrays.stream(arrayOfWords);

		// Goodbye, World
		streamOfwords.forEach(System.out::println);
		
		// Coming back
		List<String> words2 = Arrays.asList("Hello", "World");
		List<Stream<String>> s = words2.stream() 		// Stream<String>
		.map(words -> words.split(""))					// Stream<String[]>
		.map(Arrays::stream)							// Each String[] becomes Stream<String>. Hence, 
														// Stream<Stream<String>>
		.distinct()
		.collect(toList());
		
		// words2:
		// Hello
		// words2:
		// World
		for(Stream<String> st: s) {
			System.out.println("words2:");
			st.forEach(System.out::print);
			System.out.println();
		}
		
		// USING FLATMAP
		// All the separate streams that were generated when using
		// map(Arrays::stream) get amalgamated or flattened into a single stream
		List<String> words3 = Arrays.asList("Hello", "World");
		List<String> uniqueCharacters =
				words3.stream()
				.map(w -> w.split("")) 		// Converts each word into an array of its individual letters
				.flatMap(Arrays::stream) 	// Flattens each generated stream into a single stream
				.distinct()
				.collect(Collectors.toList());
		
		uniqueCharacters.forEach(System.out::print); //HeloWrd
		
		// In a nut shell ,flatMap method lets you replace each value of a stream with
		// another stream and then concatenates all the generated streams into a single stream.
		

	}

}
