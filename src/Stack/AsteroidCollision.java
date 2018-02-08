package Stack;

public class AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) return new int[0];
        LinkedList<Integer> stack = new LinkedList<>();
        for(int num : asteroids) {
            if (stack.size() == 0 || num > 0) {
                stack.push(num);
            } else { // stack.size() > 0 && num < 0
                if (stack.size() > 0 && stack.peek() < 0) {
                    stack.push(num);
                } else {
                    int newaster = num;
                    while(newaster < 0) {
                        if (stack.size() > 0 && stack.peek() > 0) {
                            if (Math.abs(newaster) - Math.abs(stack.peek()) > 0) {
                                stack.pop();
                            } else if (Math.abs(newaster) - Math.abs(stack.peek()) == 0) {
                                stack.pop();
                                newaster = 0;
                            } else {
                                newaster = 0;
                            }
                        } else {
                            stack.push(newaster);
                            newaster = 0;
                        }
                    }    
                }
            }
        }
        int[] res = new int[stack.size()];
        for(int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

}
