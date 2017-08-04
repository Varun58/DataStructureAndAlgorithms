package strings;

import java.util.Scanner;

public class CheckIfAnagramStringCanBePalindrome {
	

    static String gameOfThrones(String s){
        if(s == null || s.isEmpty() || s.length()==1 ) return "YES";
        
        boolean evenLength = false;
        
        if(s.length() %2 ==0 ){
         evenLength = true;    
        }
        
        int count[] = new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        
        if(evenLength){
            for(int i=0;i<count.length;i++){
                if(count[i] %2!=0)
                return "NO";
            }
        }else{
            int oddCount=0;
            for(int i=0;i<count.length;i++){
                if(count[i] %2!=0)
                oddCount++;
                
                if(oddCount>1){
                    return "NO";
                }
            }
            
        }
        
        return "YES";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = gameOfThrones(s);
        System.out.println(result);
    }

}
