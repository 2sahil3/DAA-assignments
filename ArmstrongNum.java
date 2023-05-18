import java.util.Scanner;

public class ArmstrongNum
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner( System.in );
        System.out.println("Enter number: ");
        String input1 = scanner.nextLine();
        int n = input1.length();
        int number = Integer.parseInt( input1 );

        int originalNumber, remainder, result = 0;

        originalNumber = number;

        while (originalNumber != 0)
        {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, n);
            originalNumber /= 10;
        }

        if(result == number)
            System.out.println(number + " is an Armstrong number.");
        else
            System.out.println(number + " is not an Armstrong number.");

    }

}
