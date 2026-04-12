
class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<String> dummy = new Stack<>();
        for (char c : s.toCharArray()) {

            if (c == ']') {

                StringBuilder sb = new StringBuilder();

                while (!stack.peek().equals("[")) {
                    dummy.push(stack.pop());
                }
                stack.pop(); // remove '['
                while (!dummy.isEmpty()) {
                    sb.append(dummy.pop());
                }

                // build full number
                StringBuilder num = new StringBuilder();

                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) { 
                    dummy.push(stack.pop());
                }
                while (!dummy.isEmpty()) {
                    num.append(dummy.pop());
                }
                int digit = Integer.parseInt(num.toString());
                StringBuilder result = new StringBuilder();

                for (int i = 0; i < digit; i++) {
                    result.append(sb);
                }

                stack.push(result.toString());

            } else {
                stack.push(c + "");
            }
        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}