//Chloe Cho
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HashedEmployeeContainer {

   private Employee[] table;
   private int size;

   public HashedEmployeeContainer(int size) {
      this.table = new Employee[size];
      this.size = size;
   }

   public static HashedEmployeeContainer readFile(String fileName) throws IOException {
      int size = getFileSize(fileName);
      HashedEmployeeContainer container = new HashedEmployeeContainer(size);
      BufferedReader reader = new BufferedReader(new FileReader(fileName));
      String line = null;
      while ((line = reader.readLine()) != null) {
         String[] parts = line.split(" ");
         if (parts.length < 2) {
            continue; // skips the line if it doesn't contain both number and name
         }
         String numStr = parts[0];
         String name = parts[1];
         try {
            int num = Integer.parseInt(numStr);
            Employee emp = new Employee(num, name);
            container.add(emp);
         } catch (NumberFormatException e) {
            continue; // skips line if its not a valid integer
         }
      }
      reader.close();
      return container;
   }

   public int size() {
      return size;
   }

   public void add(Employee emp) {
      int index = emp.hashCode() % size;
      while (table[index] != null) {
         index = (index + 1) % size; // linear probing to resolve collisions
      }
      table[index] = emp;
   }

   public Employee get(int number) {
      for (int i = 0; i < size; i++) {
         if (table[i] != null && table[i].getEmployeeNumber() == number) {
            return table[i];
         }
      }
      return null;
   }

   private static int getFileSize(String fileName) throws IOException {
      BufferedReader reader = new BufferedReader(new FileReader(fileName));
      int size = 0;
      while (reader.readLine() != null) {
         size++;
      }
      reader.close();
      return size;
   }
   
   public int getEmployeeNumber(String name) {
      for (int i = 0; i < size; i++) {
         if (table[i] != null && table[i].getName().equals(name)) {
            return table[i].getEmployeeNumber();
         }
      }
      return -1; // return -1 if the employee is not found
   }
}

