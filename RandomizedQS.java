
import java.util.*;

class RandomizedQS
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array");
        int n=sc.nextInt();
        int arr[] =new int[n];
        System.out.println("Enter Array");
        for (int i = 0; i < n; ++i)
        arr[i]=sc.nextInt();

        sort(arr, 0, n-1);

        System.out.println("Sorted array");
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i]+" ");
    }
    static void random(int arr[],int low,int high)
    {

        Random rand= new Random();
        int pivot = rand.nextInt(high-low)+low;

        int temp1=arr[pivot];
        arr[pivot]=arr[high];
        arr[high]=temp1;
    }
    static int partition(int arr[], int low, int high)
    {
        random(arr,low,high);
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
            int pi = partition(arr, low, high);
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

}

