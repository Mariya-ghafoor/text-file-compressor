import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;


public class App {

    // THE PROGRAM CONVERTS THE TEXT IN A FILE INTO HUFFMAN CODES. IT THEN SAVES THE CODES INTO A FILE. 
    // IT ALSO DECODES THE CODES BACK TO STRING OF TEXT
    public static void main(String[] args) throws Exception {

        //Reading file to get lists of characters and their frequencies plus number of letters 
        FileUtils myFileUtils = new FileUtils();
        ArrayList<Character> inputCharList = myFileUtils.getInputCharList();
        ArrayList<Integer> inputFreqList = myFileUtils.getInputFreqList();
        int numOfLetters = myFileUtils.getNumOfLetters();
        ArrayList<Character> textList = myFileUtils.getTextList();

        //Send the above for encoding

        HuffmanCoding hc = new HuffmanCoding(inputCharList, inputFreqList, numOfLetters);

        HashMap<Character,String> codeMap = hc.codeMap;


        // * WE HAVE TO CONVERT THE TREE INTO BINARY DIGITS TO BE STORED IN A FILE. *THE METHOD 'buildTreeInBits' IS NOT WORKING CORRECTLY*. 
        // THE ALTERNATIVE IS TO SERIALIZE (CONVERT TO BITS) AND DESERIALIZE CODEMAP USING JAVA SERIALIZATION:  
        // https://www.tutorialspoint.com/java/java_serialization.html 

        //System.out.println("Huffman tree: "+hc.buildTreeInBits(hc.root,""));

        //Send map of codes and characters along with the original text to convert into a string of binary digits
        EncodeTextFile ef = new EncodeTextFile(codeMap, textList, "");

        //System.out.println("Encoded text: "+ef.encodedText);

        //Write the String into a file
        // Creates a FileWriter
        FileWriter encodedfile = new FileWriter("encoded.txt");

        // // Creates a PrintWriter
        PrintWriter output = new PrintWriter(encodedfile);

        try {
            output.println(hc.root+ef.encodedText);
        }
        catch(Exception e) {
            e.getStackTrace();
          }

        output.close();

        // **** HUFFMAN DECODING ****
        

        //send the encoded text (binary digits) along with Huffman root node (IN REAL LIFE WE NEED A WAY TO ATORE THIS TREE IN THE ENCODED FILE) for decoding

        HuffmanDecoding hd = new HuffmanDecoding(ef.encodedText, hc.root);

        String finalDecodedString = hd.text;

        //System.out.println("Final decoded text: "+finalDecodedString);

        // We can write the decoded text into a file
        //Write the String into a file
        // Creates a FileWriter
        FileWriter decodedFile = new FileWriter("output.txt");

        // // Creates a PrintWriter
        PrintWriter outputFile = new PrintWriter(decodedFile);

        try {
            outputFile.println(finalDecodedString);
        }
        catch(Exception e) {
            e.getStackTrace();
          }

        outputFile.close();

        


    }
}
