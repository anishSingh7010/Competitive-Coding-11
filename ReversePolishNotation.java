// TC: O(n)
// SC: O(n)

// Approach: Whenever you encounter an operator; process
// the last two numbers. Order matters in / and - so second
// popped num will be first.

import java.util.Stack;

class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();

        for (String s : tokens) {
            // operators
            if (isOperator(s)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(eval(num1, num2, s));
            } else {
                // it's an integer
                int num = Integer.parseInt(s);
                stack.push(num);
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        }
        return false;
    }

    private int eval(int num1, int num2, String op) {
        int res;

        if (op.equals("+")) {
            res = num1 + num2;
        } else if (op.equals("-")) {
            res = num1 - num2;
        } else if (op.equals("/")) {
            res = num1 / num2;
        } else {
            res = num1 * num2;
        }

        return res;
    }
}