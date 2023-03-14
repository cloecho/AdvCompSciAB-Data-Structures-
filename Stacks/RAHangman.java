//Chloe Cho
//Reverse Auto Hangman
import java.util.*;
import java.io.*;
public class RAHangman
{
   public static void main(String []arg)
   {
      String word;
      Scanner input = new Scanner(System.in);
      System.out.println("Enter a word: ");
      word = input.next();
      for(int n = 0; n<25; n++){
         System.out.println(); //so the player doesn't see the answer
      }
      MyStack answer = new MyStack();
      String[] show = new String[word.length()];
   
      int c = word.length()-1; //counter
      int sc = 0;//score
     
      while(c != 0)
      {
           
         for(int i = 0; i<word.length(); i++)//add the word into the stack
         {
            answer.push(word.substring(i,i+1));
         }
         
         System.out.println("Your word is: ");
         for(int i = 0; i<word.length(); i++)
         {
            if(i<c)
            {
               System.out.print("_ ");
            }
            else
            {
               System.out.print(word.substring(i,i+1) + " ");
            }
         }
      
         System.out.println();
         System.out.println("Score: " +sc);
         System.out.println();
         System.out.println("What letter do you guess?"); 
         String letter = "";
         letter = input.next();
         System.out.println();
      
         if(answer.peek().equals(letter))//checks user guess and stack letter
         {
            System.out.println("Incorrect! You lose " + (word.length()-c-1) + " points.");
            sc -= word.length()-c-1;
         }
         else
         {
            System.out.println("Correct! You gain " + (c+1) + " points.");
            sc += c+1;
         }
         answer.pop();
         c--;
      }//end of while loop/game
      
      System.out.println();
      System.out.println("Congrats you guessed [" + word + "] correcty!");
      System.out.println("Your total score: " + sc);
   
   }
}