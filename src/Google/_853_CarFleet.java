package Google;

public class _853_CarFleet {
	public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer,Double> map = new TreeMap<Integer,Double>();
        for(int i = 0; i < position.length; i++) {
            map.put(target-position[i], (target-position[i])*1.0/speed[i]*1.0);
        }
        int count = 0;
        double currSlowest = 0.0;
        for(Map.Entry<Integer,Double> entry : map.entrySet()) {
            if (entry.getValue() <= currSlowest) {
                entry.setValue(currSlowest);
            } else {
                count++;
                currSlowest = entry.getValue();
            }
        }
        return count;
        
    }

}
