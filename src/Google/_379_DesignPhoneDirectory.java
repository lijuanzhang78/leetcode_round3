package Google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _379_DesignPhoneDirectory {
	Queue<Integer> unused;
    Set<Integer> used;
    int maxNumbers;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public _379_DesignPhoneDirectory(int maxNumbers) {
        unused = new LinkedList<Integer>();
        for(int i = 0; i < maxNumbers; i++) {
            unused.offer(i);
        }
        used = new HashSet<>();
        this.maxNumbers = maxNumbers;
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (unused.size() > 0) {
            int res = unused.poll();
            used.add(res);
            return res;
        } else {
            return -1;
        }    
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number >= 0 && number < maxNumbers) {
            return !used.contains(number);
        } else {
            return false;
        }
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (number >= 0 && number < maxNumbers) {
            if (used.contains(number)){ //错误
                used.remove(number);
                unused.offer(number);
            }
        }
        return;
    }
    
    public static void main(String[] args) {
    	_379_DesignPhoneDirectory pd = new _379_DesignPhoneDirectory(3);
    	pd.release(2);
    	pd.get();
    	pd.release(2);
    	pd.release(0);
    	
    	
    	
    }

}
