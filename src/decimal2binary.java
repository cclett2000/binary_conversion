////////////////////////////////////////////////////////
// name: decimal2binary.java
// function: convert number to binary
// programmer: Charles Lett Jr.
// Date created: 4/27/22
////////////////////////////////////////////////////////

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class decimal2binary {

    public void run(int num, boolean enable_debug){
        converter(num, enable_debug);
    }

    private void converter(int num, boolean ENABLE_DEBUG){
        int num_disp;                                           // stores copy of num for display later
        int num_threshold = 0;
        int exp = 0;
        ArrayList<Integer> binary_num = new ArrayList<>();

        num_disp = num;

        // populate number array
        while (num > num_threshold){
            double pow_temp = Math.pow(2, exp);
            binary_num.add((int) pow_temp);
            num_threshold = (int) pow_temp;
            exp++;
        }

        // reverse list - binary format
        Collections.reverse(binary_num);

        // create array for binary
        int[] binary_bin = new int[binary_num.size()];

        if(ENABLE_DEBUG) {
            System.out.println("\nInput Number: " + num + ", Binary: 1111011 (for 123)");
            System.out.println(binary_num + " -- Size: " + binary_num.size());
            System.out.println(Arrays.toString(binary_bin) + " -- Size: " + binary_bin.length + "\n");
        }

        // calculations
        int list_pos = 0;
        while(list_pos < binary_num.size()){
            int weird_calc = num % binary_num.get(list_pos);

            // weirdly evil if/else statements; don't understand how I em got to work
            // 2N == binary_num <- arraylist

            // finalizer - if num == 1 & list_pos == 1 this means end of 2N list
            // sets list_pos to 2^N list size to ensure loop is broken
            if (num == 1 && binary_num.get(list_pos) == 1){
                binary_bin[list_pos] = 1;
                list_pos = binary_num.size();
            }

            // Tick if num equals value in 2N exactly; sets list_pos to 2N size to prevent garbsge loops
            else if (weird_calc == 0 && num == binary_num.get(list_pos)) {
                num -= binary_num.get(list_pos);
                binary_bin[list_pos] = 1;
                if (ENABLE_DEBUG) System.out.print("[TICK!] [" + binary_num.get(list_pos) + "], " + list_pos + ", Num before: " + num);
                list_pos = binary_num.size();
            }

            else if (weird_calc > 0) {
                // added if else increases accuracy
                if(num < binary_num.get(list_pos)) {
                    if (ENABLE_DEBUG) System.out.print("\t\t[" + binary_num.get(list_pos) + "], " + list_pos + ", Num before: " + num);
                }
                else {
                    num -= binary_num.get(list_pos);
                    binary_bin[list_pos] = 1;
                    if (ENABLE_DEBUG) System.out.print("[TICK!] [" + binary_num.get(list_pos) + "], " + list_pos + ", Num before: " + num);
                }
            }

            // if this repeats, broken loop
            if (ENABLE_DEBUG) System.out.print(" -- Num After: " + num + "\n");
            list_pos++;
        }

        if (ENABLE_DEBUG) {
            System.out.println("\n" + binary_num + " -- Size: " + binary_num.size());
            System.out.println(Arrays.toString(binary_bin) + " -- Size: " + binary_bin.length + "\n");
        }

        // cleaned up display
        System.out.println("\nNumber: " + num_disp);

        System.out.print("Binary: ");
        for(int i = 0; i < binary_bin.length; i++){
            if (i == binary_bin.length){
                System.out.print(binary_bin[i] + "\n");
            }

            else {
                System.out.print(binary_bin[i]);
            }
        }
        System.out.println();
    }
}
