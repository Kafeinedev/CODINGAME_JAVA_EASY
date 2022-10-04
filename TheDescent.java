import java.util.*;
import java.io.*;
import java.math.*;

class Player {

    public static void main(String args[]) {
        try(Scanner in = new Scanner(System.in)){
            // game loop
            while (true) {
                int target = 0;
                int targetHeight = Integer.MIN_VALUE;
                for (int i = 0; i < 8; i++) {
                    int mountainH = in.nextInt(); // represents the height of one mountain.
                    if(mountainH > targetHeight){
                        target = i;
                        targetHeight = mountainH;
                    }
                }
                System.out.println(target); // The index of the mountain to fire on.
            }
        }
    }
}
