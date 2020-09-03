import java.util.*;
public class removeDuplicate
{
   public static class Node{
       int data;
       Node next;
   }
   public static class LinkedList
   {
       Node head;  // Node - address ;
       Node tail;
       int size;
       void addLast( int val )
       {
        // spcl work 
        Node temp = new Node();
        temp.data = val;
        if( head == null )
        {
           head = temp;
           tail = temp; 
        }
        else{
            tail.next = temp;
            tail = temp;
            temp.next = null;
        }
        size++;
       }
       void Display()
       {
         Node t;
         for(  t = head ; t.next != null; t=t.next){
             System.out.print(t.data+" ");
           }
            System.out.print(t.data+" ");
       }
       void reversePrint( Node node ){
           if( node == null ){
               return;
           }       
           reversePrint( node.next );
           System.out.print( node.data+" " );
       }   
   }
   public static void main(String[] args){
       Scanner scn = new Scanner(System.in);
       System.out.println("Eneter the size of list :");
       int n = scn.nextInt();
       LinkedList list = new LinkedList();
       for(int i=0; i<n; i++){
           int val = scn.nextInt();
           list.addLast( val );
       }
           list.Display();
           System.out.println();
           list.reversePrint( list.head ); 
   }
}