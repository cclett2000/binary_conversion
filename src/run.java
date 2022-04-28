////////////////////////////////////////////////////////
// name: run.java
// function: executable class
// programmer: Charles Lett Jr.
// Date created: 4/27/22
////////////////////////////////////////////////////////

import java.util.Scanner;

public class run {
    // show debug info
    static boolean ENABLE_DEBUGGING = false;

    public static void main(String[] args){
        int sel;
        int num = 420;
        String binary;

        decimal2binary d2b = new decimal2binary();
        binary2decimal b2d = new binary2decimal();
        Scanner input = new Scanner(System.in);

        System.out.print("""
                Select Conversion Type:
                \t1.) Decimal to Binary
                \t2.) Binary to Decimal
                """);
        System.out.print(">>> ");
        sel = input.nextInt();

        while (sel < 1 || sel > 2){
            System.out.println("ERROR -- Selection not available");
            System.out.print("""
                Select Conversion Type:
                \t1.) Decimal to Binary
                \t2.) Binary to Decimal
                """);
            System.out.print(">>> ");
            sel = input.nextInt();
        }

        if(sel == 1){
            System.out.print("Enter a number to convert: ");
            num = input.nextInt();

            d2b.run(num, ENABLE_DEBUGGING);
        }

        if(sel == 2){
            System.out.print("Enter a binary string to convert: ");
            binary = input.next();

            b2d.run(binary, ENABLE_DEBUGGING);
        }

    }
}
