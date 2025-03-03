#include <iostream>

using namespace std;

int main() {
  int N;
  cin >> N;
  int a, b, c;
  cin >> a >> b >> c;

  if (N - a <= 0) {
    a = N;
  }
  if (N - b <= 0) {
    b = N;
  }
  if (N - c <= 0) {
    c = N;
  }
  cout << a + b + c << endl;
}