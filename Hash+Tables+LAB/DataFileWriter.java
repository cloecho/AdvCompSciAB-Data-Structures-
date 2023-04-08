//Chloe Cho
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class DataFileWriter{

   public static void main(String[] args) throws IOException {
      System.setOut(new PrintStream(new FileOutputStream("hashData.txt")));
      for(int i = 0; i<1000; i++)
      {
         Employee e = new Employee(i);
         System.out.println(e.toString());
      }
   }
}