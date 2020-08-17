/*

Iterator for Combination

Problem Statemnet: Design an Iterator class, which has:

A constructor that takes a string characters of sorted distinct 
lowercase English letters and a number combinationLength as arguments.

A function next() that returns the next combination of length 
combinationLength in lexicographical order.

A function hasNext() that returns True if and only if there exists a next combination.
 

Example:

CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false
 

Constraints:

1 <= combinationLength <= characters.length <= 15
There will be at most 10^4 function calls per test.
It's guaranteed that all calls of the function next are valid.

Hide Hint #1  
	Generate all combinations as a preprocessing.
Hide Hint #2  
	Use bit masking to generate all the combinations.

*/

// Java Solution

class CombinationIterator {
    private Queue<String> queue;
    
    public CombinationIterator(String characters, int combinationLength) {
        queue = new PriorityQueue<>();
        
        for (int i = 0; i < (1 << characters.length()); i++) {
            if (Integer.bitCount(i) != combinationLength) {
                continue;
            }
            
            char[] comb = new char[combinationLength];
            int index = 0;
            
            for (int j = 0; j < characters.length(); j++) {
                int bit = 1 << j;
                if ((bit & i) == bit) {
                    comb[index++] = characters.charAt(j);
                }
            }
            
            queue.add(new String(comb));
        }
    }
    
    public String next() {
        return queue.poll();
    }
    
    public boolean hasNext() {
        return queue.isEmpty() == false;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */