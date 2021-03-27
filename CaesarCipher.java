
/**
 * 在这里给出对类 CaesarCipher 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class CaesarCipher extends Decrypt {
    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
        String shiftAlphabetUpper = alphabetUpper.substring(key)+ alphabetUpper.substring(0, key);
        String shiftAlphabetLower = alphabetLower.substring(key)+ alphabetLower.substring(0, key);
        for(int i = 0; i < encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            if(Character.isUpperCase(currChar)){
            int idx =alphabetUpper.indexOf(currChar);
            if(idx != -1){
                char newChar = shiftAlphabetUpper.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
        }else{
            int idx =alphabetLower.indexOf(currChar);
            if(idx != -1){
                char newChar = shiftAlphabetLower.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
        }
        }
        return encrypted.toString();
    }
    
    public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder encrypted = new StringBuilder(input);
        for(int i = 0; i < encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            if(i%2 == 0){
                char newChar = encrypt(String.valueOf(currChar), key1).charAt(0);
                encrypted.setCharAt(i, newChar);
            }else{
                char newChar = encrypt(String.valueOf(currChar), key2).charAt(0);
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }
    
    public void testCaesar(){
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        int key1 = 23;
        int key2 = 17;
        String encrypted = encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15);
        System.out.println("key is 15"  + "\n" + encrypted);
        String encrypted2 = encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21);
        System.out.println("key are 8 and 21" + "\n" + encrypted2);
    }

}

