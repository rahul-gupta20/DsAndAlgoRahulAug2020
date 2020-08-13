
//question no.2--------------------->balanced bracket question<-------------------------------------

// 1. You are given a string exp representing an expression.
// 2. You are required to check if the expression is balanced i.e. closing brackets and opening brackets match up well.

// e.g.
// [(a + b) + {(c + d) * (e / f)}] -> true
// [(a + b) + {(c + d) * (e / f)]} -> false
// [(a + b) + {(c + d) * (e / f)} -> false
// ([(a + b) + {(c + d) * (e / f)}] -> false

import java.util.*;  // [a+b]  // o(n)  // space o( n ) 
public class Question_2_balacedBrac{
    public static void main(String[] args ){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        boolean ans = balbrac( str );
        System.out.println( ans );
    }
    public static boolean balbrac( String exp ){  /// ]
       Stack <Character> st = new Stack<>();
       for(int i =0; i<exp.length(); i++){
           char ch = exp.charAt( i );    
           if( ch == '{' || ch == '(' || ch == '['){
               st.push( ch );
           }
           else{
              if( ch == '}'){// {
                  // spcl work
                  if( st.size() == 0 || st.peek()!='{'){
                      return false;
                  }
                  else {
                      st.pop();
                  }
              }                   
              else if( ch == ']'){
                  // spcl work
                  if( st.size() == 0 || st.peek()!='['){
                      return false;
                  }
                  else {
                      st.pop();
                  }
              }
              else if( ch == ')'){
                  // spcl work{}
                  if( st.size() == 0 || st.peek()!='('){
                      return false;
                  }
                  else {
                      st.pop();
                  }
              }
           }
       }

       if( st.size()>0){
           return false;
       }

     return true;
    }

}