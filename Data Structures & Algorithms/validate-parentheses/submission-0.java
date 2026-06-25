class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                else if ((c == ')' && stack.peek() != '(') || (c == '}' && stack.peek() != '{') || (c == ']' && stack.peek() != '['))
                    return false;
                else stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
