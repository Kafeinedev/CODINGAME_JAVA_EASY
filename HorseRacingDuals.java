import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Integer> horsesList = new ArrayList<>(N);
        
        for (int i = 0; i < N; i++) {
            horsesList.add(in.nextInt());
        }
        in.close();

        horsesList.sort((a, b) -> {return Integer.compare(a, b);}); //Why is java so complex ?
        Iterator<Integer> horseIter = horsesList.iterator();
        int previousHorse = horseIter.next(); //there is at least 2 horses 
                                              //we do not need to check for empty
        int powerDiff = Integer.MAX_VALUE;
        while(horseIter.hasNext()){ //Navigating the rest of the list
            int currentHorse = horseIter.next();
            int currentDelta = currentHorse - previousHorse;
            if(currentDelta < powerDiff){
                powerDiff = currentDelta;
            }
            previousHorse = currentHorse; //Our current horse is the previous for the next one
        }

        System.out.println(powerDiff);
    }
}
