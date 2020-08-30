// Q-4 reverse a linked list through pointer
// given a linked list 
// input - 10 20 30 40 50 
// output Display - 50 40 30 20 10

import java.util.*;

public class reverseLinkedListThroughPointer{
   
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
      
       public void reversePointerI(){
           Node prev = null;
           Node curr = head;
           while( curr!= null){
               Node temp = curr.next;
               curr.next = prev;
               prev = curr;
               curr = temp;
           }
           
           tail = head;
           head = prev;
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
       
        System.out.println("Reversed list Below :");
        list.reversePointerI();
        // System.out.println();
        list.Display();
         

   }


}