package Google;

public class _489_RobotRoomCleanser {
	class Solution {
	    Robot robot;
	    int[] start = {0,0};
	    int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}}; // north/east/south/west
	    int k = 0;
	    Set<String> visited = new HashSet<>();
	    public void cleanRoom(Robot robot) {
	        this.robot = robot;
	        cleanRoom(start); 
	    }
	    
	    void cleanRoom(int[] curr) {
	        visited.add(""+curr[0]+"_"+curr[1]);
	        robot.clean();

	        for(int i = 0; i < 4; i++) {
	            if (robot.move()) {
	                int[] d = dirs[k%4];
	                int[] newpos = new int[]{curr[0]+d[0],curr[1]+d[1]};
	                if (!visited.contains(""+newpos[0]+"_"+newpos[1])) { 
	                  cleanRoom(newpos);
	                }
	                robot.turnRight(); 
	                robot.turnRight(); 
	                robot.move(); 
	                robot.turnLeft(); 
	                robot.turnLeft(); 
	            }
	            robot.turnRight(); k++;
	        }
	    }
	}
}
