


/**
 * Created by vasant on 8/30/16.
 */
public class MissingCharacters {

    public String listMissingLetters(String s) {


            int[] alphabet =new int[256];

            int i=0;
            while(i < s.length()) {
                alphabet[Character.toLowerCase(s.charAt(i))]=1;
                i++;
            }

            i='a';
            StringBuilder result= new StringBuilder();
            while(i<='z') {
                if(alphabet[i]!=1) {
                    result.append(alphabet[i]);
                }
                i++;
            }

        return result.toString();
    }
}
