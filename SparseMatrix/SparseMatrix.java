//Chloe Cho
import java.util.*;
public class SparseMatrix<anyType> implements Matrixable<anyType>
{
   private LinkedList<Cell<anyType>> list;    //stores the actual elements
   private int numRows, numCols;                  //logical dimensions
   private char blankCharacter;
   
   public SparseMatrix (int r, int c)
   {
      list = new LinkedList();       
      numRows = r;
      numCols = c;
   }
   
   public int numRows(){//returns # rows set in constructor
      return numRows;
   }
   public int numColumns(){//returns # cols set in constructor
      return numCols;
   }

   public int size(){//returns # actual elements stored
      return list.size();
   }		
   public boolean add(int r, int c, anyType obj){//adds obj at row r, col c, true if r&c are valid
   
      if((r <= numRows && r>=0)&&(c <= numCols && c >= 0)){//if rows and colums are valid
         Cell<anyType> temp = new Cell(obj,r,c);
         list.add(temp);
         return true;
      }
      return false;
   }
   
   public anyType get(int r, int c){//returns the element at row r, col c
      for(int i = 0; i<list.size(); i++){
         if((list.get(i).getRow() == r) && (list.get(i).getCol() == c)){
            return list.get(i).getValue();
         }
      }
      return null;
   }
    
   public anyType set(int r, int c, anyType obj) {
      if((r <= numRows && r>=0)&&(c <= numCols && c >= 0)){
         for(int i = 0; i<list.size(); i++){
            if((list.get(i).getRow() == r) && (list.get(i).getCol() == c)){
               anyType hold = list.get(i).getValue();//holds a temporaray value to return
               list.get(i).setValue(obj);
               return hold;
            }
         }
      
      }
      return null;
   }
   public anyType remove(int r, int c){
      for(int i = 0; i<list.size(); i++){
         Cell<anyType> current = list.get(i);
         if((list.get(i).getRow() == r) && (list.get(i).getCol() == c)){
            anyType temp = current.getValue();
            list.remove(i);
            return temp;
         }
      }
      return null;
   }
   
   @Override
   public String toString(){
      String ans = "";
      blankCharacter = '-';
      for(int r = 0 ; r < numRows; r++){
         for(int c= 0; c < numCols; c++){
            anyType temp = this.get(r,c);
            if(temp == null){
               ans += blankCharacter + " ";
            }
            else{
               ans += temp + " ";
            }
            
         }
         ans += "\n"; //moves on to the next line of the grid
      }
      return ans;
   }

   public Object[][] toArray(){//returns equivalent structure in 2-D array form
      Object[][] convert = new Object[numRows][numCols];
      int i = 0;
      for(int r = 0; r<numRows-1; r++){
         for(int c =0; c<numCols-1; c++){
            convert[r][c] = list.get(i);
            i++;
         }
      }
      return convert;
   }
   public boolean contains(anyType x){// if x is in the sparse matrix
      for(int i = 0; i<list.size(); i++){
         if(list.get(i).getValue() == x){
            return true;
         }
      }
      return false;
   }
  
   public int[] getLocation(anyType x){ //returns location [r,c] of where x exists in list, null otherwise
      int[] location = new int[2];
      for(int i = 0; i<list.size(); i++){
         if(list.get(i).getValue() == x){
            location[0] = list.get(i).getRow();
            location[1] = list.get(i).getCol();
            return location; 
         }
      }
      return null;
   }
   
   public boolean isEmpty(){	//returns true if there are no actual elements stored
      for(int i = 0; i<list.size(); i++){
         if(list.get(i).getValue() != null){
            return false;
         }
      }
      return true; //returns true if they are all null which mean there are no elements stored
   }
   
   public void clear(){					//clears all elements out of the list
      for(int i = list.size()-1; i<=0; i--){
         remove(list.get(i).getRow(), list.get(i).getCol());
      }
   }   
   
   /*allows the client to set the character 
   that a blank spot in the array is represented by in String toString() */
   public void setBlank(char blank){
      blankCharacter = blank;
   }
}
