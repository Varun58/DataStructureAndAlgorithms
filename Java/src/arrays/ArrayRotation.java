package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArrayRotation {

	public static int[] rotateArrayToRightInKShifts(int[] arr,int k) {
		
		/*int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        int b[] = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        
        int j=n-1;
        for(int i=0;i<n;i++){
            
            while(k>0){
                stack.push(a[j]);
                j--;
                k--;
            }
            
            while(!stack.isEmpty()){
               b[i] = stack.pop();
               i++;
            }
            
            while(j>=0){
                stack.push(a[j]);
                j--;
            }
            
            while(!stack.isEmpty()){
               b[i] = stack.pop();
               i++;
            }
        }
        
        for(int b_i=0; b_i < n; b_i++){
            System.out.print(b[b_i]+" ");
        }*/
		
		return null;
	}
	
	public static int[] rotateArrayToLeftInKShifts(int[] a,int k) {
		
		int n = a.length;
        int b[] = new int[n];
        
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        int j=0;
        for(int i=0;i<n;i++){
            
            while(k>0){
            	list1.add(a[j]);
                j++;
                k--;
            }
            
            while(j<n){
            	list2.add(a[j]);
                j++;
            }
            
            int li2=0;
            while(li2<list2.size()){
               b[i] = list2.get(li2);
               i++;
               li2++;
            }
            
            int li =0;
            while(li<list1.size()){
               b[i] = list1.get(li);
               i++;
               li++;
            }
        }
        
        for(int b_i=0; b_i < n; b_i++){
            System.out.print(b[b_i]+" ");
        }
		
		return null;
	}
	
	public static void main(String[] args) {
		rotateArrayToLeftInKShifts(new int[]{41 ,73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1 ,86, 58, 26, 10, 86, 51}, 10);
	
		/*Input:
		20 10
		41 73 89 7 10 1 59 58 84 77 77 97 58 1 86 58 26 10 86 51
		
		Output:
			77 97 58 1 86 58 26 10 86 51 41 73 89 7 10 1 59 58 84 77*/
	}
}
