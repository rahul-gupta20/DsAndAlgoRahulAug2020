
// Question -1 ------------->  Check duplicacy in experesion <---------------------------------

// 1. You are given a string exp representing an expression.
// 2. Assume that the expression is balanced  i.e. the opening and closing brackets match with each other.
// 3. But, some of the pair of brackets maybe extra/needless. 
// 4. You are required to print true if you detect extra brackets and false otherwise.

// e.g.'
// ((a + b) + (c + d)) -> false
// (a + b) + ((c + d)) -> true

import java.util.*;
public class question_1_dupliacteCheck{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        boolean ans = Checkdup( str );
        System.out.println( ans );
    }

    public static boolean Checkdup( String exp ){
        Stack <Character> st = new Stack<>();
        for(int i =0; i<exp.length(); i++)
        {
            char ch = exp.charAt( i );
            if(ch == ')'){
                // spcl work
                if(st.peek() =='('){
                    return true;
                }
                else{
                    while(st.peek()!='('){
                        st.pop();
                    }
                    st.pop();
                }
            }
            else{
                st.push( ch );
            }
        }

        return false;
    }
}









































































































































