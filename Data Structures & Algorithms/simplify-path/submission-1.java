class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] str = path.split("/");
        System.out.println(Arrays.toString(str));
        for (String s : str) {
            if (s.equals("") || s.equals(" ") || s.equals(".")) continue;
            else if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else stack.push(s);
        }
        System.out.println(stack);
        return "/" + String.join("/", stack);
    }
}