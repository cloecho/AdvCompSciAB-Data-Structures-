//Chloe Cho
public class Cell<anyType>{
   private anyType value;
   private int row, col;

   public Cell(anyType v, int r, int c){
      value = v;
      row =r;
      col = c;
   }

   public anyType getValue(){
      return value;
   }

   public int getRow(){
      return row;
   }

   public int getCol(){
      return col;
   }
   
   public void setValue(anyType val){
      value = val;
   }
   
   public String toString(){
      return value + "is at row: " + row + " & col: " + col;
   }  
}