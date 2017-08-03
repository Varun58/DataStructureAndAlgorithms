package stacks;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {}

//Solution1
/*public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int max = Integer.MIN_VALUE;
    Stack<StackNode> stack = new Stack<StackNode>();

    while (n > 0) {
        int choice = sc.nextInt();
        if(choice == 1) {
            int val = sc.nextInt();
            max = Math.max(val, max);

            stack.add(new StackNode(val, max));
        } else if(choice == 2) {
            if(!stack.isEmpty())
                stack.pop();
            // reset max
            if(stack.isEmpty())
                max = Integer.MIN_VALUE;
            else
                max = stack.peek().curMax;
        } else if(choice == 3) {
            if(!stack.isEmpty()) {
                System.out.println(stack.peek().curMax);
            }
        }

        n--;
    }
    sc.close();
}

private static class StackNode {
    int val;
    int curMax;
    public StackNode(int val, int curMax) {
        this.val = val;
        this.curMax = curMax;
    }

    public String toString() {
        return val + " [" + curMax + "]";
    }
}*/



//Solution 2 
/*
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int queries = in.nextInt();
        Stack<Integer> maxValues = new Stack<Integer>();
        
        while(queries-- > 0) {
         switch(in.nextInt()) {
          case 1 : int item = in.nextInt();
            	   if (!maxValues.isEmpty()) {
                     item = item > maxValues.peek() ? item : maxValues.peek();
                   }
        	   maxValues.push(item);
                   break;
          case 2 : maxValues.pop();
                   break;
          case 3 : System.out.println(maxValues.peek());
                   break;
	 }
        }
        
        in.close();
    }
*/

//Solution 3

/*public class Solution {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    Stack<Integer> stack = new Stack<Integer>();
	    Stack<Integer> maxStack = new Stack<Integer>();
	        
	    while (n > 0) {
	        int choice = sc.nextInt();
	        if (choice == 1) {
	            Integer val = sc.nextInt();
	            if (val >= getStackMax(maxStack))
	            	maxStack.push(val);
	            stack.push(val);
	        } else if (choice == 2) {
	             Integer value = stack.pop();
	             if (value == getStackMax(maxStack)) 
	                	maxStack.pop();
	        } else if (choice == 3) {
	            if (!maxStack.isEmpty()) {
	                System.out.println(getStackMax(maxStack));
	            }
	        }
	        n--;
	    }
	    sc.close();
    }
	
	private static Integer getStackMax(Stack<Integer> s) {
		if (s.isEmpty()) 
			return Integer.MIN_VALUE;
		return s.peek();
	}
}*/