class Solution {
    int getResult(int first, int second, String token) {
        switch (token) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
        }

        return 0;
    }
    public int evalRPN(String[] tokens) {
        List<String> operators = List.of("+", "-", "/", "*");
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (!operators.contains(token))
                stack.add(Integer.valueOf(token));
            else {
                int second = stack.pop();
                int first = stack.pop();
                int result = getResult(first, second, token);
                stack.add(result);
            }
        }

        return stack.peek();
    }
}
