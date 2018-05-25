package Google;

public class _251_Flatten2DVector {
	Iterator<List<Integer>> outter;
    Iterator<Integer> inner;
    
    public Vector2D(List<List<Integer>> vec2d) {
        if (vec2d == null) return;
        outter = vec2d.iterator();
    }

    @Override
    public Integer next() {
        return inner.next();
        
    }

    @Override
    public boolean hasNext() {
        while (inner == null || !inner.hasNext()) {
            if (outter.hasNext()) {
                inner = outter.next().iterator();
            } else {
                return false;
            }
        }
        return inner != null && inner.hasNext();
    }       

}
