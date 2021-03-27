
/**
 * 在这里给出对类 WordLengths 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class WordLengths {
    public String[] getCommon(FileResource resource){
        String[] common = new String[20];
        int index = 0;
        for(String s: resource.words()){
            common[index] = s;
            index += 1;
        }
        return common;
    }
    
    public int indexOf(String[] list, String word){
        for(int k=0; k<list.length; k++){
            if(list[k].equals(word)){
                return k;
            }
        }
        return -1;
    }
    
    public void countWords(FileResource resource, String[] common, int[] count){
        for(String word: resource.words()){
            word = word.toLowerCase();
            int index = indexOf(common, word);
            if(index != -1){
                count[index] += 1;
            }
        }
    }
    
    public int wordLength(String word){
        int length = word.length();
        int countHead = 0;
        int countTail = length;
        while(!Character.isLetter(word.charAt(countHead))){
            countHead ++;
        }
        while(!Character.isLetter(word.charAt(countTail-1))){
            countTail--;
        }
        return countTail - countHead;
    }
    
    public void countWordLengths(FileResource resource, int[] counts){

        for(String s : resource.words()) {

            char chFirst = s.charAt(0);
            char chLast = s.charAt(s.length() - 1);

                if (!(!Character.isLetter(s.charAt(0)) && s.length() == 1)) {
                    chLast = s.charAt(s.length() - 1);
                    int wordLength = s.length();
                    if (!Character.isLetter(chFirst)) {
                        wordLength = wordLength - 1;
                    }
                    if (!Character.isLetter(chLast)) {
                        wordLength = wordLength - 1;
                    }
                    // todo: was mistake
                    if (wordLength <= 30 && wordLength >= 0){
                        counts[wordLength] += 1;
                    }
                    else if (wordLength > 30){
                        counts[30] += 1;
                    }
                    else {
                        counts[0] +=1;
                    }
                    System.out.println(wordLength + " " + s);
                }
        }

        System.out.println("Kaiyi's programm: Note this file has words that are:");
        int countAllWords = 0;
        for (int k = 0; k < counts.length; k++) {
            // todo add condition of non-zero printing
            if (counts[k] > 0) {
                System.out.println(counts[k] + " words of length " + k);
                // todo: add countAllWords
                countAllWords += counts[k];
            }
        }
        System.out.println("countAllWords = " + countAllWords);
    }
    
    public void testCountWordLengths(){
        FileResource resource= new FileResource();
        int[] counts = new int[31];
        countWordLengths(resource, counts);
    }

}
