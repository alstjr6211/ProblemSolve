#include <iostream>

using namespace std;

int main() {
  int T;
  cin >> T;

  for (int i = 0; i < T; i++) {
    int N;
    cin >> N;

    int arr_a[N];

    for (int i = 0; i < N; i++) {
      cin >> arr_a[i];
    }

    int stack = 1;

    int arr_b[N];

    for (int i = 0; i < N; i++) {
      while(true) {
        if (arr_a[i] == stack) {
          stack++;
        } else {
          arr_b[i] = stack;
          stack++;
          break;
        }
      }
    }

    cout << arr_b[N - 1] << endl;
  }

  return 0;
}