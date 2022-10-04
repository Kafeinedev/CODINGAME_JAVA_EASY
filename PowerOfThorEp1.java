import java.util.*;
import java.io.*;
import java.math.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt();
        int lightY = in.nextInt();
        int thorX = in.nextInt();
        int thorY = in.nextInt();

        // game loop
        while (in.nextInt() > 0) {
            String out = "";
            if(thorY > lightY){
                out += 'N'; --thorY;
            }else if(thorY < lightY){
                out += 'S'; ++thorY;
            }
            if(thorX > lightX){
                out += 'W'; --thorX;
            }else if(thorX < lightX){
                out += 'E'; ++thorX;
            }
            System.out.println(out);
        }
        in.close();
    }
}
