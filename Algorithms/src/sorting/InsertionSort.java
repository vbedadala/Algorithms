package sorting;

public class InsertionSort implements Sort {

    @Override
    public int[] sort(int[] input) {
        int i, j, temp;
        for (i = 1; i < input.length; i++) {
            j = i;
            temp = input[i];
            while (j > 0 && (temp < input[j - 1])) {
                input[j] = input[j - 1];
                j--;
            }
            input[j] = temp;
        }

        for (i = 0; i < input.length; i++) {
            System.out.print(input[i] + "   ");
        }
        return input;
    }

}
