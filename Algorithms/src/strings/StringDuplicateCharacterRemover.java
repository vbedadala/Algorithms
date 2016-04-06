package strings;

public class StringDuplicateCharacterRemover {

    public static void main(String[] args) {

        System.out.println("removed duplicate chars" + String.valueOf(removeDups(args[0])));

    }

    /*
     * start with number of unique characters as 1
     * - Keep builiding unique character list (0- tail). Only include new element in tail, if the element is not already present in 0-tail
     * If the unique character list length is less than input array length, null out the elements from tail - input.length.
     *
     */
    private static char[] removeDups(String input) {
        char[] charArray = input.toCharArray();

        //number of unique characters
        int tail = 1;
        for (int i = 1; i < charArray.length; i++) {
            int j;
            for (j = 0; j < tail; ++j) {
                if (charArray[i] == charArray[j]) {
                    break;
                }
            }

            if (j == tail) {
                charArray[j] = charArray[i];
                tail++;

            }
        }
        for (int i = tail; i < charArray.length; i++) {
            charArray[i] = 0;
        }

        return charArray;
    }
}
