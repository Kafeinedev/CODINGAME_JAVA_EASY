import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {

        try(Scanner in = new Scanner(System.in)){
            final int L = in.nextInt();
            final int H = in.nextInt();
            if (in.hasNextLine()) {
                in.nextLine();
            }
            final String TEXT = in.nextLine().toUpperCase();
            StringBuilder solution = new StringBuilder();

            while(in.hasNextLine()){
                final String ART_LINE = in.nextLine();
                for(int i = 0; i < TEXT.length(); ++i){
                    final char C = TEXT.charAt(i);
                    if(C >= 'A' && C <= 'Z'){
                        solution.append(ART_LINE.substring((C - 'A')*L, (C + 1 - 'A')*L));
                    }else{
                        solution.append(ART_LINE.substring(26*L));
                    }
                }
                System.out.println(solution);
                solution.setLength(0); //Clearing current line
            }
        }
    }
}
