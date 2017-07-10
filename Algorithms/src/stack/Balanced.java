package stack;

/**
 * Created by vasant on 6/3/16.
 */
public class Balanced {

    private Stack<Character> stack = new Stack<>(100);


    public void check(String x) {
        boolean balanced=true;

        char[] input = x.toCharArray();
        for(char i : input) {
            if(i==')' || i ==']')
            stack.push(i);
            if(i=='(') {
                if(stack.pop()!=')') {
                    balanced=false;
                }
            }
            if(i=='[') {
                if(stack.pop()!=']') {
                    balanced=false;
                }
            }
        }

        if(balanced) {
            System.out.print("Balanced");
        }
        else  if(balanced) {
            System.out.print("UnBalanced");
        }


    }
}

