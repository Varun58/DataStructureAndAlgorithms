package strings;

import java.util.regex.Pattern;

public class ValidEmail {
	
	 static String isValid(String email) {
	        // Complete this function
	        if(email == null || email.isEmpty() || email.length() >18) return "No";
	        
	        int startW = 0;
	        int i=0;
	        String match = "hogwarts.com";
	        
	            while(email.charAt(i)!='@' && i<email.length()){
	                if(!validASCII(email.charAt(i))){
	                return "No";
	                    }
	                startW++;
	                i++;
	            }
	            
	            if(startW>5){
	                return "No";
	            }
	        i++;
	        int j=0;
	        while(i<email.length() && j<match.length()){
	                if(email.charAt(i)!=match.charAt(j)){
	                    return "No";
	                }
	            i++;
	            j++;
	        }
	        if(email.length()-i>1){
	            return "No";
	        }
	        
	        return "Yes";
	    }
	    
	    public static boolean validASCII(char ch){
	        if(ch<128 && ch>=0 && ch!=32){
	            return true;
	        }
	        return false;
	    }
	    
	    public static boolean emailMatcher(String email) {
	    	String EMAIL_PATTERN =
	    			"[a-z]{5}+@hogwarts.com";
			return Pattern.compile(EMAIL_PATTERN).matcher(email).matches();
	    }
	    
	    public static void main(String[] args) {
	    	/*String result = isValid("harry@hogwarts.com");
	    	System.out.println(result);*/
	    	
	    	boolean res = emailMatcher("ppppp@hogwarts.com");
	    	System.out.println(res);
	    	
	    	/*boolean res1 = emailMatcher("this contains string".replaceAll(" ", "++"));
	    	System.out.println(res1);*/
		}

}
