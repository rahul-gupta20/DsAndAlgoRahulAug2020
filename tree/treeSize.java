
import java.util.*;

public class treeSize{
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
   
    public static int tsize( Node node ){ 
      int mysize=0;
      for( int i=0; i<node.children.size(); i++ ){
          Node child = node.children.get( i );
          int childsize = tsize( child );
           mysize += childsize;
      }     
      return mysize+1;
    }

    public static Node construct(int[] arr){
       Stack<Node> st = new Stack<>();
       Node root=null;
       for( int i =0; i<arr.length; i++){
           if( arr[ i ] == -1){
               st.pop();
           }
           else{
               Node t = new Node();
               t.data = arr[ i ];
               if(st.size()>0){
                   st.peek().children.add( t );
               }else{
                   root = t;
               }
               st.push( t );
           }
       }
         return root;

    }

    public static void displaytree(Node node){
        String str = node.data+" -> ";
        for(Node child:node.children){
            str+=child.data+",";
        }
        str+=".";
        System.out.println( str );
         for(Node child:node.children){
             displaytree(child);
         }
    }
    public static void main(String[] args){
       int[] arr = { 10 , 20 , -1, 30 , 50 , -1 , 60 , -1 , -1, 40 ,-1, -1 };
        Node root = construct( arr );
        // displaytree(root);

        int treeSz = tsize( root );
        System.out.println( treeSz );
    }
}