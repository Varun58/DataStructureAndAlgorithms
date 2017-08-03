package trees;

import java.util.LinkedList;
import java.util.Queue;

public class FamilyTree {
	
	public static int returnHeight(String input) {
		Queue<Character> q1  = new LinkedList<>();
		Queue<Character> q2  = new LinkedList<>();
		
		boolean changeQ = false;
		boolean isRoot = true;
		int level = 0;
		int i=0;
		
		q1.add(input.charAt(0));
		
		while(!q1.isEmpty() || !q2.isEmpty()  ) {
			
			
		
			//int childCount1=q1.size();
			while(!q1.isEmpty() && !changeQ) {
				char node = q1.poll();
				int value = Integer.parseInt(String.valueOf(node));
				
				if(value ==0 ) {
					//childCount1--;
					continue;
				}
				else if(i+2<input.length()) {
					q2.add(input.charAt(i+1));
					q2.add(input.charAt(i+2));
					i+=2;
				}
			}
			
			//if(childCount1!=0)
			if(!isRoot)
			level++;
			changeQ=true;
			
			if(isRoot) {isRoot=false;}
			
			//int childCount2=q2.size();
			
			while(!q2.isEmpty() && changeQ) {
				
				char node = q2.poll();
				int value = Integer.parseInt(String.valueOf(node));
				
				if(value ==0 ) {
					//childCount2--;
					continue;
				}
				else if(i+2<input.length()) {
					q1.add(input.charAt(i+1));
					q1.add(input.charAt(i+2));
					i+=2;
				}
			}
			//if(childCount2!=0)
			level++;
			changeQ=false;
		}
		return level;
	}

	public static void main(String[] args) {
		System.out.println(returnHeight("101110011"));
		System.out.println(returnHeight("111111111"));
		System.out.println(returnHeight("11111111"));
		System.out.println(returnHeight("1001"));
		System.out.println(returnHeight("111"));
	}
}

