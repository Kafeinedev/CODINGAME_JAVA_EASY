import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        final StringBuilder bitMessage = new StringBuilder();

        try(Scanner in = new Scanner(System.in)){
            final String MESSAGE = in.nextLine();
            for(int i = 0; i < MESSAGE.length(); ++i){
                for(long j = (1 << 6); j >= 1; j >>= 1){//Just use->Integer.toBinaryString(MESSAGE.charAt(i));
                    bitMessage.append(                  //I'm doing this for fun not because its efficient
                        ((MESSAGE.charAt(i) & j) != 0) ?
                        '1' : '0'
                    );
                }
            }
        }

        final StringBuilder solution = new StringBuilder();
        String currentBitMessage = bitMessage.toString();
        while(currentBitMessage.length() > 0){
            char current = currentBitMessage.charAt(0); //Character in front
            solution.append(current == '1' ? "0 " : "00 ");
            //Position of next char
            int indexOfNext = currentBitMessage.indexOf(current == '1' ? '0' : '1');
            //Number of times the character in front is repeated
            int repetition;
            if(indexOfNext != -1){
                repetition = indexOfNext;
                currentBitMessage = currentBitMessage.substring(indexOfNext);
            }else{
                repetition = currentBitMessage.length();
                currentBitMessage = "";
            } 
            solution.append("0".repeat(repetition));
            solution.append(' ');
        }
        System.out.println(solution.deleteCharAt(solution.length() - 1));
    }
}
