package sorting;

public class BubbleSort implements Sort {

    public int[] sort(int[] input) {
        boolean sorted = true;
        int temp;

        while (sorted) {
            sorted = false;
            for (int i = 0; i < input.length - 1; i++) {
                if (input[i] > input[i + 1]) {
                    temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;
                    sorted = true;
                }
            }

        }
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + "   ");
        }
        return input;
    }

}
