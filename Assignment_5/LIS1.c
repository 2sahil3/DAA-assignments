#include <stdio.h>

int max(int a, int b)
{
    return (a > b) ? a : b;
}

int lis(int arr[], int n)
{
    int dp[n];
    int i, j, maxLis = 0;

    for (i = 0; i < n; i++)
        dp[i] = 1;

    for (i = 1; i < n; i++)
        for (j = 0; j < i; j++)
            if (arr[i] > arr[j])
                dp[i] = max(dp[i], dp[j] + 1);

    for (i = 0; i < n; i++)
        if (maxLis < dp[i])
            maxLis = dp[i];

    return maxLis;
}

int main()
{
    int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
    int n = sizeof(arr) / sizeof(arr[0]);
    printf("Length of LIS is %d\n", lis(arr, n));
    return 0;
}
