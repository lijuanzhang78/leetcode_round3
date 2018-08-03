package Google;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class _857_MinimumCostToHireKWorkers {
	class Worker {
        int id;
        int quality;
        int wage;
        double ratio;
        Worker(int id, int quality, int wage) {
            this.id = id; this.quality = quality; this.wage = wage;
            this.ratio = (double)wage/(double)quality;
        }
    }
    
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        if (quality == null || quality.length == 0 || wage == null || wage.length == 0) return 0.0;
        int N = quality.length;
        Worker[] workers = new Worker[N];
        for(int i = 0; i < quality.length; i++) {
            workers[i] = new Worker(i,quality[i],wage[i]);    
        }
        Arrays.sort(workers, (a,b)->(a.ratio - b.ratio));
        double min = 0.0;
        // select the smallest ratio
        double ratio = workers[0].ratio;
        for(int i = 0; i < N; i++) {
            Queue<Double> q = new PriorityQueue<>((a,b)->(b-a)); // max heap
            q.offer((double)workers[i].wage/ratio);
            min += (double)workers[i].wage/ratio;
            if (q.size() > K) {
                double largest = q.poll();
                min -= largest;
            }
        }
        return min*ratio;
        
    }

}
