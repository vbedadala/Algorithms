package ctci.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vasant on 7/9/17.
 */
public class PermutationString {

    public boolean isPermutationString(String s1, String s2) {

        Map<Character, Integer> dict = new HashMap<>();
        if(s1.length()!=s2.length()) {
            return false;
        }
        for(Character c : s1.toCharArray()) {
            dict.merge(c,1,Integer::sum);
        }

        for(Character c : s2.toCharArray()) {
            if(!dict.containsKey(c)) {
                return false;
            }
            else{
                dict.put(c, dict.get(c) - 1);
            }
        }

        return dict.values().stream().allMatch( i -> i==0);

    }
}
