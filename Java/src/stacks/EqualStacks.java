package stacks;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EqualStacks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int s1 = 0,s2 = 0,s3 = 0;
        
        int h1[] = new int[n1];
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
            s1+=h1[h1_i];
        }
        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
            s2+=h2[h2_i];
        }
        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
            s3+=h3[h3_i];
        }
        
        int i=0;
        int j=0;
        int k=0;
        
        while(i<n1 && j<n2 && k<n3){
            if(s1==s2 && s2==s3){
                System.out.println(s1);
                break;
            }
            if(s1>s2 || s1>s3){
            	s1=s1-h1[i];
                i++;
            }
            if(s2>s1 || s2>s3){
            	s2=s2-h2[j];
                j++;
            }
            if(s3>s2 || s3>s1){
            	s3=s3-h3[k];
                k++;
            }
        }
    }
}
