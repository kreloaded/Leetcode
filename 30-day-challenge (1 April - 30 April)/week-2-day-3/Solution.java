/*

Title: Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

Methods pop, top and getMin operations will always be called on non-empty stacks.

hint 1: Consider each node in the stack having a minimum value. (Credits to @aakarshmadhavan)
*/

// Java Solution

class MinStack {
    Stack<int[]> stack; 
     
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<int[]>();
    }
    
    public void push(int x) {
        // if the stack is empty push the element to stack, min=element itself
		if (stack.empty()) {
			stack.push(new int[] { x, x });
			return;
		}

		// compare the top min element with the new element, if new element is
		// smaller
		// then add the new min as the current element
		int currentMin = stack.peek()[1];
		stack.push(new int[] { x, Math.min(currentMin, x) });
    }
    
    public void pop() {  
       stack.pop(); 
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
       return stack.peek()[1];
    }
    
    public boolean isEmpty() {
        return stack.empty();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */