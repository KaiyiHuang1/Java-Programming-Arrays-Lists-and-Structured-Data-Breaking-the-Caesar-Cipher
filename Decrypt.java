 
/**
 * 在这里给出对�?? Decrypt 的描述�??
 * 
 * @作�?�（你的名字�??
 * @版本（一个版本号或�?�一个日期）
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

 

public class Decrypt {
    public int[] countLetters(String encrypted){
        String alph = "abcdefghijklmnoprstuvwxyz";
        int[] counts = new int[26];
        for(int  k = 0; k < encrypted.length(); k++){
            char ch = Character.toLowerCase(encrypted.charAt(k));
            int dex = alph.indexOf(ch);
            if(dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    }
    
    public int maxIndex(int[] freqs){
        int currMax = 0;
        int MaxDex = 0;
        for(int k = 0; k < 26; k++){
            if(k == 0){
                MaxDex = k;
                currMax = freqs[k];
            }
            else{
                if(freqs[k] > currMax){
                MaxDex = k;
                currMax = freqs[k];
            }
            }
        }
        System.out.println("MaxDex: " + MaxDex);
        return MaxDex;
    }
    
    public String decrypt(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if(maxDex < 4){
            dkey = 26 - (4 - maxDex);
        }
        return cc.encrypt(encrypted, 26 - dkey);
    }
    
    public void testDecrypt(){
        CaesarCipher cc = new CaesarCipher();
        String target = "Just a test string with lots of eeeeeeeeeeeeeeeees";
        System.out.println("Original Message: " + target);
        String encrypted = cc.encrypt(target, 5);
        System.out.println("Encrypted Message: " + encrypted);
        String decrypted = decrypt(encrypted);
        System.out.println("Decrypted Message: " + decrypted);
    }

}
