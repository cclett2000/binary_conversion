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
    static int B2D_Type = 1;                    // 0 == char array method, 1 == substring method

    public static void main(String[] args){
        int sel = 3;
        int num = 1128;
        String binary;

        decimal2binary d2b = new decimal2binary();
        binary2decimal b2d = new binary2decimal();
        decimal2hexadecimal d2hd = new decimal2hexadecimal();
        Scanner input = new Scanner(System.in);

        System.out.print("""
                Select Conversion Type:
                \t1.) Decimal to Binary
                \t2.) Binary to Decimal
                \t3.) ***Bonus!*** Decimal to Hexadecimal
                """);
        System.out.print(">>> ");
        sel = input.nextInt();

        while (sel < 1 || sel > 3){
            System.out.println("ERROR -- Selection not available");
            System.out.print("""
                Select Conversion Type:
                \t1.) Decimal to Binary
                \t2.) Binary to Decimal
                \t3.) ***Bonus!*** Decimal to Hexadecimal
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

            b2d.run(binary, ENABLE_DEBUGGING, B2D_Type);
        }

        if(sel == 3){
            System.out.print("Enter a number to convert to hexadecimal: ");
            num = input.nextInt();

            d2hd.run(num, ENABLE_DEBUGGING);
        }

    }
}
