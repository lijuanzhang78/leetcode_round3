package Google;

public class _406_QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0] == null || people[0].length == 0) return new int[0][0];
        Arrays.sort(people, (a,b)->(a[0]==b[0]?a[1]-b[1]:b[0]-a[0]));
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < people.length; i++) {
            res.add(people[i][1],people[i]);
        }
        int[][] resarr = new int[people.length][2];
        for(int i = 0; i < res.size(); i++) {
            resarr[i] = res.get(i);
        }
        return resarr;
    }

}
