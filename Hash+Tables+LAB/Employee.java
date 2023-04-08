//Chloe Cho
import java.util.Random;
import java.io.FileOutputStream; 
import java.io.PrintStream;
import java.util.Scanner;
import java.io.File;
public class Employee implements Comparable
{
   private int employeeNumber;
   private String name;
   
   public Employee(int num)
   {
      employeeNumber = num;
      name = generateRandomName();
   }
   
   private char getRandomVowel() {
      Random random = new Random();//using the Java's random class. I found that its included in Java's Standard Library
      String vowel = "AEIOU";
      int index = random.nextInt(vowel.length());
      return vowel.charAt(index);
   }
   private char getRandomConsonant() {
      Random random = new Random();
      String consonants = "BCDFGHJKLMNPQRSTVWXYZ";
      int index = random.nextInt(consonants.length());
      return consonants.charAt(index);
   }
   
   private String generateRandomName()
   {
      String ans = "";
      int random = (int)((Math.random() * 6) + 3);
      for(int i = 0; i<random; i++)
      {
         if(i%3 == 0)
         {
            ans += getRandomVowel();
         }            
         else
         {
            ans += getRandomConsonant();
         }
      }
      return ans;
   }
   
   public Employee(int num, String n)
   {
      employeeNumber = num;
      name = n;
   }  
   
   public int getEmployeeNumber()
   {
      return employeeNumber;
   }
   
   public String getName()
   {
      return name;
   }

   public int compareTo(Object o)
   {
      if (!(o instanceof Employee)) {
         throw new ClassCastException("Object is not an instance of Employee");
      }
      Employee other = (Employee) o;
      return Integer.compare(employeeNumber, other.employeeNumber);
   }
   
   public int hashCode() {
      int sum = 0; 
      for(int i = 0; i<name.length(); i++)
      {
         char letter = name.charAt(i);
         sum += (int)(letter) * i;
      }
      return sum;
   }   
   
   @Override
   public String toString()
   {
      return "" + employeeNumber + " " + name;
   }
      
   public boolean equals(Object arg)//both name and number
   {
      Employee other = (Employee)(arg);
      return this.name.equals(other.name);
   }
   
   
}