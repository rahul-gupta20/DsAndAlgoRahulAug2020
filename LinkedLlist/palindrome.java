import java.util.*;

public class palindrome{
   
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
       
       Node mid( Node head , Node tail ){
         Node fast = head;
         Node slow = head;
         while( fast.next != null && fast.next.next != null ){
             fast = fast.next.next;
             slow = slow.next;
         }
         return slow;
           
       }
       
       boolean palin(){
           LinkedList helper =new LinkedList();
           Node midNode = this.mid( this.head , this.tail );
           helper.head = midNode.next;
        //   helper.tail = this.tail;
           midNode.next = null;
           
           helper.reversePointerI();
           
           Node t1 = this.head;
           Node t2 = helper.head;
           boolean ispalindrome = true;
           while( t1 != null && t2 != null ){
                  if( t1.data != t2.data ){
                      ispalindrome = false;
                  }
                  t1 = t1.next;
                  t2= t2.next;
           }
            helper.reversePointerI();
            midNode.next = helper.head;
            // this.tail = helper.tail;
            
            return ispalindrome;     
                 
                 
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
       
        System.out.println( list.palin() );
        
         

   }


}