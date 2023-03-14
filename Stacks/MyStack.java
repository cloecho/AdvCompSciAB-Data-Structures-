//Chloe Cho
import java.util.*;
import java.io.*;
public class MyStack<anyType> implements Stackable<anyType>
{
   private List<anyType> list;	
   public MyStack()
   {
      list = new ArrayList();	//could also be a Linked List
   }
     //now define interface methods and a toString method
     
   public void push(anyType x)
   {
      list.add(x);
   }

 /** removes and returns the element at the top of a non-empty stack.
  * @return the value that was removed; returns null if the stack is empty.
  */
   @Override
   public anyType pop()
   {
      if(!isEmpty()){
         anyType temp = list.get(size()-1);
         list.remove(size()-1);
         return temp;
      }
      return null;
   
   }
        				                 
 /** returns the element at the top of a non-empty stack.
  * @return the element at the top of the stack; returns null if the stack is empty.
  */           
   @Override                          
   public anyType peek()
   {
      if(!isEmpty()){
         return list.get(size()-1);
      }
      return null;
   
   }
                         
 /** lets the client know if the stack has any elements or is empty.
  * @return true if the stack is empty; returns false if the stack has elements stored in it.
  */          
   @Override                           
   public boolean isEmpty()
   {
      if(list != null && list.size() > 0){
         return false;
      }
      return true;
   
   }
   
 /** returns the number of logical elements stored in the stack.
 *   @return the number of elements added into the stack.
 */    
 
   public int size(){
      return list.size();
   }
   
   @Override
   public String toString(){
      String temp = "";
      for(int i = 0; i<list.size(); i++){
         if(list.get(i) != null)
         {
            temp += list.get(i) +"";
         }
         else{
         temp += "_ ";
         }
      }
      return temp;
   }

}
