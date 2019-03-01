package BookSearchEngine;
import java.util.Scanner;
import java.io.File;

/**
 * Program made to search keywords in the entire text of Alice in Wonderland.
 * 
 * @author James Clark
 * @version 12/15/16
 */
public class BookSearchEngine {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        //inputs the Alice in Wonderland text
        File file = new File("alice.txt");
        Scanner fileInput = new Scanner(file);
        
        //Asks for keyword(s) to search for
        Scanner input = new Scanner(System.in);
        System.out.print("Enter search word: ");
        String search = input.nextLine();
        System.out.println();
        
        //line counter
        int lineNum = 0;
        //Text of current line
        String line;
        //Current chapter
        String chapter = null;
        //has the chapter been printed?
        boolean newChap = false;
        
        //while there are more lines to read
        while (fileInput.hasNextLine()){
            //increase line counter
            lineNum++;
            //read next line
            line = fileInput.nextLine();
            
            //if the line starts with "CHAPTER"
            if (line.startsWith("CHAPTER")){
                //save the line
                chapter = line;
                //indicate new chapter
                newChap = true;
                //go to next line
                continue;
            }
            
            //if the current line contains the search word
            if (lineContainsWord(line, search)){
                
                //if there is a new chapter, print it
                if (newChap){
                    System.out.println();
                    System.out.println(chapter);
                    newChap = false;
                    
                }
                //Print current line number, and line text.
                System.out.println(lineNum + " " + line);
            }
            
        }
        
        
        
    }

    /**
     * Split a line of text into an array of words. First, non-letter characters
     * are replaced with spaces. Then, the line is split into words using space
     * as the delimiter.
     *
     * @param line the line of text to split
     * @return the array of words
     */
    public static String[] getWords(String line) {
        //initialize StringBuilder
        StringBuilder sb = new StringBuilder(line);
        
        //If a character in the String is not a letter or number, replace with a space
        for (int i = 0; i < sb.length();i++ ){
            if (!Character.isLetter(sb.charAt(i)) && !Character.isDigit(sb.charAt(i))){
                sb.setCharAt(i, ' ');
            }
        }
        //Convert StringBuiler to a String
        String process = sb.toString();
        //Conver String into tokens
        String [] tokens = process.split(" ");
        
        return tokens;
    }

    /**
     * Search a line of text for the given word, ignoring letter case. First,
     * the line is split into separate words. Then, the search word is compared
     * with each word in the line. If any of the words in the line match the
     * search word, ignoring case, return true. Otherwise, return false.
     *
     * @param line the line of text to search
     * @param searchWord the word to search for
     * @return true if the line contains the search word; false otherwise
     */
    public static boolean lineContainsWord(String line, String searchWord){
        //Initialize tokens of input "line"
        String [] words = getWords(line);
        
        //is match?
        boolean match = false;
        
            //if the search word matches at least one word in line, match = true
            for(int i = 0; i < words.length; i++){
                if (searchWord.equalsIgnoreCase(words[i])){
                     match = true;
                    break;
                }
              }
            return match;
    }
}
