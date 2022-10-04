import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        try(Scanner in = new Scanner(System.in)){
            final int N = in.nextInt(); // Number of elements which make up the association table.
            final int Q = in.nextInt(); // Number Q of file names to be analyzed.

            Map<String, String> extensionToMimeMap = new HashMap<>();
            for (int i = 0; i < N; i++) {
                extensionToMimeMap.put(in.next().toUpperCase(), in.next());
            }
            in.nextLine();
            for (int i = 0; i < Q; i++) {
                final String FNAME = in.nextLine(); // One file name per line.
                final int indexOfLastDot = FNAME.lastIndexOf('.');
                if(indexOfLastDot != -1 && indexOfLastDot < FNAME.length()){
                    String mime = extensionToMimeMap.get(
                        FNAME.substring(indexOfLastDot + 1).toUpperCase()
                        );
                    if(mime != null){//evil null value
                        System.out.println(mime);
                        continue; //Avoid printing "UNKNOWN"
                    }
                }
                System.out.println("UNKNOWN");
            }
        }
    }
}
