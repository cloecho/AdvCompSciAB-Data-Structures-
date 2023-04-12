//d oberle - doberle@fcps.edu.
import java.awt.Color;

public class SandUtilities
{
  //pre : c!= null.
  //post: returns the inverted color from the one sent as c.
   public static Color invert(Color c)
   {
      if(c != null)
      {
      return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
      }
      return c; 
   }
   //pre:   m!= null.
   //post:  for each non-null element of m, changes it to its inverted color.
   //       skips any color with the value skip1 and skip2, leaving them unchanged.
   public static void invertColors(Color[][]m, Color skip1, Color skip2)
   {
      Color color = null;
      for(int row = 0; row< m.length; row++)
      {
         for(int col = 0; col<m[row].length; col++)
         {
            color = m[row][col];
            if(color == skip1 && color == skip2)
            {
               continue;
            }
            else
               invert(color);
         }
      }
   }
   
   //pre:   m is a square 2-D array (m.length==m[0].length).
   //post:  flips the array upside down.
   public static void flipUpsideDown(Object[][]m)
   {
      for(int i = 0; i < (m.length / 2); i++)
      {
         Object[] temp = m[i];
         m[i] = m[m.length - i - 1];
         m[m.length - i - 1] = temp;
      }
   }
   
   //pre:   m is a square 2-D array (m.length==m[0].length)
   //post:  rotates the array 90 degrees to the left
   public static void rotateLeft(Object[][] m) //similar to a transpose... I learned this in linear algebra!
   {
      for(int i=0; i<m.length; i++)  
      {  
         for(int j=i; j<m[i].length; j++)  
         {  
            Object temp = m[i][j];  
            m[i][j]=m[j][i];  
            m[j][i]=temp;   
         }  
      }  
   }

   //pre:   m is a square 2-D array (m.length==m[0].length)
   //post:  rotates the array 90 degrees to the right
   public static void rotateRight(Object[][] m)//now you have to switch from rotate left!
   {
      rotateLeft(m);
         
      for(int j=0; j<m[0].length/2; j++) //same thing as flip upside down method but now going left to right :)
      {                 
         Object[] temp = m[j];  
         m[j]=m[m[0].length- j - 1];  
         m[m[0].length- j - 1]= temp;      
      }    
   } 
}