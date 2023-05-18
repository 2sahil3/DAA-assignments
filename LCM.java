import java.util.Scanner;


public class LCM {
    public static void main(String[] args) {


        Scanner scanner = new Scanner( System.in );
        System.out.println("Enter 1st number: ");
        String input1 = scanner.nextLine();
        int n1 = Integer.parseInt( input1 );

        System.out.println("Enter 2nd number: ");
        String input2 = scanner.nextLine();
        int n2 = Integer.parseInt( input2 );



        int gcd = 1;

        for(int i = 1; i <= n1 && i <= n2; i++) {
            // Checks if i is factor of both integers
            if(n1 % i == 0 && n2 % i == 0)
                gcd = i;
        }

        int lcm = (n1 * n2) / gcd;
        System.out.printf("The LCM of %d and %d is %d.", n1, n2, lcm);
    }
}