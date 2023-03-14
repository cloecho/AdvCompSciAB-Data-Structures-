//Chloe Cho
import java.util.*;
import java.io.*;
public class MyQueue<E> implements Queueable<E>
{
   private List<E> list;	
   public MyQueue()
   {
      list = new LinkedList();//could also be an ArrayList List 
   }
   public boolean isEmpty()
   {
      if(list != null && list.size() > 0){
         return false;
      }
      return true;
   }
 
   public void add(E x)
   {
      list.add(x);
   } 
   
   public E remove()
   {
      if(!isEmpty())
      {
         return list.remove(0);
      }
      return null;
   } 
  
   public E peek()
   {
      if(!isEmpty()){
         return list.get(0);
      }
      return null;
   }
     
   public int size()
   {
      return list.size();
   }
   
   public String toString()
   {
      String temp = "";
      for(int i = 0; i<list.size(); i++){
         if(list.get(i) != null)
         {
            temp += list.get(i) +"";
         }
      }
      return temp;
   }
   
}
