// import Scanner
import java.util.Scanner;

public class MoneyConverter {
    public static void main(String[] args) {
        //initialize Scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an amount (ex. '$3.75')");
        String amount = sc.nextLine();
        // print error message if input has incorrect format
        if (!amount.substring(0, 1).equals("$")){
            System.out.println("Invalid input. Please enter in form '$dollars.cents'. Run code again");
        }else {
            //convert amount to double
            double amountNum = Double.parseDouble(amount.substring(1));
            // get integer number of cents by multiplying by 100 and typecasting to int
            int money = (int) (amountNum * 100);
            // use integer division and mod to get coin amounts
            int quarters = money / 25; //num of quarters
            int r1 = money % 25;
            int dimes = r1 / 10;    //num of dimes
            int r2 = r1 % 10;
            int nickels = r2 / 5;   //num of nickels
            int pennies = r2 % 5;   //num of pennies

            //initialize Strings for coin names
            String quarter;
            String nickel;
            String dime;
            String penny;

            // if coin amount is singular, label is singular
            // otherwise plural
            if (quarters == 1) {
                quarter = "quarter";
            } else {
                quarter = "quarters";
            }

            if (dimes == 1) {
                dime = "dime";
            } else {
                dime = "dimes";
            }

            if (nickels == 1) {
                nickel = "nickel";
            } else {
                nickel = "nickels";
            }

            if (pennies == 1) {
                penny = "penny";
            } else {
                penny = "pennies";
            }

            // print final coin amounts
            System.out.println("You have " + quarters + " " + quarter + ", " + dimes + " " + dime +
                    ", " + nickels + " " + nickel + ", and " + pennies + " " + penny);
        }
    }
}
