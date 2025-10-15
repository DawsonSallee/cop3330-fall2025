import java.util.Stack;

public class SymbolChecker implements Checker {
    
    @Override
    public boolean isBalanced(String text) {

        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < text.length(); i++) {
            
            char c = text.charAt(i);

            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            else if(c == ')') {

                if(stack.size() == 0) {
                    return false;
                }

                else if(stack.peek() == '(') {
                    stack.pop();
                }

                else {
                    return false;
                }
            }
                else if(c == '}') {

                if(stack.size() == 0) {
                    return false;
                }

                if(stack.peek() == '{') {
                    stack.pop();
                }
                
                else {
                    return false;
                }
            }
                else if(c == ']') {

                if(stack.size() == 0) {
                    return false;
                }

                if(stack.peek() == '[') {
                    stack.pop();
                }

                else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}