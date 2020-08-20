
// ----------------- infix Evaluation------------------------//

// 1. You are given an infix expression.
// 2. You are required to evaluate and print it's value.
//  expersion is --- 2+6*4/8-3----------
import java.util.*;
public class infixEvaluation
{
  public static void main(String[] args)
  {
     Scanner scn = new Scanner(System.in);
     String str = scn.nextLine();
     int ans = infixeval( str  );
     System.out.println( ans );
  }

  public  static int infixeval( String exp )
  {
    Stack<Integer> num = new Stack<>();
    Stack<Character> opr = new Stack<>();
    for( int i=0; i<exp.length(); i++){
        char ch = exp.charAt( i );
       
       if( ch >= '0' && ch <='9'){
              num.push( ch-'0');
       }
       else if( ch == '('){
           opr.push( ch );
       }else if(ch == ')'){
           //spcl work
            while(opr.peek()!='('){
                      
                char optr = opr.pop();
                int val2 = num.pop();
                int val1 = num.pop();
                int val = solve( optr , val1 , val2);
                num.push( val );
            }
            opr.pop();
       }
       else if( ch == '+' || ch == '-' || ch == '*' || ch == '/' ){
             while(opr.size()>0 && opr.peek()!='(' && preced( opr.peek() ) >= preced( ch )){
                // spcl work
                char optr = opr.pop();
                int val2 = num.pop();
                int val1 = num.pop();
                int val = solve( optr , val1 , val2);
                num.push( val );
             }
             opr.push( ch );
       }

    }

    if( opr.size()>0){
        // spcl work
           char optr = opr.pop();
           int val2 = num.pop();
           int val1 = num.pop();
           int val = solve( optr , val1 , val2);
           num.push( val );

    }
    return num.pop();

  }
    public static int solve( char opt , int opr1 , int opr2)
    {
        if( opt == '+'){
            return opr1+opr2;
        }else if( opt == '-'){
            return opr1-opr2;
        }else if( opt == '*'){
        return opr1*opr2;
        }else{
        return opr1/opr2;
        }
    }
    
    public static int preced( char op )
    {
        if( op == '+' || op == '-'){
            return 1;
        }else{
            return 2;
        }
    }



}