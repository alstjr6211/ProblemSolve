#include <iostream>
#include <algorithm>

using namespace std;

int main() {
  int N;
  cin >> N;

  int p[N];
  int B[N];
  int num[1001] = {0};
  for (int i = 0; i < N; i++) {
    B[i] = 0;
    cin >> p[i];
    num[p[i]]++;
  }
  
  int cnt = 0;
  for (int i = 1; i < 1001; i++) {
    for (int j = 0; j < num[i]; j++) {
      for (int k = 0; k < N; k++) {
        if (p[k] == i) {
          B[k] = cnt;
          cnt++;
          p[k] = -1;
          break;
        }
      }
    }
  }

  for (int i = 0; i < N; i++) {
    cout << B[i] << " ";
  }
  return 0;
}

