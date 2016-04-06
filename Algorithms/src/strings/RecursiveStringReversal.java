package strings;

public class RecursiveStringReversal {

    private static String reverse;

    public static void main(String[] args) {

        ireverse(args[0]);
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


    private static String ireverse(String input) {
        char[] str = input.toCharArray();
        int j = input.length() - 1;
        int i = 0;
        while (i < j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }

        return new String(str);
    }
}
