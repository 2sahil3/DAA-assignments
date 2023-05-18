#include <iostream>
using namespace std;

int power_iterative(int base, int exponent, int mod)
{
    int result = 1;
    base = base % mod;
    while (exponent > 0)
    {
        if (exponent & 1)
            result = (result * base) % mod;
        exponent = exponent / 2;
        base = (base * base) % mod;
    }
    return result;
}

int main()
{
    int base;
    int exponent;
    int mod;
    cout << "Enter base: \n";
    cin >> base;
    cout << "Enter exponent: \n";
    cin >> exponent;
    cout << "Enter mod: \n";
    cin >> mod;
    int result = power_iterative(base, exponent, mod);
    cout << "(" << base << "^" << exponent << ") mod " << mod << " = " << result << endl;
    return 0;
}
