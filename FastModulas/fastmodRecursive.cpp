#include <iostream>
using namespace std;

int power_recursive(int base, int exponent, int mod)
{
    if (exponent == 0)
    {
        return 1;
    }
    int temp = power_recursive(base, exponent / 2, mod);
    if (exponent % 2 == 0)
    {
        return (temp * temp) % mod;
    }
    else
    {
        return (base * temp * temp) % mod;
    }
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
    int result = power_recursive(base, exponent, mod);
    cout << "(" << base << "^" << exponent << ") mod " << mod << " = " << result << endl;
    return 0;
}
