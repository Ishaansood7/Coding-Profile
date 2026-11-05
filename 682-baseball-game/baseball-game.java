class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < operations.length; i++) {

            if (operations[i].equals("C")) {
                stack.pop();
            }
            else if (operations[i].equals("D")) {
                int last = stack.peek();
                stack.push(last * 2);
            }
            else if (operations[i].equals("+")) {
                int last = stack.pop();
                int secondLast = stack.peek();

                stack.push(last);
                stack.push(last + secondLast);
            }
            else {
                stack.push(Integer.parseInt(operations[i]));
            }
        }

        int sum = 0;

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}