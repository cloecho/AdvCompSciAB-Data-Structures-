//Chloe Cho
import java.util.Scanner;
import java.io.IOException;
public class HashTableLabDriver
{
   public static void main(String[] args) {
      try {
         HashedEmployeeContainer container = HashedEmployeeContainer.readFile("hashData.txt");
         Scanner scanner = new Scanner(System.in);
         System.out.print("Enter employee name: ");
         String name = scanner.nextLine();
         int number = container.getEmployeeNumber(name);
         if (number == -1) {
            System.out.println("Employee not found");
         } else {
            System.out.println("Employee number: " + number);
         }
      } catch (IOException e) {
         System.out.println("Error reading file");
      }
   }
}