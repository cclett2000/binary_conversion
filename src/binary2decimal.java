////////////////////////////////////////////////////////
// name: binary2decimal.java
// function: convert decimal to binary
// programmer: Charles Lett Jr.
// Date created: 4/27/22
////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.Collections;

public class binary2decimal {
    public void run(String binary, boolean enable_debug, int conversion_type){
        if (conversion_type == 0) converter(binary, enable_debug);
        if (conversion_type == 1) converter_substring(binary, enable_debug);
    }

    private void converter(String binary, boolean enable_debug){
        int sum = 0;
        ArrayList<Integer> bin_num = new ArrayList<>();

        // populate list of 2N
        for (int n = 0; n < binary.length(); n++){
            bin_num.add((int) Math.pow(2, n));
        }
        Collections.reverse(bin_num);

        // assign binary to array
        char[] bin_arr = binary.toCharArray();

        // do conversion
        for (int i = 0; i < bin_arr.length; i++){
            if (bin_arr[i] == '1'){
                if (enable_debug) System.out.println("[TICK!] " + bin_arr[i] + "||" + bin_num.get(i));
                sum += bin_num.get(i);
            }
            else if (enable_debug) System.out.println("\t\t" + bin_arr[i] + "||" + bin_num.get(i));
        }

        System.out.println("\nBinary: " + binary);
        System.out.println("Number: " + sum + "\n");
    }

    private void converter_substring(String binary, boolean enable_debug){
        int sum = 0;
        String bin_substring = binary.substring(0, 1);
        ArrayList<Integer> bin_num = new ArrayList<>();

        // populate list of 2N
        for (int n = 0; n < binary.length(); n++){
            bin_num.add((int) Math.pow(2, n));
        }
        Collections.reverse(bin_num);

        // do conversion
        for (int i = 0; i < binary.length(); i++){
            if (binary.substring(i, i+1).equals("1")){
                if (enable_debug) System.out.println("[TICK!] " + binary.substring(i, i+1) + "||" + bin_num.get(i));
                sum += bin_num.get(i);
            }
            else if (enable_debug) System.out.println("\t\t" + binary.substring(i, i+1) + "||" + bin_num.get(i));
        }

        System.out.println("\nBinary: " + binary);
        System.out.println("Number: " + sum + "\n");
    }
}
