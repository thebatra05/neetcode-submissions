class Solution {
    private int calculate(String op1, String op2, String operator) {
        switch (operator) {
            case "+":   
                return Integer.parseInt(op1) + Integer.parseInt(op2);
            case "-":
                return Integer.parseInt(op1) - Integer.parseInt(op2);
            case "*":
                return Integer.parseInt(op1) * Integer.parseInt(op2);
            case "/":
                return Integer.parseInt(op1) / Integer.parseInt(op2);
            default:
                return 0;
        }
    }
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        List<String> operators = List.of("+", "-", "*", "/");
        int ans = 0;

        for (String token : tokens) {
            if (stack.isEmpty() || !operators.contains(token)) stack.push(token);
            else {
                String op2 = stack.pop();
                String op1 = stack.pop();
                stack.push(String.valueOf(calculate(op1, op2, token)));
            }
        }

        return Integer.parseInt(stack.peek());
    }

    /*
        ["1","2","+","3","*","4","-"]

        2
        1
    */
}
