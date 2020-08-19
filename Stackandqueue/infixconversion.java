
//------------------------Infix converson-----------------//
// 1. You are given an infix expression.
// 2. You are required to convert it to postfix and print it.
// 3. You are required to convert it to prefix and print it.
//  given infix - expression -> a*(b-c+d)/e


//  input format below
//  a*(b-c+d)/e

//  output format below
// abc-d+*e/ 
//   /*a+-bcde

//  write your code below 


import java.io.*;
import java.util.*;

public class infixconversion
{
  

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String exp = br.readLine();
            conbvertAndDisplay( exp );

            // code
        }
        public static void conbvertAndDisplay( String exp ){
            Stack <Character> optr = new Stack<>();
            Stack <String> prefix = new Stack<>();
            Stack <String> postfix = new Stack<>();
            for( int i=0; i<exp.length(); i++){
                char ch = exp.charAt( i );
                if( (ch >='0' && ch<='9') || ( ch>='a' && ch<='z') || ( ch>='A' && ch<='Z') ){
                    prefix.push( ch + "");
                    postfix.push( ch + "");
                }else if( ch =='('){
                    optr.push( ch );
                }else if( ch==')'){
                    while( optr.peek()!='('){
                        char opr = optr.pop();
                        // prefix
                        String preop2 =prefix.pop();
                        String preop1 =prefix.pop();
                        prefix.push( opr + preop1 + preop2);
                        //postfix
                        String postop2 =postfix.pop();
                        String postop1 =postfix.pop();
                        postfix.push( postop1 + postop2 + opr);
                        
                    }
                    optr.pop();
                }else if( ch =='-' || ch =='+' || ch =='*' || ch =='/'){
                    while(optr.size()>0 && optr.peek()!='(' && pred( optr.peek() )>=pred( ch ) ){
                        char opr = optr.pop();
                        // prefix
                        String preop2 =prefix.pop();
                        String preop1 =prefix.pop();
                        prefix.push( opr + preop1 + preop2);
                        //postfix
                        String postop2 =postfix.pop();
                        String postop1 =postfix.pop();
                        postfix.push( postop1 + postop2 + opr);
                        
                    }
                    optr.push( ch );
                    
                }
            }
            
            while(optr.size()>0){
                    char opr = optr.pop();
                        // prefix
                        String preop2 =prefix.pop();
                        String preop1 =prefix.pop();
                        prefix.push( opr + preop1 + preop2);
                        //postfix
                        String postop2 =postfix.pop();
                        String postop1 =postfix.pop();
                        postfix.push( postop1 + postop2 + opr );
            }
            
            System.out.println( postfix.peek() );
            System.out.println( prefix.peek() );
        }
        public static int pred( char opr )
        {
                if( opr =='-' || opr =='+'){
                    return 1;
                }else{
                    return 2;
                }
        }
     }

