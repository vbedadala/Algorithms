package strings;

public class RecursiveStringReversal {

	private static String reverse;

	public static void main(String[] args) {

		reverse(args[0]);
		System.out.println("Reversed String" + String.valueOf(reverse));
	}

	/*
	 * Reverse a string in reverse order reverse("abcd") -- reverse("bcd") + a
	 * -- reverse("cd") + b + a -- reverse("d") + c + b + a
	 * 
	 * Recursion Stack flow return
	 * 
	 * input = d reverse =d input =cd reverse = dc input =bcd reverse = dcb
	 * input = abcd reverse =dcba
	 */
	private static String reverse(String input) {

		if (input.length() == 1) {
			return input;
		}

		reverse = reverse(input.substring(1)) + input.charAt(0);
		return reverse;
	}

}
