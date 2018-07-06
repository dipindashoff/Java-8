package roughNote;
import java.util.ArrayList;
import java.util.List;

public class FindListAddReturnType {

	public static void main(String[] args) {

		addToList();
	}

	public static void addToList() {
		List<String> list = new ArrayList<>();
		// list.add method returns boolean
		System.out.println(list.add("Apple"));

	}

}
