package strings;

public class CountStringAnagramDeletionDifference {
    public static int numberNeeded(String first, String second) {
        
        if(first == null && second == null){
            return 0;
        }
        
        if(first == null && second != null){
            return second.length();
        }
        
        if(first != null && second == null){
            return first.length();
        }
        
        int[] a = new int[128];
        int[] b = new int[128];
        
        for(char ch : first.toCharArray()){a[ch]++;}
        for(char ch : second.toCharArray()){b[ch]++;}
        
        int i=0,j=0,count=0;
        while(i<a.length && j<b.length){
            if(a[i]!=b[j]){
             count += Math.abs(a[i]-b[j]);
            }
        }
        
      return count;
    }
  
    public static void main(String[] args) {
        System.out.println(numberNeeded("cde", "abc"));
    }
    
    /*#include<bits/stdc++.h>
		
		using namespace std;
		
		int main() {
		    string str1,str2;
		    getline(cin,str1);
		    getline(cin,str2);
		
		    int A[26],B[26],i;
		    for(i=0 ; i< 26 ; i++)
		        A[i] = B[i] = 0;
		    for(i = 0 ; i< str1.length() ; i++)
		        A[(int)(str1[i] - 'a')]++;
		    for(i = 0 ; i< str2.length() ; i++)
		        B[(int)(str2[i] - 'a')]++;	
		    int outp = 0;
		    for(i=0 ; i< 26 ; i++)
		    {
		        outp = outp + A[i] + B[i] - 2*min(A[i],B[i]);
		    }
		    cout<<outp<<endl;
		    return 0;
		}*/
}
