import java.util.Stack;

public class SymbolChecker implements Checker {

    @Override
    public boolean isBalanced(String input) {
        // Use a Stack of Character for efficiency and correctness.
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // Logic for opening symbols
            if (c == '(' || c == '[' || c == '{') {
                // Java automatically converts the primitive 'char' to a 'Character' object.
                stack.push(c);
            }
            // Logic for closing symbols
            else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }

        // At the end, if the stack is empty, the string is balanced.
        return stack.isEmpty();
    }
}