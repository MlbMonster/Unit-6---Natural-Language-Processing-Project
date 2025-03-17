import java.util.ArrayList;
import java.util.Scanner;

/**
 * Javadoc example
 * @param parameter1 the first parameter
 * @return what is returned from this method
 */
public class Translator {

  private ArrayList<String> English;
  private ArrayList<String> Spanish;
  

  public Translator() {
    createEnglishSpanishList();
  }

  public void createEnglishSpanishList() {
    ArrayList<String> allWords = FileReader.toStringList("English2Spanish.txt");
    English = new ArrayList<String>();
    Spanish = new ArrayList<String>();
    
    for (String line : allWords) {
      String[] words = line.split(",");
      English.add(words[0]);
      Spanish.add(words[1]);
    }
  }

  public String translateSentence(String sentence) {
    // 1. Split sentence up in to words
    String[] words = sentence.split(" ");
        
    // 2. Remove any period or commas
    String[] cleanedWords = removeTailPeriodOrComma(words);
    
    for (int i = 0; i < cleanedWords.length; i++) {
      String currentWord = cleanedWords[i];
      int wordIndex = findEnglishWordIndex(currentWord);
      if (wordIndex != -1) {
        // use i when refering to the index in the users sentence
        // use wordIndex when refering to the index in the dictionary
        cleanedWords[i] = Spanish.get(wordIndex);
      }
      else {
                System.out.println("Sorry, we don't have this word in our documents.");
      }
    }
    return String.join(" ", cleanedWords);
  }

  public String[] removeTailPeriodOrComma(String[] words) {
    // 1. Traverse the words word list
    for (int i = 0; i < words.length; i++) {
      int period = words[i].indexOf(".");
      int comma = words[i].indexOf(",");
      
      // 2. If period is NOT -1, there is a period that needs to be removed

      // 3. Get a substring from 0 to period

      // 4. Replace substring with word[i];

      // 2. ELSE If comma is NOT -1, there is a comma that needs to be removed

      // 3. Get a substring from 0 to comma

      // 4. Replace substring with word[i];
      
    }
    
    return words;
  }

  public int findEnglishWordIndex(String word) {
    // 1. Iterate over the enlish ArrayList (INDEX FOR-LOP)

    // 2. Get the current enghish word

    for(int i = 0; i < English.size(); i++){
 if(English.get(i).compareTo(word) == 0){
   return i;
 }  
}
    // 3. If the current english word equals the word parameter

    // 4. Return the index (i)

    // 5. If not found, return -1
    return -1;
  }

  /**
   * Starts the app and gets user input
   */
  public void prompt() {
    Scanner input = new Scanner(System.in);

    System.out.println("Say a word in English");
    
    String Eng = input.nextLine();
    
    System.out.println("\nTranslating...");
    
    String SpanishSen = translateSentence(Eng);
    
    printSummary(SpanishSen);

    input.close();
  }


  /**
   * Prints the summary of our NLP project
   */
  public void printSummary(String sentence) {
    System.out.println("\nSpanish Sentence: ");
    System.out.println(sentence);
    // System.out.println(English);

  }

}