package String;

public class JudgeRouteCircle {
	public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) return true;
        Map<Character,int[]> map = new HashMap<>();
        map.put('U',new int[]{0,1});
        map.put('L',new int[]{-1,0});
        map.put('R',new int[]{1,0});
        map.put('D',new int[]{0,-1});
        int[] pos = new int[]{0,0};
        for(int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            int[] move = map.get(c);
            for(int j = 0; j < 2; j++) {
                pos[j] += move[j];
            }    
        }
        if (pos[0] == 0 && pos[1] == 0) return true;
        return false;
    }

}
