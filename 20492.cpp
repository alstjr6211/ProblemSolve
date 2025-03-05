#include <iostream>

using namespace std;

int main() {
  int N;

  cin >> N;

  int a, b;

  a = N / 100 * 78;
  b = N / 1000 * 956;

  cout << a << " " << b << endl;
}