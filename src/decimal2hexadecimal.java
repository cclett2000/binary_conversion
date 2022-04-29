////////////////////////////////////////////////////////
// name: decimal2hexadecimal.java
// function: convert decimal to hexadecimal
// programmer: Charles Lett Jr.
// last modified: 4/29/22
// reference: https://www.permadi.com/tutorial/numDecToHex/
////////////////////////////////////////////////////////

import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;

public class decimal2hexadecimal {
    public void run(int number, boolean debug){
        converter(number, debug);
    }

    private void converter(int number, boolean debug){
        int num_disp = number;
        int remainder = 0;
        ArrayList<Character> hexadecimal = new ArrayList<>();

        if(debug) System.out.println("\n\nremainder: " + remainder + ", number: " + number);
        while (number > 0){
            remainder = number % 16;
            number /= 16;
            hexadecimal.add(hexa_dict().get(remainder));

            if(debug) System.out.println("remainder: " + remainder + ", number: " + number);
        }

        Collections.reverse(hexadecimal);

        // display arraylist as string
        System.out.print("\n\nNumber: " + num_disp + "\nHexadecimal: ");
        for (int i = 0; i < hexadecimal.size(); i++){
            System.out.print(hexadecimal.get(i));
        }
        System.out.println();

    }

    // create dictionary for hexadecimal
    private HashMap<Integer, Character> hexa_dict(){
        HashMap<Integer, Character> dict = new HashMap<>();
        dict.put(0, '0');
        dict.put(1, '1');
        dict.put(2, '2');
        dict.put(3, '3');
        dict.put(4, '4');
        dict.put(5, '5');
        dict.put(6, '6');
        dict.put(7, '7');
        dict.put(8, '8');
        dict.put(9, '9');
        dict.put(10, 'A');
        dict.put(11, 'B');
        dict.put(12, 'C');
        dict.put(13, 'D');
        dict.put(14, 'E');
        dict.put(15, 'F');

        return dict;
    }
}
