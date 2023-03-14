/**a circular-linked list container - conserves memory (no buffer space)
   d oberle 10/2021.
*/
public class cLinkedList<anyType> implements ListInterface<anyType>
{
/** Data field: a reference to the first node in the list */
   private ListNode<anyType> head;
   private ListNode<anyType> tail;
   private int count;

/** No arg constructor initializes the LinkedList to an empty list. */
   public cLinkedList()		
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
         head = new ListNode(x,null);
         head.setNext(head);
         tail = head;
      }
      else
      {
         ListNode oldHead = head;
         head = new ListNode(x,oldHead);
         tail.setNext(head);
         
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
        
         tail.setNext(new ListNode(x,head));	//make the last element's next become a new ending node
         tail = tail.getNext();
         count++;
      }
   
   }

/**Retrieve the first node in the LinkedList if the head is not null
 * @return the value of the first node in the List, or null if the head is null
 */
   public anyType getFirst()
   {
      if (head==null)							//if list is empty
         return null;							//this is our flag for an unsuccessful add
      return head.getValue();
   }

/**Retrieve the last node in the LinkedList if the head is not null
 * @return the value of the last node in the List, or null if the head is null
 */
   public anyType getLast()
   {
      if (head==null)							//if list is empty
         return null;
   
      return tail.getValue();
   }

/**Remove the first node in the LinkedList and return its value if the head is not null
 * @return the value of the node removed from the List, or null if the LinkedList is empty
 */
   public anyType removeFirst() 
   {
      if(head == null)
      {
         return null;
      }
      anyType temp = head.getValue();
      if(size() == 1)
      {
         head = null;
         tail = null;
      }
      else
      {  
         head = head.getNext();
         tail.setNext(head);
      
      }
      count--;
      return temp;
   }

/**Remove the last element of the list and return its value if the list is not empty
 * @return the value of the element removed, or null if the list is empty
 */
   public anyType removeLast()
   {
      if (head==null)											//if list is empty
         return null;
      anyType temp = getLast();
      if (size() == 1){							//only one element in the list
         head = null;
         tail = null;
         }
      else
      {
         ListNode current = head;							//current will traverse the list
         while(current.getNext().getNext() != head)	//move current to the second to last node
            current=current.getNext();
         current.setNext(head);
         tail = current;								//then cap off the end of the new, smaller list with null
      }	
      count--;
      return temp;
     
   }
   
/**Returns the number of logical elements stored in the LinkedList.
 * @return the size of the LinkedList.
 */
   public int size()
   {
      return count;							//temporary code to keep the file compiling
   }

/**Finds the Object that resides at a given index
 * @param index a value such that index is greater or equal to 0 and index is less than size()
 * @return the value stored in the node at the given index, or null if the list is empty or invalid index
 */
   public anyType get(int index)		
   {
      ListNode curr = head;
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

/**Change the Object that resides at a given index to a new value
 * @param index a value such that index is greater or equal to 0 and index is less than size()
 * @param x a non-null Object
 * @return the old value stored in the node at the given index, or null if the list is empty or invalid index
 */
   public anyType set(int index, anyType x)
   {
      ListNode curr = head;
      
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

/**Add a new element at the end of the list
 * @param x a non-null Object
 * @return true
 */
   public boolean add(anyType x)
   {
      addLast(x);
      return true;			
   }	

/**Add a new element at a given index
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
         ListNode curr = head;
         for(int i = 0; i<index-1; i++)
         {
            curr = curr.getNext();
         
         }
         curr.setNext(new ListNode(x,curr.getNext()));
         return true;
      }
   		
   }

/**Remove a node that resides at a given index and return its value
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
         ListNode curr = head;
         for(int i = 0; i<index-1; i++)
         {
            curr = curr.getNext();
         
         }
         anyType ashley = (anyType)curr.getNext().getValue();
         curr.setNext(curr.getNext().getNext());
         return ashley;
      }

  
     }

/**Returns a String of all the elements in the List in the form [a0, a1, a2, . . . , an-1]
 * @return String of all the list elements separated by a comma
 */
   public String toString()
   {
      String ans = "[";									//start with left bookend						
      ListNode current =  head;
     for(int i = 0; i<size(); i++)
      {
         ans += current.getValue().toString();
         current = current.getNext();
         if ((i+1) <size())							//don't add comma after the last element
            ans += ",";
      }
      ans += "]";											//end with right bookend
      return ans;
   }

/**Finds if the LinkedList is empty (true) or contains items (false).
 * @return whether or not the LinkedList is empty.
 */
   public boolean isEmpty()
   {
      if (head == null)
         return true;
      return false;
   }
}