class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') openStack.add(i);
            else if (c == '*') starStack.add(i);
            else {
                if (openStack.isEmpty() && starStack.isEmpty()) return false;
                if (!openStack.isEmpty()) openStack.pop();
                else starStack.pop();
            }
        }

        while (!openStack.isEmpty() && !starStack.isEmpty()) {
            if (openStack.pop() > starStack.pop()) return false;
        }

        return openStack.isEmpty();
    }
}
