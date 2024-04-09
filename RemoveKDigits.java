// TC: O(n)
// SC: O(n)

// Approach: Keep track of removed elements and as the stack
// is increasing keep adding to it. If it decreases, eliminate
// all the bigger elements.

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int tempK = k;

        for (int i = 0; i < num.length(); i++) {
            char current = num.charAt(i);

            if (stack.isEmpty()) {
                stack.push(current);
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > current && tempK > 0) {
                stack.pop();
                tempK--;
            }

            stack.push(current);
        }

        int finalStringSize = num.length() - k;

        while (!stack.isEmpty() && stack.size() > finalStringSize) {
            stack.pop();
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        // trailing zeroes
        while (res.length() > 0 && res.charAt(res.length() - 1) == '0') {
            res.deleteCharAt(res.length() - 1);
        }

        return res.length() == 0 ? "0" : res.reverse().toString();
    }
}
