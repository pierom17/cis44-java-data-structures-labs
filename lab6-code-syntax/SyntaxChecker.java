// You will need a functioning Stack implementation (like ArrayStack) for this to work.
interface Stack<E> {
    void push(E element);

    E pop();

    boolean isEmpty();
}

class ArrayStack<E> implements Stack<E> {
    private E[] data;
    private int top = -1;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public void push(E element) {
        top++;
        data[top] = element;
    }

    public E pop() {
        E answer = data[top];
        data[top] = null;
        top--;
        return answer;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class SyntaxChecker {

    /**
     * Uses a stack to check if a line of code has balanced symbols.
     * 
     * @param line The string of code to check.
     * @return true if symbols are balanced, false otherwise.
     */
    public static boolean isBalanced(String line) {
        // TODO: Implement this method using a Stack.
        Stack<Character> buffer = new ArrayStack<>(line.length());

        // Your implementation here...

        for (int i = 0; i < line.length(); i++) {

            char c = line.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                buffer.push(c);
            }

            else if (c == ')' || c == '}' || c == ']') {

                if (buffer.isEmpty()) {
                    return false;
                }

                char top = buffer.pop();

                if (c == ')' && top != '(') {
                    return false;
                }

                if (c == '}' && top != '{') {
                    return false;
                }

                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }

        return buffer.isEmpty();
    }

    public static void main(String[] args) {
        String line1 = "public static void main(String[] args) { ... }"; // Should be true
        String line2 = "int x = (5 + [a * 2]);"; // Should be true
        String line3 = "System.out.println('Hello');)"; // Should be false (extra closing parenthesis)
        String line4 = "List list = new ArrayList<{String>();"; // Should be false (mismatched)
        String line5 = "if (x > 0) {"; // Should be false (unmatched opening brace)

        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));
    }
}