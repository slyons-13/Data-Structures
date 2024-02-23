import java.util.ArrayList;
import java.util.Scanner;

public class Array {

    public static void main(String[] args) {
        // instantiate Scanner
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> numList = new ArrayList<Double>(20);

        System.out.println("Enter up to 20 numbers or 99999 to quit: ");
        for (int i = 0; i < 20; i++) {
            // user enters a number
            double num = sc.nextDouble();
            if (num == 99999) {
                // prints error message if no numbers have been entered, breaks loop
                if (i == 0) {
                    System.out.println("Error: no numbers entered");
                    break;
                } else {
                    break;
                }
            } else {
                // add entered number to numList
                numList.add(num);
            }
        }

        //print list
        System.out.println(numList);

    }

}
