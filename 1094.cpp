#include <iostream>
#include <algorithm>

using namespace std;

int main() {
  int X;
  cin >> X;
  int K = 64;
  int cnt = 0;
  while(X != 0) {
    if (X - K == 0) {
      cnt++;
      X -= K;
    } else {
      K = K / 2;
      if (X - K >= 0) {
        X -= K;
        cnt++;
      }
    }
  }
  cout << cnt << endl;
  return 0;
}

