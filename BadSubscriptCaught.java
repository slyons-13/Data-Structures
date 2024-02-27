import java.util.Scanner;

public class BadSubscriptCaught {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // create array of names
        String[] names = {"Abby", "Sydney", "Tod", "Ben", "Lucy", "Charlie", "Toby", "Carl", "Nina", "Molly"};
        int index;

        try {
            // get index from user
            System.out.println("Enter an integer index: ");
            index = sc.nextInt();
            //print name at that index
            System.out.println(names[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds.");
        }
    }

}
