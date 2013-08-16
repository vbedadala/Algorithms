package sorting;

public class SelectionSort implements Sort {

	@Override
	public int[] sort(int[] input) {
		int temp;

		for (int i = 0; i < input.length; i++) {

			int min = i;
			// Find Min
			for (int j = i; j < input.length; j++) {

				if (input[min] > input[j]) {
					min = j;
				}
			}

			temp = input[i];
			input[i] = input[min];
			input[min] = temp;
		}

		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + "   ");
		}
		return input;
	}

}
