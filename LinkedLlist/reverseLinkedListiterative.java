// Q-3 reverse a linked list with itereative 
// Input - 10 20 30 40 50 
// output - 50 40 30 20 10

import java.util.*;

public class reverseLinkedListiterative{
   
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
      
      void getLast( int idx )
      {

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

       public void ceilandfloor( int data )
       {
           int floor = Integer.MIN_VALUE;
           int  ceil = Integer.MAX_VALUE;
           Node temp;
           temp = head;
            while( temp!=null)
            {
              
                //    floor Qualification
                if( temp.data<data){

                    if( floor<temp.data){
                        floor = temp.data;
                    }
                }

                // ceil Qualification
                if( temp.data>data){
                    if(ceil>temp.data){
                        ceil = temp.data;
                    }
                }

                temp = temp.next;
            }
           System.out.println( "floor :"+floor );
           System.out.println("ceil :" +ceil );
          

       }
       
       Node getNode( int idx ){
           
           Node temp = head;
           while( idx!=0){
               
               temp = temp.next;
               
               idx--;
           }
           return temp;
       }
       public void reverselist(){
           
           int i=0;
           int j=size - 1;
           
           while( i < j ){
               
               Node x = getNode( i );
               Node y = getNode( j );
               
               int temp = x.data;
               x.data = y.data;
               y.data = temp;
               
               i++;
               j--;
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
        //  System.out.println("Enter the any index ");
        //  int i = scn.nextInt(); 
        //  list.getAtIndex( i );
        // System.out.println("Enter your data :");
        // int data = scn.nextInt();
        // list.ceilandfloor( data );
        
        list.reverselist();
        System.out.println();
        System.out.println("Reversed list Below :");
        System.out.println();
        list.Display();
         

   }


}