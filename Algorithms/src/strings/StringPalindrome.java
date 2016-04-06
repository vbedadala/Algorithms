package strings;

public class StringPalindrome {

    public static void main(String args[]) {

        char[] inputArray = args[0].toCharArray();

        int mid = inputArray.length / 2;

        boolean isPalindrome = true;

        for (int i = 0; i < mid; i++) {
            for (int j = inputArray.length - 1; j > mid; j++) {
                if (inputArray[i] != inputArray[j]) {

                    // Not palindrome
                    isPalindrome = false;
                }

            }
        }

        if (isPalindrome) {
            System.out.println("String is palindrome");
        } else {
            System.out.println("String is not palindrome");
        }
    }

}
