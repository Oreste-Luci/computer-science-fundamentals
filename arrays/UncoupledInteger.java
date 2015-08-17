import java.util.*;

/*
 * Returnes the unmatched integer in an array
 */
public class UncoupledInteger {

	public static void main(String[] args) {

		int[] array = {2,7,2,8,5,1,1,7,8,5,9};

		int uncoupled = findUncoupledInteger(array);

		System.out.println(uncoupled);
	}

	public static int findUncoupledInteger(int[] array) {

		if (array == null || array.length == 0) {
			throw new RuntimeException("Array cannot be empty");
		}

		Set<Integer> visitedSet = new HashSet<Integer>();

		for (int value : array) {

			Integer key = new Integer(value);

			if (visitedSet.contains(key)) {
				visitedSet.remove(key);
			} else {
				visitedSet.add(key);
			}
		}

		if (visitedSet.size()>1) {
			throw new RuntimeException("More than one Uncoupled Integer");
		}

		if (visitedSet.size()==0) {
			throw new RuntimeException("No Uncoupled Integer");
		}

		Iterator<Integer> iter = visitedSet.iterator();

		Integer value = null;
		while (iter.hasNext()) {
			value = iter.next();
		}

		return value.intValue();
	}

}