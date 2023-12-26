import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileUtils {

  private ArrayList<Character> inputCharList;
  private ArrayList<Integer> inputFreqList;
  private int numOfLetters;

  public FileUtils(){
    try{
      //File myFile = new File("/Les-Misérables.txt");
      //System.out.println("File exists: "+myFile.isDirectory());
      FileInputStream input = new FileInputStream("Les-Misérables.txt");
      //FileInputStream input = new FileInputStream("test.txt");

      
      System.out.println("Data in the file: ");

      //Reads the first byte
      int i = input.read();
      //System.out.println("Value of i= "+i);

      //char currentLetter = (char)Character.toLowerCase (i);
      char currentLetter = (char)(i);

      //List to store count
      ArrayList<Integer> inputFreqList = new ArrayList<>();
      

      //List to store characters
      ArrayList<Character> inputCharList = new ArrayList<>();
      

      //Hashmap to store count of each letter
      HashMap<Character,Integer> letterMap = new HashMap<>();
      
      //Run the loop until the end of file
      while(i != -1){

      //if key does not exist, put 1 as value otherwise sum 1 to the value linked to key
      letterMap.merge(currentLetter, 1, Integer::sum);

      //Reads the next byte from the file
        i = input.read();
        //currentLetter = (char)Character.toLowerCase (i);
        currentLetter = (char)(i);
    }
    System.out.println(letterMap);
    input.close();

    //Sorting the hashmap by value and storing the sorted keys and values in separate lists
    letterMap.entrySet().stream()
      .sorted((k1, k2) -> k1.getValue().compareTo(k2.getValue()))
      .forEach(k -> {
        inputCharList.add(k.getKey());
        inputFreqList.add(k.getValue());
      } );
      
      System.out.println("Character list: "+inputCharList);
      System.out.println("Frequency list: "+inputFreqList);

      this.inputCharList = inputCharList;
      this.inputFreqList = inputFreqList;
      this.numOfLetters = inputCharList.size();
    }
    catch(Exception e){
      e.getStackTrace();
    }
  }
  public ArrayList<Character> getInputCharList(){
    return this.inputCharList;
  }

  public ArrayList<Integer> getInputFreqList(){
    return this.inputFreqList;

  }

  public int getNumOfLetters(){
    return this.numOfLetters;
    
  }
  
}
