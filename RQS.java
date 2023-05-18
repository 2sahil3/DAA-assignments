
import java.util.*;

class RQS
{
    static void giveRandom(int arr[], int low, int high)
    {

        Random rand= new Random();
        int pivot = rand.nextInt(high-low)+low;

        int temp=arr[pivot];
        arr[pivot]=arr[high];
        arr[high]=temp;
    }

    static int Rpart(int arr[], int low, int high)
    {

        giveRandom(arr,low,high);
        int pivot = arr[high];
        int i = (low-1);
        for (int j = low; j < high; j++)
        {

            if (arr[j] < pivot)
            {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }


        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }



    static void sort(int arr[], int low, int high)
    {
        if (low < high)
        {

            int pivot = Rpart(arr, low, high);


            sort(arr, low, pivot-1);
            sort(arr, pivot+1, high);
        }
    }


    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
        {
            System.out.print(arr[i]+" ");
        }

        System.out.println();
    }


    public static void main(String args[])
    {
        Scanner scanner = new Scanner( System.in );
        System.out.println("Enter the length of array: ");
        int n =  scanner.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter the array elements in order and press enter after each:\n");

        for(int i=0;i<n;i++)
        {
            arr[i] =  scanner.nextInt();
        }

        sort(arr, 0, n-1);

        System.out.println("Sorted array");
        printArray(arr);
    }
}
