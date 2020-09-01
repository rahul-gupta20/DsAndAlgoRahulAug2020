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
       int  size()
       {
            // System.out.println(" size of list :"+size);
            return size;
        }
        
        
      
       int getFirst(int idx )
       {
        //   int x = 0;
           if(head == null ){
               System.out.println("List is not exist");
           }
           else if(idx == 0 ){
                idx= head.data;
           }
           return idx;
       }
       
       void removeFirst(){
           if( head == null ){
               System.out.println(" List is Empty ");
               return;
           }
           else{
               Node temp = head;
               head = head.next;
               temp.next = null;
           }
           size--;
       }
       void removeDuplicate()
       {
          LinkedList ans = new LinkedList();
          int val = this.getFirst( 0 );
          this.removeFirst();
          ans.addLast( val );
          Node temp = ans.head;
          while( this.size() > 0 ){
              val = this.getFirst( 0 );
              this.removeFirst();
              if( temp.data != val ){
                  ans.addLast( val );
                  temp = temp.next;
              }
          }
          this.head = ans.head;
          this.tail = ans.tail;
          this.size = ans.size;
          
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
           list.removeDuplicate();
           list.Display();
     
       
   }


}