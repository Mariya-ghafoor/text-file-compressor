# TEXT FILE COMPRESSION USING HUFFMAN CODING

- This project has two parts:
  - Read a text file and encode the text using Huffman coding. Save the result into a file.
  - Read the coded file and decode the file and convert back to text. Save in the output file.

## HUFFMAN CODING

- It is a lossless data compression technique where letters having higher frequencies of appearance are assigned smaller number of bits which results in reducing the overall size of the file.
- My blog post on Huffman coding has more details:

## Purpose

- The purpose of the project was to build a real-life tool in order to understand the working of Java better

## Dependecies

- The project has no external dependencies

## Features

- The program uses Java classes to implement various functioanlities in the following order:

  - App class provides the main staring point and initializes other classes

  - FileUtils class does the following:

    - Read an external file
    - Count the number of letters
    - Count the frequencies of letters
    - Creates a HashMap of the letters and their frequencies

  - HuffmanCoding class creates the Huffman tree and then creates a Hashmap that contains characters and codes as keys and values respectively.

  - EncodeTextFile takes the Huffman tree and Hashmap along with the original text and creates a string of encoded bits.

  - HuffmanDecoding class takes the encoded text along with Huffman tree to then decode it and recreate the original data.

- The encoded string is stored in a file called 'encoded.txt' (we can give it any file extension like hff for Huffman) while the decoded text is stored in 'output.txt'

## Future Goals

- Serialize Hashmap that contains Huffman codes and store in the coded file and then deserialize to decode (refer to: https://www.tutorialspoint.com/java/java_serialization.html)
- Find ways to make it faster
