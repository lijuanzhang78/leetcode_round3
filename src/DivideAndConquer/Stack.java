package DivideAndConquer;

public class Stack {
	public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return new int[0];
        LinkedList<int[]> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            if (stack.size() == 0) {
                stack.push(new int[]{temperatures[i],i});
            } else {
                while(stack.size() > 0) {
                    int[] curr = stack.peek();
                    if (curr[0] < temperatures[i]) {
                        res[curr[1]] = i - curr[1];
                        stack.pop();
                    } else {
                        break;
                    }
                }
                stack.push(new int[]{temperatures[i],i});
            }
        }
        return res;
    }

}
