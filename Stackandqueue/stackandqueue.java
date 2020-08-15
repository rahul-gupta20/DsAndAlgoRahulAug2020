//      -----------------------stack and queue implementation----------------------------
import java.util.*;
public class stackandqueue{

    public static void main(String[] args){
            Stack<String> st = new Stack<>();
            st.push("one");  // push 
            st.push("two");
            st.push("Four");
            st.push("Five");
            st.push("six");
            System.out.print( st );
            System.out.println();
            System.out.println(st.pop()+" is pop from delete"); // pop
            System.out.println( st );
            System.out.println();
            System.out.println(st.size()+" size of stack"); // size 
            System.out.println();
            System.out.println(st.peek()+" top of stack");  // peek
    System.out.println();
    System.out.println(" Queue started ");
    System.out.println();

    // Queue----------------------------------

      Queue<String> que = new LinkedList<>();  
    //   add()  ////  1 2 3 4 5 6  
    //   remove()  //   
    //   size()
    //   peek()
        que.add("1");
        que.add("2");
        que.add("3");
        que.add("4");
        System.out.println( que );
        System.out.println();
        System.out.println(que.remove()+" is removed from Queue");
        System.out.println(que.remove("3"));
        System.out.println( que );
        System.out.println("given ellement is present or not --> "+que.contains("2"));  // contains
        System.out.println(que.size()+" <-- size of queue");
        


    }




}

