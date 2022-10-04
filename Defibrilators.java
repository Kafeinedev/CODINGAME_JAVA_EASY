import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    public static double distance(final double LON_A, final double LAT_A,
     final double LON_B, final double LAT_B){
        final double X = (LON_B - LON_A) * Math.cos((LAT_A + LAT_B) / 2);
        final double Y = LAT_B - LAT_A;
        return Math.sqrt(X * X + Y * Y) * 6371;
    }

    public static void main(String args[]) {
        try(Scanner in = new Scanner(System.in)){
            final double USER_LON = Double.parseDouble(in.next().replace(',', '.'));
            final double USER_LAT = Double.parseDouble(in.next().replace(',', '.'));
            int N = in.nextInt();
            if (in.hasNextLine()) {
                in.nextLine();
            }

            String solution = "";
            double userDistance = Double.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                String[] DEFIB = in.nextLine().split(";");
                final double DEFIB_LON = Double.parseDouble(DEFIB[4].replace(',', '.'));
                final double DEFIB_LAT = Double.parseDouble(DEFIB[5].replace(',', '.'));

                double distance = distance(USER_LON, USER_LAT, DEFIB_LON, DEFIB_LAT);
                if(distance < userDistance){
                    userDistance = distance;
                    solution = DEFIB[1];
                }
            }
            System.out.println(solution);
        }
    }
}
