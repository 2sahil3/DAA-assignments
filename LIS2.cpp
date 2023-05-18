#include <iostream>
#include <vector>
using namespace std;

int lis(vector<int>& arr, int n, int& max_len) {
    if (n == 1) {
        return 1;
    }
    int res, cur_max = 1;
    for (int i = 1; i < n; i++) {
        res = lis(arr, i, max_len);
        if (arr[i-1] < arr[n-1] && res + 1 > cur_max) {
            cur_max = res + 1;
        }
    }
    if (cur_max > max_len) {
        max_len = cur_max;
    }
    return cur_max;
}

int main() {
    int n, max_len = 1;
    vector<int> arr;

    cout << "Enter the size of array" << endl;
    cin >> n;

    arr.resize(n);

    cout << "Enter the elements of array" << endl;

    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }

    lis(arr, n, max_len);

    cout << "The length of longest increasing subsequence is " << max_len << endl;

    return 0;
}

