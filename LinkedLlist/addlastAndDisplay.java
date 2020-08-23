// -------------Linked List 
//  --------------------------------question 1 --------
//  Add element to list----------------
//  Display a list --------------
import java.util.*;

public class addlastAndDisplay{
   
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
        
        
       void addFirst( int val ){
           Node temp = new Node();
           temp.data = val;
           if( head == null){
               head = temp;
               tail = temp;
           }
           else{
               temp.next = head;
               head = temp;
           }
           size++;
       }

       void removeFirst(){
        //    if( head == null){
        //        System.out.println("list is not exist");
        //    }
           Node temp;
           temp = head;
           head = temp.next;
           temp.next = null;
           size--;
       }

       void removeLast(){
            Node temp;
            temp = head;
            while( temp.next.next!=null ){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            size--;
            
       }
       void getFirst(int idx ){
           if(head == null ){
               System.out.println("List is not exist");
           }
           else if(idx == 0 ){
               System.out.println( head.data );
           }
       }
      
      void getLast( int idx ){
           if(head == null ){
               System.out.println("List is not exist");
           }
           else if(idx>=size){
               System.out.println("Invalid index");
           }
           else if(idx == size - 1 ){
               System.out.println( tail.data );
           }

       }
       void getAtIndex( int idx ){
           if( idx<0 || idx>=size){
                System.out.println("Invalid index");
           }
           else if( idx == 0){
               getFirst( idx );
           }
           else if( idx == size - 1){
               getLast( idx );
           }
           else{
             Node temp;
             temp = head;
             while( idx != 0 ){
                 temp = temp.next;
                 idx--;
             }  
             System.out.println( temp.data );
           }
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
        //   int ans = list.size();  
        //   System.out.println(ans);
        // System.out.println("Enter the fisrt element ");
        // // System.out.println();
        // int ele = scn.nextInt();
        // list.addFirst( ele );
        // System.out.println();
        //  list.Display();
        //  list.removeFirst();
        //  System.out.println();
        //  System.out.println(" First element removed below is updated list");
        //  list.Display();
        //  list.removeLast();
        //  System.out.println();
        //  list.Display();
        //  System.out.println("Enter the  first index ");
        //  int idx = scn.nextInt(); 
        //  list.getFirst( idx );
        //  System.out.println();
        //  System.out.println("Enter the last index ");
        //  int i = scn.nextInt(); 
        //  list.getLast( i );
         System.out.println("Enter the any index ");
         int i = scn.nextInt(); 
         list.getAtIndex( i );

   }

//  5
//  1 2 3 4 5
}