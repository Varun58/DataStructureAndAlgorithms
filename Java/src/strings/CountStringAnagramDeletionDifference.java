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
}
