import java.util.*;

public class treeinorder{
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
   
    public static void inorder( Node node ){ 
        int state=1;
        if( node.children.size() == 0 ){
            System.out.print( node.data+" ");
            return;
        }
        for( int i=0; i<node.children.size(); i++ ){
            inorder( node.children.get( i ) );
            if( state == 1 ){
                System.out.print( node.data +" ");
                state++;
            }
        }
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
      int[] arr = { 10 , 20 , -1 , 30 , 50 , -1, 60 , -1 ,-1,40,-1,-1 };
    // int[] arr = { 10,20,-1,30,-1,-1};
        Node root = construct( arr );
        // displaytree(root);
         inorder( root );
        
    }
}