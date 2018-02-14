package Stack;

public class BaseballGame {
	public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) return 0;
        LinkedList<String> stack = new LinkedList<>();
        int sum = 0;
        for(int i = 0; i < ops.length; i++) {
            if (ops[i].equals("+")) {
                String first = stack.pop();
                String second = stack.pop();
                int roundScore = Integer.valueOf(first) + Integer.valueOf(second);
                sum += roundScore;
                stack.push(second); // cound be replaced by linkedlist.get(i)
                stack.push(first);
                stack.push(""+roundScore);
            } else if (ops[i].equals("D")) {
                String first = stack.pop();
                int roundScore = Integer.valueOf(first)*2;
                sum += roundScore;
                stack.push(first);
                stack.push(""+roundScore);
            } else if (ops[i].equals("C")) {
                String first = stack.pop();
                sum -= Integer.valueOf(first);
            } else {
                sum += Integer.valueOf(ops[i]);
                stack.push(ops[i]);
            }
        }
        return sum;
    }

}
