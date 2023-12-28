import java.util.ArrayList;
import java.util.HashMap;

public class EncodeTextFile {

  //This class will encode the whole text file from the codes receieved from HuffmanCoding class and text list receieved from FileUtils class

  HashMap<Character,String> codeMap;
  ArrayList<Character> textList;
  String encodedText;

  public EncodeTextFile(HashMap<Character,String> codeMap, ArrayList<Character> textList, String encodedText){
    
    for(int i=0; i<textList.size(); i++){
      char letter = textList.get(i);
      encodedText += codeMap.get(letter);
    }
    this.encodedText = encodedText;


  }
  
}
