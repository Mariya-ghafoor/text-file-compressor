import java.io.FileInputStream;

public class FileTest {
  public static void main(String[] args) throws Exception {

    try{
      FileInputStream input = new FileInputStream("input.txt");
      System.out.println("Data in the file: ");

      //Reads the first byte
      int i = input.read();

      //Array to store count
      int[] inputCharFrequency = new int[26];

      while(i != -1){
        //System.out.println((char)i);
        int currentLetter = Character.toLowerCase (i);
        if(currentLetter>='a' && currentLetter<='z'){
          System.out.println("Current letter: "+(char)currentLetter);
          inputCharFrequency[i-'a']++; 
        }
        //Reads the next byte from the file
        i = input.read();
      }
      
      input.close();
      System.out.println("char count: "+inputCharFrequency);

    }
    catch(Exception e){
      e.getStackTrace();
    }


  }
  
}
