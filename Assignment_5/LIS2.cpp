#include <iostream>
#include <climits>
using namespace std;

int LIS(int arr[], int i, int n, int prev)
{
	if (i == n)
		return 0;
	int exclude = LIS(arr, i + 1, n, prev);

	
	int include = 0;
	if (arr[i] > prev)
		include = 1 + LIS(arr, i + 1, n, arr[i]);

	return max(include, exclude);
}

int main()
{
	int arr[] = { 10, 22, 9};
	int n = sizeof(arr) / sizeof(arr[0]);

	cout << "Length of the longest increasing subsequence is " 
	<< LIS(arr, 0, n, INT_MIN);

	return 0;
}