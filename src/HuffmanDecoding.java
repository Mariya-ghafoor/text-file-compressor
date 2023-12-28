import java.util.List;

public class HuffmanDecoding {

  String encodedString;
  HuffmanNode root;
  String text;


  public HuffmanDecoding(String encodedString, HuffmanNode root){
    this.encodedString = encodedString;
    this.root = root;

    generateText(encodedString, root, "");

  }

  private void generateText(String encodedString, HuffmanNode currentNode, String text){

    //char[] letter = encodedString.toCharArray();
    String[] binaryCodesArr = encodedString.split("");
    
    for(int i=0; i<binaryCodesArr.length; i++){
      System.out.println("Current node is: "+currentNode.value);
      System.out.println("binarycode= "+binaryCodesArr[i]);

      if(currentNode != null){
        System.out.println("Inside the loop. Final String is: "+text);
        if(binaryCodesArr[i].equals("0")){
          System.out.println("Going to left");
        currentNode = currentNode.left;

      }
      else if (binaryCodesArr[i].equals("1")) {
        System.out.println("Going to right");
        currentNode = currentNode.right; 
      }

      //if there are no nodes to the left and right it means we are at the leaf node
      if(currentNode != null && currentNode.left == null && currentNode.right == null){
        System.out.println("Found the character! "+currentNode.ch);
        text += currentNode.ch;
        currentNode = root;
      }

      }
      

    }
    this.text = text;


  }
  
}
