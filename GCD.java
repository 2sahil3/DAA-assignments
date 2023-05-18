import java.lang.*;
import java.util.*;

class GCD {
    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner( System.in );
        System.out.println("Enter 1st number: ");
        String input1 = scanner.nextLine();
        int a = Integer.parseInt( input1 );

        System.out.println("Enter 2nd number: ");
        String input2 = scanner.nextLine();
        int b = Integer.parseInt( input2 );

        int g = gcd(a, b);

        if(g == 1)
        {
            System.out.printf("No GCD for %d and %d", a, b);
        }
        else {
            System.out.printf("GCD of %d and %d is %d", a, b, g);
        }

    }
}
