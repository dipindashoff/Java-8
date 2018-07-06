package FunctionInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionInterfaceMap {

	// Create a method map to transform a list of
	// Strings into a list of Integers containing the length of each String

	public static void main(String[] args) {

		System.out.println(map(Arrays.asList("a", "ab", "abc")));
		System.out.println(mapF(Arrays.asList("a", "ab", "abc"), s->s.length()));
		System.out.println(mapF(Arrays.asList("a", "ab", "abc"), String::length));
		
		// Get index of "a" -- Same method, mapF can be used. This is called behavior parameterization
		System.out.println(mapF(Arrays.asList("ape", "pae", "pea"), s->s.indexOf("a")));
	}

	// Before Java 8
	public static List<Integer> map(List<String> strList) {

		List<Integer> result = new ArrayList<>();
		for (String s : strList) {
			result.add(s.length());
		}
		return result;
	}
	
	// After Java 8 -- Using Function interface
	public static List<Integer> mapF (List<String> strList, Function<String, Integer> f) {

		List<Integer> result = new ArrayList<>();
		for (String s : strList) {
			result.add(f.apply(s)); // Adv: Not limited to returning the length but also can be used to transform a <T> -> <R>
		}
		return result;
	}

}
