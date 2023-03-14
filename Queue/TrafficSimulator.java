//Chloe Cho
import java.util.*;
import java.io.*;
public class TrafficSimulator
{
   public static void main(String[] arg)
   {
      MyQueue road1 = new MyQueue();
      MyQueue road2 = new MyQueue();
      Scanner input = new Scanner(System.in);//a,b are the first road and c,d is the second road
      int a,b,c,d;
      System.out.println("Pick a number: ");
      a = input.nextInt();
      System.out.println("Pick another number: ");
      c = input.nextInt();
      System.out.println("Pick a number between 1 - 100: ");
      b = input.nextInt();
      System.out.println("Pick another number between 1 - 100: ");
      d = input.nextInt();
      int cyc;
      System.out.println("How many light cycles: ");
      cyc = input.nextInt();
      
      int c1 = 0;//counter for the cars through intersection
      for(int r = 0; r<cyc; r++)//light cycles
      {
         if(!road1.isEmpty())
         {
            road1.remove();
            c1++;
         }
         for(int i = 0; i<a; i++)//going through first road time increment
         {
            int p = (int)(Math.random()*100 + 1);
            if(p<b)
            {
               road1.add("*");
            }
            System.out.println("Road 1: " + road1.toString());
         }
         System.out.println();
      }
      System.out.println("Cars left on Road 1: " + road1.size());
      System.out.println("Cars that made it through the intersection from Road 1: " + c1);
      System.out.println();
      System.out.println();
      
      int c2 = 0;
      for(int r = 0; r<cyc; r++)
      {
         if(!road2.isEmpty())
         {
            road2.remove();
            c2++;
         }
         for(int j = 0; j<c; j++)//going through second road time increment
         {
            int p = (int)(Math.random()*100 + 1);
            if(p<d)
            {
               road2.add("*");
            }
            System.out.println("Road 2: " + road2.toString());   
         }
         System.out.println();
      }
      System.out.println("Cars left on Road 2: " + road2.size());
      System.out.println("Cars that made it through the intersection from Road 2: " + c2);
   }
}