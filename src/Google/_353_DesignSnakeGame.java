package Google;

public class _353_DesignSnakeGame {
	Queue<Integer> q;
    int score = 0;
    int head = 0;;
    int[][] food;
    Map<String,int[]> map = new HashMap<>();
    int m, n;
    int count = 0;
    Set<Integer> body = new HashSet<>();
    public SnakeGame(int width, int height, int[][] food) {
        q = new LinkedList<Integer>();
        q.offer(0);
        body.add(0);
        map.put("U",new int[]{-1,0}); map.put("D",new int[]{1,0});
        map.put("L",new int[]{0,-1}); map.put("R",new int[]{0,1});
        m = height; n = width;
        this.food = food;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if (score == -1) return -1;
        int[] dir = map.get(direction);
        int r = dir[0] + head/n;
        int c = dir[1] + head%n;
        if (r < 0 || r >= m || c < 0 || c >= n) {
            score = -1;
            return score;
        }
        q.offer(r*n+c);
        head = r*n+c;
        if (count < food.length && r == food[count][0] && c == food[count][1]) {
            count++;
            score++;
            body.add(r*n+c);
        } else {
            int tail = q.poll(); // delete the tail;
            body.remove(tail);
            if (body.contains(head)) {
                score = -1;
                return score;
            }
            body.add(r*n+c);
        }
        return score;
    }

}
