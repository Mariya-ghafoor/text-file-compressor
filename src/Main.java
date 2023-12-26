import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws Exception {

    try{
      FileInputStream input = new FileInputStream("input.txt");
      System.out.println("Data in the file: ");

      //Reads the first byte
      int i = input.read();

      char currentLetter = (char)Character.toLowerCase (i);

      //List to store count
      ArrayList<Integer> inputFreqList = new ArrayList<>();
      

      //List to store characters
      ArrayList<Character> inputCharList = new ArrayList<>();
      

      //Hashmap to store count of each letter
      HashMap<Character,Integer> letterMap = new HashMap<>();
      
      //Run the loop until the end of file
      while(i != -1){

      //Count frequencies of only characters from a to z
      if(currentLetter>= 'a' && currentLetter<= 'z') {
        // System.out.println("value of i= "+i);
        // System.out.println(("current letter "+currentLetter));

        //if key do not exists, put 1 as value otherwise sum 1 to the value linked to key
        letterMap.merge(currentLetter, 1, Integer::sum);
        
      }
      //Reads the next byte from the file
        i = input.read();
        currentLetter = (char)Character.toLowerCase (i);
    }
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
      // Printing hashmap. keySet() returns a set of keys from your hash map
      //   for (Character ch: letterMap.keySet()) {
      //     String key = ch.toString();
      //     String value = letterMap.get(ch).toString();
      //     System.out.println("Sorted Hashmap");
      //     System.out.println(key + " " + value);
      // }
    }
    catch(Exception e){
      e.getStackTrace();
    }


  }
  
}
