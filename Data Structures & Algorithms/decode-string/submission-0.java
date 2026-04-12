
class Solution {
    public String decodeString(String s) {

        Stack<String> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == ']') {

                StringBuilder sb = new StringBuilder();

                while (!stack.peek().equals("[")) {
                    sb.insert(0, stack.pop());
                }
                stack.pop(); // remove '['


                // build full number
                StringBuilder num = new StringBuilder();

                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    num.insert(0, stack.pop());
                }
                int digit = Integer.parseInt(num.toString());
                String str = sb.toString();
                StringBuilder result = new StringBuilder();

                for (int i = 0; i < digit; i++) {
                    result.append(str);
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