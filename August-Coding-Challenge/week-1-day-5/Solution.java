/*

Title: Add and Search Word - Data structure design

Problem Statement: Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string 
containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

Note:
You may assume that all words are consist of lowercase letters a-z.

- Hide Hint #1  
You should be familiar with how a Trie works.

*/

// Java Solution - Trie Data Structure

class WordDictionary {

    /** Initialize your data structure here. */
    private class TrieNode {
        private TrieNode[] child = new TrieNode[26];
        private boolean end;
    }
    
    private TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode trieNode = root;
        for(Character c : word.toCharArray()){
            int index = c - 'a';
            if(trieNode.child[index]== null){
                trieNode.child[index] = new TrieNode();
            }
            trieNode = trieNode.child[index];
        }
        trieNode.end = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), root, 0);
    }
    
    private boolean match(char[] word,TrieNode node, int index) {
        
        if(node == null) return false;
        
        if(index == word.length) return node.end;
        
        char ch = word[index];
        
        if(ch == '.') {            
            for(int i = 0; i< 26 ; i++) {
                if (node.child[i] != null && match(word, node.child[i], index+1)) {
                    return true;
                }
            }
        } else {
            return node.child[ch - 'a'] != null && match(word, node.child[ch - 'a'], index+1);
        }
        
        return false;
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */