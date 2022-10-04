import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in); //Input handling
        final int n = in.nextInt();
        NavigableSet<Integer> tempSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            tempSet.add(in.nextInt());
        }
        in.close();

        if(tempSet.isEmpty()){ //Empty set, could be handled differently but meh
            System.out.println(0);
        }else{ //Calculating temp closest to 0
            Integer ceiling = tempSet.ceiling(0); //temp above or equal closest to zero
                                                    //we need to check for nullptr
            int ceilingForComp = ceiling != null ? ceiling : Integer.MAX_VALUE; //Max value is far above max temp input
            Integer floor = tempSet.floor(0); //temp lower or equal closest to zero
            int floorForComp = floor != null ? floor : Integer.MAX_VALUE;
            System.out.println(
                Math.abs(ceilingForComp) <= Math.abs(floorForComp) ?
                ceilingForComp : floorForComp //if both absolute are equals then the 
                                              //only one that may be positive is the ceiling
            );
        }
    }
}
