#include <iostream>
#include <algorithm>

using namespace std;

int main() {
  int a, b;
  cin >> a >> b;
  int sum = abs(((a - 1) / 4) - ((b - 1) / 4));
  sum += abs(((a - 1) % 4) - ((b - 1) % 4));
  cout << sum;
  return 0;
}

