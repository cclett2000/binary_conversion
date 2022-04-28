////////////////////////////////////////////////////////
// name: binary2decimal.java
// function: convert decimal to binary
// programmer: Charles Lett Jr.
// Date created: 4/27/22
////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.Collections;

public class binary2decimal {
    public void run(String binary, boolean enable_debug){
        converter(binary, enable_debug);
    }

    private void converter(String binary, boolean enable_debug){
        int sum = 0;
        ArrayList<Integer> bin_num = new ArrayList<>();
        char[] bin_arr = new char[binary.length()];

        // populate list of 2N
        for (int n = 0; n < binary.length(); n++){
            bin_num.add((int) Math.pow(2, n));
        }
        Collections.reverse(bin_num);

        // assign binary to array
        bin_arr = binary.toCharArray();

        // do conversion
        for (int i = 0; i < bin_arr.length; i++){
            if (bin_arr[i] == '1'){
                if (enable_debug) System.out.println("[TICK!] " + bin_arr[i] + "||" + bin_num.get(i));
                sum += bin_num.get(i);
            }
            else if (enable_debug) System.out.println("\t\t" + bin_arr[i] + "||" + bin_num.get(i));
        }

        System.out.println("\nBinary: " + binary);
        System.out.println("Number: " + sum);
    }
}
