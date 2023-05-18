import java.util.*;

class Palindrome
{
    public static void main(String args[]){

        Scanner scanner = new Scanner( System.in );

        System.out.println("Enter the number: ");
        String input = scanner.nextLine();
        int n = Integer.parseInt( input );

        int r,rev=0,temp;

        temp=n;
        while(n>0){
            r=n%10;
            rev=(rev*10)+r;
            n=n/10;
        }
        if(temp==rev)
            System.out.println("palindrome number ");
        else
            System.out.println("not palindrome");
    }
}  