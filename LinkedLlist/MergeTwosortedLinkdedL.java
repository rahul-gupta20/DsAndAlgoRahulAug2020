import java.util.*;

public class MergeTwoSortedLL{
   
   public static class Node{
       int data;
       Node next;
   }
   public static class LinkedList{
       Node head;  // Node - address ;
       Node tail;
       int size;
       void addLast( int val ){
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
       int  size(){
            // System.out.println(" size of list :"+size);
            return size;
        }
        
        
      
       LinkedList MergeSortLL( LinkedList list1 , LinkedList list2 ){
           LinkedList ans = new LinkedList();
           Node t1 = list1.head;
           Node t2 = list2.head;
           while( t1 != null && t2 != null ){
               if( t1.data < t2.data ){
                   ans.addLast( t1.data );
                   t1 = t1.next;
               }else{
                   ans.addLast( t2.data );
                   t2 = t2.next;
               }
               
               
           }
           while( t2 != null ){
               ans.addLast( t2.data );
               t2 = t2.next;
           }
           while( t1 != null ){
               ans.addLast( t1.data );
               t1 = t1.next;
           }
           
           return ans;
       }
       
   }

   public static void main(String[] args){
       Scanner scn = new Scanner(System.in);
       LinkedList list = new LinkedList();
       
       System.out.println(" list 1 :");
       int n1 = scn.nextInt();
       LinkedList list1 = new LinkedList();
       for(int i=0; i<n1; i++){
           int val1 = scn.nextInt();
           list1.addLast( val1 );
       }
           list1.Display();
          System.out.println();
        System.out.println(" list 2 :");
       
       int n2 = scn.nextInt();
       LinkedList list2 = new LinkedList();
       for(int i=0; i<n2; i++){
           int val2 = scn.nextInt();
           list2.addLast( val2 );
       }
           list2.Display();
           System.out.println();
      
      
       
       LinkedList ansL = list.MergeSortLL( list1 , list2 );
       ansL.Display();

   }


}