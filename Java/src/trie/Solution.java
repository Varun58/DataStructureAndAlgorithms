package trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	static Trie addressBook = new Trie();
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		for (int a0 = 0; a0 < n; a0++) {
			
			
			String op = in.next();
			String contact = in.next();

			
			if ("add".equals(op)) {
				addressBook.insert(contact);
			}

			if ("find".equals(op)) {
				System.out.println(addressBook.countOfWordsMatching(contact));
			}
	
		}
		
		/*
		addressBook.insert("hack");
		addressBook.insert("hackerrank");
		
		addressBook.insert("calm");
        addressBook.insert("cast");
        addressBook.insert("cash");
        addressBook.insert("casino");
        addressBook.insert("casio");
        addressBook.insert("cart");
        addressBook.insert("call");
        addressBook.insert("carb");
        addressBook.insert("cain");
        
		
		System.out.println(addressBook.countOfWordsMatching("ha"));*/
	
					
			
			
			
			/*addressBook.insert("calm");
            addressBook.insert("cast");
            addressBook.insert("cash");
            addressBook.insert("casino");
            addressBook.insert("casio");
            addressBook.insert("cart");
            addressBook.insert("call");
            addressBook.insert("carb");
            addressBook.insert("cain");
            
            System.out.println(addressBook.countOfWordsMatching("cas"));
            */
		
	}
}

class Trie{
    
    private TrieNode root;
    
    public Trie(){
        root = new TrieNode();
    }
    
    private class TrieNode{
        private boolean eoW = false;
        private Map<Character,TrieNode> children = null;
        private Character character;
        
        public TrieNode(){
            this.children = new HashMap<>();
        }
        
        public TrieNode(Character character){
        	this();
            this.character = character;
        }
        
        public Map<Character,TrieNode> getChildren(){
            return children;
        }

		@Override
		public String toString() {
			return "TrieNode [eoW=" + eoW + ", children=" + children + ", character=" + character + "]";
		}
        
    }
    
    public void insert(String word){
        TrieNode current = root;
        
        if(current == null){
            current = new TrieNode();
        }
        
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode child = current.getChildren().get(ch);
            if(child == null){
            	child  = new TrieNode(ch);
                current.getChildren().put(ch,child);
            }
            current = child;
        }
        current.eoW=true;
    }
    
    public int countOfWordsMatching(String word){
        if(root == null){
            return 0;
        }
        TrieNode current = root;
        
        //go uptill the point where characters match
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode child = current.getChildren().get(ch);
            if(child ==  null) {
            	return 0;
            }
            
            if(  child.character != ch){
                break;
            }
            current = child;
        }
        //Recursively look for eof
        Count wordCount = new Count();
        recursiveEof(current,wordCount);
        return wordCount.count;
    }
    
    private void recursiveEof(TrieNode node, Count c){
    	
        if(node == null) return ;
        
        if(node.eoW) {c.count +=1;}
        
        if(null == node.getChildren()){
            node.eoW =true;
            return ;
        }
        
        for(TrieNode child : node.getChildren().values()){
        	recursiveEof(child,c);   
        }
    }
}
class Count{
	int count;
}

