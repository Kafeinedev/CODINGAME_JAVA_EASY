import java.util.*;
import java.io.*;
import java.math.*;

class Player {

    public static void main(String args[]) {
        try(Scanner in = new Scanner(System.in)){
        int surfaceN = in.nextInt(); // the number of points used to draw the surface of Mars.
            for (int i = 0; i < surfaceN; i++) {
                int landX = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
                int landY = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
            }

            final float TARGET_SPEED = -37.0f;
            final float KP = 1.0f;
            final float KI = 1.0f;
            float integral = 0.0f;
            float prevError = 0.0f;
            while (true) {
                int X = in.nextInt();
                int Y = in.nextInt();
                int hSpeed = in.nextInt(); // the horizontal speed (in m/s), can be negative.
                final float SPEED = in.nextFloat(); // the vertical speed (in m/s), can be negative.
                int fuel = in.nextInt(); // the quantity of remaining fuel in liters.
                int rotate = in.nextInt(); // the rotation angle in degrees (-90 to 90).
                int power = in.nextInt(); // the thrust power (0 to 4).

                //This is a first try at a Proportionnal Integral controler while this works well enough
                //it could use some refining
              
                //Proportionnal
                float error = TARGET_SPEED - SPEED;
                float proportionnal = KP * error;

                //Integral
                integral += 0.5f * KI * (error  - prevError);
                
                float output = proportionnal + integral;
                prevError = error;

                //Clamping output
                if(output < 0){
                    output = 0.0f;
                }else if(output > 4){
                    output = 4.0f;
                }
                
                System.out.println("0 " + Math.round(output));
            }
        }
    }
}
