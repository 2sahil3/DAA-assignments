#include <iostream>
using namespace std;

int josephus(int n, int k)
{
    int arr[n]; 
    for (int i = 0; i < n; i++)
    {
        arr[i] = i + 1;
    }
    int index = 0;
    while (n > 1)
    {
        index = (index + k - 1) % n; 
        for (int i = index; i < n - 1; i++)
        {
            arr[i] = arr[i + 1]; 
        }
        n--; 
    }
    return arr[0]; 
}

int main()
{
    int n, k;
    cout << "Enter value of n:" << endl;
    cin >> n;
    cout << "Enter value of k:" << endl;
    cin >> k;
    cout << "Survivor: " << josephus(n, k) << endl; // expected output: 4
    return 0;
}
