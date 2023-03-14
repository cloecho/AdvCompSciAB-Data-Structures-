/**a linked list container with double-linked nodes - conserves memory (no buffer space)
   d oberle 10/2021.
*/
public class dLinkedList<anyType> implements ListInterface<anyType>
{
/** Data field: a reference to the first node in the list */
   private dListNode<anyType> head;
   private dListNode<anyType> tail;
   private int count;

/**
 * No arg constructor initializes the dLinkedList to an empty list.
 *
 */
   public dLinkedList()
   {
      head = null;
      tail = null;
      count = 0;
   }

/**
 * Adds a new element to the front of the LinkedList.
 *
 * @param  x a non-null Object.
 */
   public void addFirst(anyType x)				
   {
      if(head == null)
      {
         head = new dListNode(x,null,null);
         tail = head;
      }
      else
      {
         dListNode oldHead = head;
         head = new dListNode(x,null,oldHead);
         oldHead.setPrev(head);
         
      } 
      count++;
   }

/**
 * Adds a new element to the end of the LinkedList.
 *
 * @param  x a non-null Object.
 */
   public void addLast(anyType x)
   {
      if (head==null)										//if list is empty
         addFirst(x);					//head refers to the only node
      else
      {
         tail.setNext(new dListNode(x,tail,null));
         tail = tail.getNext();
      }
      count++;      
   }

/**
 * Retrieve the first node in the LinkedList if the head is not null
 *
 * @return the value of the first node in the List, or null if the head is null
 */
   public anyType getFirst()
   {
      if (head==null)							//if list is empty
         return null;
      return head.getValue();
   }

/**
 * Retrieve the last node in the LinkedList if the head is not null
 *
 * @return the value of the last node in the List, or null if the head is null
 */
   public anyType getLast()
   {
      if (head==null)							//if list is empty
         return null; 
      return tail.getValue();
   }

/**
 * Remove the first node in the LinkedList and return its value if the head is not null
 *
 * @return the value of the node removed from the List, or null if the LinkedList is empty
 */
   public anyType removeFirst()
   {
      if(head == null)
      {
         return null;
      }
      anyType temp = head.getValue();
      if(head.getNext() == null)
      {
         head = null;
         tail = null;
      }
      else
      {  
         head = head.getNext();         
      }
      count--;
      return temp;
   }
//****************************************************************

/**
 * Remove the last element of the list and return its value if the list is not empty
 *
 * @return the value of the element removed, or null if the list is empty
 */
   public anyType removeLast()
   {
   
      if (head==null)											//if list is empty
         return null;
      anyType temp = getLast();
      if (head.getNext() == null)	
      {						//only one element in the list
         head = null;
         tail = null;
      }
      else
      {
         tail.getPrev().setNext(null);	
         tail = tail.getPrev();						//then cap off the end of the new, smaller list with null
      }	
      count--;
      return temp;
   
   
   }

/**
 * Returns the number of logical elements stored in the LinkedList.
 *
 * @return the size of the LinkedList.
 */
   public int size()
   {
      return count;
   }

/**
 * Finds the Object that resides at a given index
 *
 * @param index a value such that index is greater or equal to 0 and index is less than size()
 * @return the value stored in the node at the given index, or null if the list is empty or invalid index
 */
   public anyType get(int index)		
   {
      dListNode curr = head;
      if(index < 0 || index >= size())
      {
         return null;
      }
      for(int i = 0; i<index; i++)
      {
         curr = curr.getNext();
      }
      return (anyType) curr.getValue();
   
   }	

/**
 * Change the Object that resides at a given index to a new value
 *
 * @param index a value such that index is greater or equal to 0 and index is less than size()
 * @param x a non-null Object
 * @return the old value stored in the node at the given index, or null if the list is empty or invalid index
 */
   public anyType set(int index, anyType x)
   {
      dListNode curr = head;
      
      if(index < 0 || index >= size())
      {
         return null;
      }
      for(int i = 0; i<index; i++)
      {
         curr = curr.getNext();
      }
      anyType temp = (anyType)curr.getValue();
      curr.setValue(x);
      return temp;
   
   }	
//****************************************************************

/**
 * Add a new element at the end of the list
 *
 * @param x a non-null Object
 * @return true
 */
   public boolean add(anyType x)
   {
      addLast(x);
      return true;			
   }	

/**
 * Add a new element at a given index
 *
 * @param index a value such that index is greater or equal to 0 and index is less than size()
 * @param x a non-null Object
 * @return if the element was added successfully, false if the index is invalid
 */
   public boolean add(int index, anyType x)
   {
      if(index < 0 || index > size())
      {
         return false;
      }
      if(index == 0){
         addFirst(x);
         return true;
      
      }
      else if(index == size())
      {
         addLast(x);
         return true;
      }
      else
      {
         dListNode curr = head;
         for(int i = 0; i<index-1; i++)
         {
            curr = curr.getNext();
         
         }
         curr.setNext(new dListNode(x,curr.getPrev(),curr.getNext()));
         return true;
      }
   
   }	

/**
 * Remove a node that resides at a given index and return its value
 *
 * @param index a value such that index is greater or equal to 0 and index is less than size()
 * @return the value of the element removed, or null if the list is empty or invalid index
 */
   public anyType remove(int index)		
   {
      if(index < 0 || index >= size())
      {
         return null;
      }
      if(index == 0){
         return removeFirst();
         
      
      }
      else if(index == size())
      {
         return removeLast();
        
      }
      else
      {
         dListNode curr = head;
         for(int i = 0; i<index-1; i++)
         {
            curr = curr.getNext();
         
         }
         anyType ashley = (anyType)curr.getNext().getValue();
         curr.setNext(curr.getNext().getNext());
         tail.setPrev(tail.getPrev());
         return ashley;
      }
   
   }	
	

/**
 * Returns a String of all the elements in the List in the form [a0, a1, a2, . . . , an-1]
 *
 * @return String of all the list elements separated by a comma
 */
   public String toString()
   {
      String ans = "[";									//start with left bookend						
      dListNode<anyType> current =  head;
      while(current != null)
      {
         ans += current.getValue().toString();
         current = current.getNext();
         if (current != null)							//don't add comma after the last element
            ans += ",";
      }
      ans += "]";											//end with right bookend
      return ans;
   }

/**
 * Finds if the dLinkedList is empty (true) or contains items (false).
 *
 * @return whether or not the dLinkedList is empty.
 */
   public boolean isEmpty()
   {
      if (head == null)
         return true;
      return false;
   }

}