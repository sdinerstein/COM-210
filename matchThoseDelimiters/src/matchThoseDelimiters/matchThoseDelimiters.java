import java.util.Scanner;
import java.util.Stack;

public static void main(String[] args) {
    // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    // determine if the input string is valid.

    // An input string is valid if:
    // 1. Open brackets must be closed by the same type of brackets.
    // 2. Open brackets must be closed in the correct order.
    // 3. Every close bracket has a corresponding open bracket of the same type.

    Scanner sc = new Scanner(System.in);
    System.out.println("Hello! To find out if your input string is balanced, please type in parameters such as '()', '[]', or '{}', in a singular or paired format, with any combination of them:");

    while (true) {
        String iParams = sc.nextLine();
        if (isValid(iParams)) {
            System.out.println("This is a balanced equation.");
        } else {
            System.out.println("This is an unbalanced equation.");
        }

        System.out.println("Would you like to enter more parameters? (Yes/No, is not case-sensitive!)");
        String yesOrNo = sc.nextLine();
        if (yesOrNo.equalsIgnoreCase("yes")) {
            System.out.println("Please enter your new parameters:");
        }
        else {
            System.out.println("Goodbye!");
            sc.close();
            return;
        }
    }
}

private static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } else {
            if (stack.isEmpty()) {
                return false; // no opening bracket for closing
            }
            char top = stack.pop();
            if (!isMatchingPair(top, c)) {
                return false; // mismatched brackets
            }
        }
    }
    return stack.isEmpty(); // should be empty if all brackets are matched
}

private static boolean isMatchingPair(char open, char close) {
    return (open == '(' && close == ')') ||
            (open == '{' && close == '}') ||
            (open == '[' && close == ']');
}


