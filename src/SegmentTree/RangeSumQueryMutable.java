package SegmentTree;

// 给定一个array，把array划分成各个区间，然后把区间的结果（和，最大最小值）存成节点
// buildSegmentTree:(1) 把区间一分为二，直到最后只剩一个节点
//                  (2) 返回节点的值
// 注意：父节点i，左子节点2*i+1，右子节点2*i+2
//
// getSum:(1) 问题区间完全大于当前区间：返回与当前区间对应的节点的值
//        (2) 问题区间跟当前区间不相交：返回0
//        (3) 问题区间小于当前区间或者与当前区间相交，进一步递归
//
// update: (1) 求出diff, nums[i] = val
//         (2) 如果i属于当前区间，节点值加diff，进一步递归直到叶子节点；
//             如果不属于当前区间，返回；
//
public class RangeSumQueryMutable {
	int[] st;
    int[] nums;
    
    public NumArray(int[] nums) {
        if(nums.length == 0) return;
        this.nums = nums;
        st = new int[3*nums.length]; 
        buildSegmentTree(0,nums.length-1,0);
    }

    // build segment tree for array[start,end] and put the segment tree to be rooted at pos
    int buildSegmentTree(int start, int end, int pos) {
        if (start == end) {
            st[pos] = nums[start];
            return st[pos];
        }
        
        int mid = start + (end - start)/2;
        
        // divide arr into two halves and recursively deal with them
        // left part rooted at 2*pos+1
        // right part rooted at 2*pos+2
        //
        st[pos] = buildSegmentTree(start,mid,2*pos+1) + 
                  buildSegmentTree(mid+1,end,2*pos+2); 
        return st[pos];
    }
    
    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        updateHelper(i,diff,0,nums.length-1,0);
    }
    
    void updateHelper(int index, int diff, int sstart, int send, int pos) {
        if (index < sstart || index > send) return;
        if (index >= sstart && index <= send) {
            st[pos] += diff;
            
            if (sstart < send) {
                int mid = sstart + (send - sstart)/2;
                updateHelper(index,diff,sstart,mid,2*pos+1);
                updateHelper(index,diff,mid+1,send,2*pos+2);
            }
        }    
    }
    
    public int sumRange(int i, int j) {
        return sumRangeHelper(i,j,0,nums.length-1,0);
    }
    
    // qstart, qend --> to be queryed
    // sstart, send --> current segment tree 
    int sumRangeHelper(int qstart, int qend, int sstart, int send,int pos) {
        if (qstart <= sstart && qend >= send) {
            return st[pos];
        }
        
        if (send < qstart || qend < sstart) return 0;
        
        int mid = sstart + (send-sstart)/2;
        return sumRangeHelper(qstart,qend,sstart,mid,2*pos+1) +
               sumRangeHelper(qstart,qend,mid+1,send,2*pos+2);
    }

}
