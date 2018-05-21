package Stack;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
	int theInt;
	boolean isInt;
	List<NestedInteger> theList;
	
	// Constructor initializes an empty nested list.
	public NestedInteger() {
		isInt = false;
		theList = new ArrayList<NestedInteger>();
	}
	
	// Constructor initializes a single integer.
	public NestedInteger(int value) {
		isInt = true;
		theInt = value;
	}
	
	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger() {
		return isInt;
	}
	
	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger() {
		if (isInt) {
			return theInt;
		} else {
			return null;
		}
	}
	
	// Set this NestedInteger to hold a single integer.
	public void setInteger(int value) {
		isInt = true;
		theInt = value;
		theList = null;
	}
	
	// Set this NestedInteger to hold a nested list and adds a nested integer to it.
	public void add(NestedInteger ni) {
		isInt = false;
		theList.add(ni);	
	}
	
	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList() {
		if(isInt) {
			return null;
		} else {
			return theList;
		}	
	}
}
